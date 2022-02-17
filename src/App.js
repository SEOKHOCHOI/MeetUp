import './App.scss';
import { BrowserRouter, Route, Switch } from "react-router-dom";
import OpenRoom from './components/OpenRoom.js';
import EnterAddress from './components/EnterAddress.js';
import Main from './components/Main.js';
import Menu from './components/Menu.js';
import Historypage from './components/Historypage.js';




function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Switch>
        <Route exact path="/" component={Main}/>
        <Route path="/menu" component={Menu}/>
        <Route path="/history" component={Historypage}/>
        <Route path="/openroom" component={OpenRoom}/>
        <Route path="/enteraddress" component={EnterAddress}/>
      </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
