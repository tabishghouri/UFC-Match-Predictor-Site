import axios from "axios";

const API_URL = "http://localhost:5000";

export const predictWinner = async (fighter1: string, fighter2: string) => {
    try {
      const response = await axios.post(`${API_URL}/predictor`, {
        fighter1,
        fighter2,
      });
      return response.data;
    } catch (error) {
      console.error("Error predicting winner:", error);
      return { error: "Prediction failed. Check backend logs." };
    }
  };