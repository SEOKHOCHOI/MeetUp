import { Route, Routes } from 'react-router-dom';
import Menu from './Menu';

function MenuRoute() {
  return(
    <Routes>
      <Route exact path="/" element={<Menu />} />
      <Route path="test" element={<Tenu />} />
    </Routes>
  );
}

function Tenu() {
  return(
    <div>dddddddddddddddd</div>
  );
}

export default MenuRoute;