/*eslint-disable*/
import React from 'react';
import Styles from './Main.module.scss';
import Nav from './Nav.js';
import {Link} from 'react-router-dom';


function Main() {

  return (
    <div className= {Styles.App}>
      <Nav/>
      <div className= {Styles.content}>
        <div className= {Styles.explain}>
          <span>약속 장소는 <span className= {Styles.highlighter}>Meet Up</span>!</span>
          <p>이젠 중간 지점에서 만나세요</p>
        </div>
        
        <img className= {Styles.displayimg} src={require('../img/display_img1.jpg')}/>

        <Link to = "/openroom">
          <button className= {Styles.create} type='button'>
            방 만들기
          </button>
        </Link>

        <div>*) 3장 사진을 슬라이드 효과와 함께 넣을 예정입니다<br></br>
          <img src={require('../img/iphone12pro_3.png') }className={Styles.img_mockup}/>
        </div>

        <div className= {Styles.explain_mockup}>
          
          <span>어디서 만나는게 좋을까?</span>
          <p>Meet Up은 모임원들의 중간 지점을 찾아 <br/>최적의 장소를 추천해 드립니다.</p>
        </div>
      </div>

    </div>
  );
}

export default Main;