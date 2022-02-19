import React from 'react';
import Styles from './EnterAddress.module.scss';

function EnterAddress() {
  return(
    <div className={Styles.enter_address}>
      <header className={Styles.navbar}>
        <nav>navbar자리.</nav>
      </header>
      <main>
        <h4 id={Styles.room_name}>방이름</h4>
        <section>
          <div className={Styles.address_btn}>
            <button onClick={()=>{}}>지정 <br /> 위치</button>
            <button onClick={()=>{}}>현재 <br /> 위치</button>
            <button onClick={()=>{}}>직접 <br /> 입력</button>
          </div>
        </section>
        <aside className={Styles.member_top}>
          <p id={Styles.member}>3/n</p>
        </aside>
      </main>
      <footer className={Styles.end_top}>
        <button id={Styles.end} onClick={()=>{}}>완료</button>
      </footer>
    </div>
  );
}

export default EnterAddress;