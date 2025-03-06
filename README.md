# UFC Match Predictor - Full Stack Application

## **Overview**
The **UFC Match Predictor** is a full-stack web application that predicts the winner between two UFC fighters based on historical data and machine learning models. This project is built using **Spring Boot**, **FastAPI**, **React (Vite + TypeScript)**, and **PostgreSQL**.

## **Features**
- **Data scraping**: Engineered a comprehensive data scraping of fighter stats from over 4000 fighters using python and pandas
- **Fight Outcome Prediction**: Built an ML model using scikit-learn by integrating data scraping and pandas to predict UFC fight winner based on stats and metrics
- **Database**: Real-time data manipulation using SQL queries within a Postgres database  

Check out the predictor code [here](https://github.com/tabishghouri/UFC-match-predictor)
Check out the scraping code [here](https://github.com/tabishghouri/UFC-scraper)

## **Tech Stack**
### **Backend (Spring Boot)**
- Java 17 + Spring Boot
- Hibernate (JPA) + PostgreSQL
- REST API with **CORS enabled** for frontend communication
- Maven for dependency management

### **Frontend (React)**
- React with **Vite + TypeScript**
- Axios for API requests
- Bootstrap for UI components
- React Router for navigation

### **Machine Learning Service (FastAPI)**
- **FastAPI** for serving the prediction model
- **Scikit-learn** for loading and predicting with a trained **RandomForestClassifier**
- **Pandas + NumPy** for data preprocessing
- **Joblib** for model persistence

---

## **Getting Started**
### **1️. Clone the Repository**
```sh
git clone https://github.com/yourusername/UFC-Predictor-Site.git
cd UFC-Predictor-Site
```

### **2. Setup PostgreSQL Database**
- Create the dataset
```sql
CREATE DATABASE ufc_stats;
```
- Import dataset
```sh
\COPY fighter_statistic FROM 'data/cleaned_fighter_data.csv' DELIMITER ',' CSV HEADER;
```

### **3. Start the Backend (Spring Boot)**
Navigate to the backend folder
```sh
cd backend
```
Configure application.properties
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ufc_stats
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```
Run the backend
```sh
mvn spring-boot:run
```
The API will start at http://localhost:8080/api/v1/fighter

### **4. Start the FastAPI Prediction Service**
Navigate to the service folder
```sh
cd service
```
Install dependencies
```sh pip install -r requirements.txt
```
Run the FastAPI service
```sh
uvicorn main:app --reload
```
The prediction API will start at http://localhost:5000/predictor

### **5. Start the Frontend (React)**
Navigate to the frontend folder
```sh
cd frontend
```
Install dependencies
```sh
npm install
```
Run the frontend
```sh
npm run dev
```
The UI will be available at http://localhost:5173








