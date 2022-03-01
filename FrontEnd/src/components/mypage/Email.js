import React from 'react'
import emailjs from 'emailjs-com';
import Styles from "./Email.module.scss"
import { Chat } from '@material-ui/icons';

function Email() {

    const onSendEmail =(ev)=>{
        ev.preventDefault();
        emailjs.sendForm("service_nmjvior","template_5acjr6f",ev.target,"ZaXrGwr47T5D0wMqN").then(res=>{
            console.log(res);
        }).catch(err=>console.log(err));
        ev.target.reset();
    }
  return (
    <div className={Styles.contact_container}>
        <h1><Chat style={{color:"#f2a341", fontSize:"28px"}}/> 1대1 문의하기</h1>
        <form onSubmit={onSendEmail}>
            <div>
                <input type="text" name="name" placeholder='이름'/>
            </div>
            <div>
                <input type="email" name="user_email" placeholder='이메일 주소' required/>
            </div>
            <div>
                <textarea id="message" name="message" rows="10" placeholder='문의사항을 입력해주세요.' />
            </div>
            <input type="submit" value="전송" className={Styles.submitBtn}/> 
        </form>
    </div>
  )
}

export default Email