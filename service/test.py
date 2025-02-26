import joblib

# Load the trained model
model = joblib.load("model/fighter_predictor_model.pkl")

# Print the number of expected features
print("Expected number of features:", model.n_features_in_)

# Print the model parameters to see how it was trained
print(model.get_params())
