/*eslint-disable*/
import React, { useState } from "react";
import Styles from "./OpenRoom.module.scss";
import { Link } from "react-router-dom";

function OpenRoom() {
  const [roomTitle, setRoomTitle] = useState("");
  const [place, setPlace] = useState("");
  const [totalNum, setTotalNum] = useState(1);
  const [titleError, setTitleError] = useState("");

  const resetForm = () => {
    setRoomTitle("");
  };

  const validateForm = () => {
    resetErrors();
    let validated = true;
    if (roomTitle.length < 3) {
      setTitleError("3글자 이상 입력 해주세요.");
      validated = false;
    }

    return validated;
  };
  const resetErrors = () => {
    setTitleError("");
  };

  const onSubmit = (e) => {
    e.preventDefault();
    // 통신시도하기전에 값들이 제대로 들어갔는지에 대한 확인을 한후
    //잘됐으면 통신 or 잘안됐으면 입력값 확인하라고 알려줄것
    if (validateForm()) {
      alert("submitted");

      //통신 성공시 navigate
      // 통신 비성공시 오류 가났다는것을 알려주기
      // 이부분이 서버로제출
      resetErrors();
      resetForm();
    }
  };
  return (
    <div className={Styles.open_room}>
      <form onSubmit={onSubmit}>
        <div className={Styles.main}>
          <div>
            <section className={Styles.room_name_top}>
              <h6>방 제목</h6>
              <input
                required
                type="text"
                maxLength="10"
                autoFocus="on"
                placeholder="제목을 입력해주세요!"
                value={roomTitle}
                onChange={(e) => {
                  setRoomTitle(e.target.value);
                }}
              />
              <div>{titleError}</div>
            </section>
            <h6 id={Styles.place_title}>장소</h6>
            <section className={Styles.place_top}>
              <label>
                <input type="radio" name="place" value="cafe" />
                <span>카페</span>
              </label>
              <label>
                <input type="radio" name="place" value="" />
                <span>산</span>
              </label>
              <label>
                <input type="radio" name="place" value="" />
                <span>동산</span>
              </label>
              <label>
                <input type="radio" name="place" value="" />
                <span>뒷산</span>
              </label>
              <label>
                <input type="radio" name="place" value="" />
                <span>앞산</span>
              </label>
              <label>
                <input type="radio" name="place" value="" />
                <span>옆산</span>
              </label>
            </section>
            <input
              id={Styles.place_input}
              type="text"
              maxLength="10"
              placeholder="장소를 입력해주세요!"
              value={place}
              onChange={(e) => {
                setPlace(e.target.value);
              }}
            />
            <button id={Styles.place_btn}>검색</button>
          </div>
          <h6 id={Styles.num_title}>인원수</h6>
          <div className={Styles.num}>
            <button
              type="button"
              onClick={() => {
                totalNum >= 2 && setTotalNum(totalNum - 1);
              }}
            >
              -
            </button>
            <input
              type="number"
              maxLength="2"
              placeholder="인원수"
              value={totalNum}
              onChange={(e) => {
                setTotalNum(e.target.value);
              }}
            />
            <button
              id={Styles.plus}
              type="button"
              onClick={() => setTotalNum(totalNum + 1)}
            >
              +
            </button>
          </div>
        </div>
        <div className={Styles.footer}>
          <button type="submit" onClick={onSubmit}>
            URL 공유하기
          </button>
        </div>
      </form>
    </div>
  );
}

export default OpenRoom;
