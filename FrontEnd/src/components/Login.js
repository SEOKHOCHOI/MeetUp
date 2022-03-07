import React, { useState } from "react";
import Styles from "./Login.module.scss";
import Main from "./Main.module.scss";

function Login() {
  const [loginCheck, setLoginCheck] = useState(false);

  return (
    <div className={Styles.social}>
      <div className={Main.explain}>
        <br />
        <br />
        <br />
        <br />
        <div className={Styles.name}>
          <span>
            약속 장소는 <span className={Main.highlighter}>Meet Up</span>!
          </span>
        </div>
      </div>
      <div className={Styles.wrap}>
        <div className={Styles.kakao}>
          <button type="submit">
            <img src={require("../img/kakao_logo.png")} />
            <span>카카오로 로그인하기</span>
          </button>
        </div>
        <div className={Styles.naver}>
          <button type="submit">
            <img src={require("../img/naver_logo.png")} />
            <span>네이버로 로그인하기</span>
          </button>
        </div>
        <div className={Styles.google}>
          <button type="submit">
            <img src={require("../img/google_logo.png")} />
            <span>구글로 로그인하기</span>
          </button>
        </div>
        <div className={Styles.checkbox}>
          <input type="checkbox" id="autoLogin" />
          <label htmlFor="autoLogin">
            <span>자동 로그인</span>
          </label>
        </div>
      </div>
    </div>
  );
}

export default Login;
