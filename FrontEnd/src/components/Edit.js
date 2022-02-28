import React, { useState } from 'react'
import Nav from './Nav'
import Address from './mypage/address';
import Styles from './Edit.module.scss';
function Edit(){
    // const [name, setName]=useState("");
    // const [email, setEmail] = useState('');
    const [nickName, setNickName] = useState("재롱이");
    const [address, setAddress] = useState('서울시 종로구');
    const [zipcode, setZipcode] = useState("30100");
    const [isPopup, setIsPopup]= useState(false);
    const [email, setEmail] = useState("");
   
    const onNickNameChange =(ev)=>{
        const {target:{value}}= ev;
    }

    const onPopup=()=>{
        setIsPopup(!isPopup);
    }
    const onAddChange=(ev) =>{
        const{target:{value}}= ev;
        setAddress(value);
    };
    const onZipcodeChange=(ev) =>{
        const{target:{value}}= ev;
        setZipcode(value);
    };
    const onEmailChange=(ev) =>{
        const{target:{value}}= ev;
        setEmail(value);
    };

    
    const onSubmit=()=>{

    }

return(
    <>
    <Nav/>
    <div className={Styles.profile_container}>
       <div className={Styles.modify_title}>
        <h3>프로필</h3>
       </div>
       <form onSubmit={onSubmit}>
           <div>
               <div />
           </div>
           <div>
            <label htmlFor='nickname'>닉네임 :</label>
            <input id="nickname" type="text" value={nickName} onChange={onNickNameChange}/>
           </div>
             <button type="submit">변경하기</button>
       </form>
    </div>
    <div className={Styles.address_container}>
       <div className={Styles.modify_title}>
        <h3>주소</h3>
       </div>
       <form onSubmit={onSubmit}>
           <div className={Styles.zipcode}>
                <label htmlFor='zipcode'>우편번호 :</label>
                <input id="zipcode" type="text" value={zipcode} onChange={onZipcodeChange}/>
                <button type='button' onClick={onPopup}>주소 찾기</button>
           </div>
         { isPopup&& 
         <Address address={address} zipcode={zipcode} setAddress={setAddress} setZipcode={setZipcode}/>
         }
         <div className={Styles.addDetail}>
             <div>
                <label htmlFor='address'>상세주소 :</label>
                <input id="address" value={address} onChange={onAddChange}/>
             </div>    
         </div>
             <button type="submit">변경하기</button>
       </form>
    </div>
    <div className={Styles.email_container}>
       <div className={Styles.modify_title}>
        <h3>이메일</h3>
       </div>
       <form onSubmit={onSubmit}>
           <input type="text" value={email} onChange={onEmailChange}/>
           <button type='submit'>변경하기</button>
       </form>
    </div>
    <div className={Styles.btn_container}>
        <button className={Styles.withdrawal_btn}>탈퇴하기</button>
    </div>
    </>
)
}
export default Edit