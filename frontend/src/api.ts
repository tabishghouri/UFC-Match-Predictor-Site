import axios from "axios";

const FASTAPI_URL = "http://127.0.0.1:8000";
const SPRINGBOOT_URL = "http://localhost:8080";

export const predictWinner = async (fighter1: string, fighter2: string) => {
  try {
    const response = await axios.post(`${FASTAPI_URL}/predictor`, {
      fighter1,
      fighter2,
    });
    return response.data;
  } catch (error) {
    console.error("Error predicting winner:", error);
    return { error: "Prediction failed. Check backend logs." };
  }
};

export const getFighters = async () => {
  try {
    const response = await axios.get(`${SPRINGBOOT_URL}/api/v1/fighter`);
    return response.data;
  } catch (error) {
    console.error("Error fetching fighters:", error);
    return [];
  }
};
