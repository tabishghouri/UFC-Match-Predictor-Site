import { Routes, Route } from "react-router-dom";
import NavBar from "./components/NavBar";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import Fist from "./assets/fist.svg";
import Home from "./pages/Home";
import Fighters from "./pages/Fighters";
import Predictor from "./pages/Predictor";

function App() {
  let items = ["Home", "Fighters", "Predictor"];

  return (
    <div>
      <NavBar
        brandName="UFC Fight Predictor"
        imageSrcPath={Fist}
        navItems={items}
      />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/fighters" element={<Fighters />} />
        <Route path="/predictor" element={<Predictor />} />
      </Routes>
    </div>
  );
}

export default App;
