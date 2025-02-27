import { useState } from "react";
import { predictWinner } from "../api";

const FighterSelector = () => {
  const [fighter1, setFighter1] = useState("");
  const [fighter2, setFighter2] = useState("");
  const [winner, setWinner] = useState<string | null>(null);
  const [error, setError] = useState<string | null>(null);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setWinner(null);
    setError(null);

    if (!fighter1 || !fighter2) {
      setError("Please enter both fighter names.");
      return;
    }

    const result = await predictWinner(fighter1, fighter2);
    if (result.winner) {
      setWinner(result.winner);
    } else {
      setError(result.error || "Prediction failed.");
    }
  };

  return (
    <div className="flex flex-col items-center justify-center h-screen">
      <h1 className="text-3xl font-bold mb-4">UFC Match Predictor</h1>
      <form onSubmit={handleSubmit} className="flex flex-col gap-4">
        <input
          type="text"
          placeholder="Enter Fighter 1"
          value={fighter1}
          onChange={(e) => setFighter1(e.target.value)}
          className="border border-gray-400 p-2 rounded-md"
        />
        <input
          type="text"
          placeholder="Enter Fighter 2"
          value={fighter2}
          onChange={(e) => setFighter2(e.target.value)}
          className="border border-gray-400 p-2 rounded-md"
        />
        <button
          type="submit"
          className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600"
        >
          Predict Winner
        </button>
      </form>
      {winner && <h2 className="mt-4 text-green-500 text-xl">Winner: {winner}</h2>}
      {error && <h2 className="mt-4 text-red-500 text-xl">{error}</h2>}
    </div>
  );
};

export default FighterSelector;
