/*eslint-disable*/
import React, { useState } from 'react';
import Styles from "./OpenRoom.module.scss";

function OpenRoom() {

  const [roomTitle, setRoomTitle] = useState('');
  const [place, setPlace] = useState('');
  const [totalNum, setTotalNum] = useState('');
  const [titleError, setTitleError] = useState('');

  const resetForm = () => {
    setRoomTitle('');
  };

  const validateForm = () => {
    resetErrors();
    let validated = true;
    if (!roomTitle) {
      setTitleError('제목은 필수입니다!');
      validated = false;
    }

    return validated;
  }
  const resetErrors = () => {
    setTitleError('');
  };
  const onSubmit = (e) => {
    e.preventDefault();
    if (validateForm()) {
      alert('submitted')
      // 이부분이 서버로제출
      resetErrors();
      resetForm();
    }
  };
  return(
    <div className={Styles.open_room}>
      <form onSubmit={onSubmit}>
        <main className={Styles.main}>
          <article>
            <section className={Styles.room_name_top}>
              <h6>방 제목</h6>
              <input 
                required
                type="text" 
                maxLength="10"
                autoFocus="on"
                placeholder="제목을 입력해주세요!" 
                value={roomTitle} 
                onChange={(e) => {setRoomTitle(e.target.value)}}
              />
              <div>{titleError}</div>
            </section>
            <h6 id={Styles.place_title}>장소</h6>
            <section className={Styles.place_top}>
              <label><input type="radio" name="place" value="cafe" /><span>카페</span></label>
              <label><input type="radio" name="place" value="" /><span>산</span></label>
              <label><input type="radio" name="place" value="" /><span>동산</span></label>
              <label><input type="radio" name="place" value="" /><span>뒷산</span></label>
              <label><input type="radio" name="place" value="" /><span>앞산</span></label>
              <label><input type="radio" name="place" value="" /><span>옆산</span></label>
            </section>
            <input 
                id={Styles.place_input}
                type="text" 
                maxLength="10"
                placeholder="장소를 입력해주세요!" 
                value={place} 
                onChange={(e) => {setPlace(e.target.value)}}
              />
            <button id={Styles.place_btn}>검색</button>
          </article>
          <h6 id={Styles.num_title}>인원수</h6>
          <aside>
            <button onClick={()=>{}}>-</button>
            <input
              required
              type="number"
              maxLength="2"
              placeholder="인원수"
              value={totalNum}
              onChange={(e)=>{setTotalNum(e.target.value)}}
            />
            <button id={Styles.plus} onClick={()=>{}}>+</button>
          </aside>
        </main>
        <footer>
          <button type="submit">URL 공유하기</button>
        </footer>
      </form>
    </div>
  );
}

export default OpenRoom;