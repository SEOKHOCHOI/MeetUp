import "./App.scss";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import OpenRoom from "./components/OpenRoom.js";
import EnterAddress from "./components/EnterAddress.js";
import Main from "./components/Main.js";
import Historypage from "./components/Historypage.js";
import Manager from "./Pages/Manager";
import Mypage from "./Pages/Mypage";
import Edit from "./components/mypage/Edit";
import Nav from "./components/Nav";
import Email from "./components/mypage/Email";
import MapView from "./components/MapView";
import Login from "./components/Login";
import ErrorPage from "./components/ErrorPage";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Nav />
        <Routes>
          <Route exact path="/" element={<Main />} />
          <Route path="/history" element={<Historypage />} />
          <Route path="/openroom" element={<OpenRoom />} />
          <Route path="/enteraddress" element={<EnterAddress />} />
          <Route path="/manager/*" element={<Manager />} />
          <Route path="/mypage" element={<Mypage />} />
          <Route path="/mypage/edit" element={<Edit />} />
          <Route path="/mypage/contact" element={<Email />} />
          <Route path="/mapview" element={<MapView />} />
          <Route path="/login" element={<Login />} />
          <Route path="/:otherpage" element={<ErrorPage />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
