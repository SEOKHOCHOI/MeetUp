import React, { useState } from "react";
import Styles from "./ErrorPage.module.scss";
import { Link } from "react-router-dom";

function ErrorPage() {
  return (
    <div className={Styles.error}>
      <img src={require("../img/404-error.png")} />
      <div className={Styles.alert}>
        <h3>404 ERROR!</h3>
        <p>
          페이지가 존재하지 않거나, 사용할 수 없는 페이지입니다.
          <br />
          입력하신 주소가 정확한지 다시 한 번 확인해주세요.
        </p>
      </div>
      <Link to="/">
        <button className={Styles.create} type="button">
          메인으로 돌아가기
        </button>
      </Link>
    </div>
  );
}

export default ErrorPage;
