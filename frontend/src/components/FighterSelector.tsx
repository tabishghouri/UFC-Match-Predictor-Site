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
    <div className="container d-flex flex-column align-items-center justify-content-center vh-100">
      <h1 className="text-center fw-bold mb-4">UFC Match Predictor</h1>

      <form onSubmit={handleSubmit} className="w-50">
        {/* Bootstrap Grid Row */}
        <div className="row mb-3">
          <div className="col">
            <input
              type="text"
              className="form-control"
              placeholder="Enter Fighter 1"
              value={fighter1}
              onChange={(e) => setFighter1(e.target.value)}
            />
          </div>
          <div className="col">
            <input
              type="text"
              className="form-control"
              placeholder="Enter Fighter 2"
              value={fighter2}
              onChange={(e) => setFighter2(e.target.value)}
            />
          </div>
        </div>

        <button type="submit" className="btn btn-primary w-100">
          Predict Winner
        </button>
      </form>

      {winner && (
        <h2 className="mt-4 text-success text-center">Winner: {winner}</h2>
      )}
      {error && (
        <h2 className="mt-4 text-danger text-center">{error}</h2>
      )}
    </div>
  );
};

export default FighterSelector;
