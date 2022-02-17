import React from 'react';
import './Main.scss';
import Nav from './Nav.js';
import {Link} from 'react-router-dom';

function Main() {

  return (
    <div className="App">
      <Nav/>
      <div className='content'>
        <div className='explain'>
          <span>약속 장소는 <span className='highlighter'>Meet Up</span>!</span>
          <p>이젠 중간 지점에서 만나세요</p>
        </div>
        
        <img className='displayimg' src={require('./img/display_img1.jpg')}/>
        <Link to = "/openroom">
          <button className='create' type='button'>
            방 만들기
          </button>
        </Link>

{/* 
        <div className='imgContainer'>
          <div className='img_mockup'>
            <img src={require('./ipone12pro_1.png')}/>
          </div>
          <div className='img_mockup'>
            <img src={require('./ipone12pro_2.png')}/>
          </div>
          <div className='img_mockup'>
            <img src={require('./ipone12pro_3.png')}/>
          </div>

          <button className='button1'>1</button>
          <button className='button2'>2</button>
          <button className='button3'>3</button>

        </div> */}
        <div>*) 3장 사진을 슬라이드 효과와 함께 넣을 예정입니다<br></br>
          <img src={require('./img/iphone12pro_3.png') }className='img_mockup'></img>
        </div>

        <div className='explain_mockup'>
          
          <span>어디서 만나는게 좋을까?</span>
          <p>Meet Up은 모임원들의 중간 지점을 찾아 <br/>최적의 장소를 추천해 드립니다.</p>
        </div>
      </div>

      {/* <div className='bottombox'>
        <p>@ 나중에 넣을 내용 있으면 추가할 박스</p>
      </div> */}
      
    </div>
  );
}

export default Main;