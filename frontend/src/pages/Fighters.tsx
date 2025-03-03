import { useEffect, useState } from "react";
import { getFighters } from "../api";

interface Fighter {
  fighterName: string;
  heightCm: number | null;
  weightPounds: number | null;
  stance: string | null;
  winRate: number | null;
  lossRate: number | null;
  careerSLpM: number | null;
}

const Fighters = () => {
  const [fighters, setFighters] = useState<Fighter[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchFighters = async () => {
      const data = await getFighters();
      setFighters(data);
      setLoading(false);
    };

    fetchFighters();
  }, []);

  return (
    <div className="container mt-4">
      <h1 className="text-center">Fighter List</h1>
      {loading ? (
        <p className="text-center">Loading fighters...</p>
      ) : (
        <table className="table table-striped table-bordered">
          <thead className="table-dark">
            <tr>
              <th>Fighter Name</th>
              <th>Height (cm)</th>
              <th>Weight (lbs)</th>
              <th>Stance</th>
              <th>Win Rate (%)</th>
              <th>Loss Rate (%)</th>
              <th>Strikes Landed Per Min</th>
            </tr>
          </thead>
          <tbody>
            {fighters.map((fighter) => (
              <tr key={fighter.fighterName}>
                <td>{fighter.fighterName}</td>
                <td>{fighter.heightCm ?? "N/A"}</td>
                <td>{fighter.weightPounds ?? "N/A"}</td>
                <td>{fighter.stance ?? "N/A"}</td>
                <td>{fighter.winRate ?? "N/A"}%</td>
                <td>{fighter.lossRate ?? "N/A"}%</td>
                <td>{fighter.careerSLpM ?? "N/A"}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default Fighters;
