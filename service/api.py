from fastapi import FastAPI, HTTPException
from fastapi.responses import JSONResponse
from pydantic import BaseModel
import pandas as pd
import numpy as np
import joblib 
from sklearn.preprocessing import LabelEncoder, StandardScaler

app = FastAPI()


model = joblib.load('model/fighter_predictor_model.pkl')

file_path = 'data/cleaned_fighter_data.csv'
new_data = pd.read_csv(file_path, encoding='latin-1')

# Add a default value for 'career_KD_Avg'
new_data['career_KD_Avg'] = 0.0  # or any other default value

new_data['stance'] = new_data['stance'].astype(str)

# Encode categorical columns
le = LabelEncoder()
new_data['stance'] = le.fit_transform(new_data['stance'])

# Convert percentages to numerical data
for col in ['win_rate', 'loss_rate', 'draw_rate', 'dc_nc_rate', 'career_StrDef', 'career_TD_Acc', 'career_TD_Def']:
    new_data[col] = new_data[col].astype(str).str.replace('%', '').astype(float) / 100

# Convert fighter names to lowercase for case-insensitive comparison
# fighter_stats = {row['fighter_name'].lower(): row for _, row in new_data.iterrows()}
fighter_stats = {row['fighter_name'].lower(): row.fillna(0) for _, row in new_data.iterrows()}



# using pydantic as its a data validation library that fastAPI uses to validate API requests, so making sure the data is correct before processing
class FighterInput(BaseModel):
    # makes sure that when a user sends a request, it includes the following:
    fighter1: str
    fighter2: str


def compute_features(f1, f2):
    """Find numerical differences between two fighters' stats."""
    f1_stats = fighter_stats[f1.lower()]
    f2_stats = fighter_stats[f2.lower()]
    features = {}
    for col in new_data.columns:
        if new_data[col].dtype in [float, int] and col != 'fighter_name':
            features[f"{col}_diff"] = abs(f1_stats[col] - f2_stats[col])

    features.pop("career_KD_Avg_diff", None)

    print("Generated Features:", list(features.keys()))
    print("Number of Features Sent to Model:", len(features))
    
    return features 

@app.get('/')
def home():
    return {'message': 'UFC Match Predictor API Running...'}

@app.post('/predictor')
def predict_winner(input_data: FighterInput):
    try:
        f1, f2 = input_data.fighter1, input_data.fighter2

        if f1.lower() not in fighter_stats or f2.lower() not in fighter_stats:
            raise HTTPException(status_code=400, detail="One or both fighters not found in the dataset.")

        match_features = compute_features(f1, f2)
        match_features_df = pd.DataFrame([match_features])

        # Scale features using the same scaler from training
        scaler = StandardScaler()
        match_features_scaled = scaler.fit_transform(match_features_df)

        # Predict match outcome
        prediction = model.predict(match_features_scaled)[0]
        winner = f1 if prediction == 1 else f2

        return {"winner": winner}

    except Exception as e:
        print("Error:", str(e))  # Print the exact error in logs
        return JSONResponse(status_code=500, content={"detail": str(e)})
