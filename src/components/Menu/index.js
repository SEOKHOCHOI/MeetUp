import {  Route, Routes } from 'react-router-dom';
import Menu from './Menu.js'
import Historypage from '../Historypage';

function  MenuRoute() {
  return (
    <Routes>
      <Route exact path="/" element={<Menu />}/>
      <Route path="test" element={<Test />}/>
      <Route path="/history" element={<Historypage />}/>
    </Routes>
  )
}

function Test (){
  return <h1>테스트 피이지</h1>;
}

export default MenuRoute;