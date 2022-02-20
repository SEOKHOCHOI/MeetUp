import { Route, Routes } from 'react-router-dom';


function MenuRoute() {
  return(
    <Routes>
      {/* Menu 컴포넌트 있던 자리입니다. */}
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