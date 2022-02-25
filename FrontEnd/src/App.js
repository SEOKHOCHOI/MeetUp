import './App.scss';
import { BrowserRouter, Route,Routes } from "react-router-dom";
import OpenRoom from './components/OpenRoom.js';
import EnterAddress from './components/EnterAddress.js';
import Main from './components/Main.js';
import Historypage from './components/Historypage.js';
import Nav from './components/Nav';



function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Nav />
      <Routes>
        <Route exact path="/" element={<Main />}/>
        <Route path="/history" element={<Historypage />}/>
        <Route path="/openroom" element={<OpenRoom />}/>
        <Route path="/enteraddress" element={<EnterAddress />}/>
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
