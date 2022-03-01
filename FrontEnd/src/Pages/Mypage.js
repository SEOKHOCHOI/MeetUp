import { Chat, EditOutlined, FormatListBulleted} from '@material-ui/icons';
import React, { useState } from 'react';
import { HiQuestionMarkCircle } from 'react-icons/hi';
import { Link,} from 'react-router-dom';
import Styles from './Mypage.module.scss'
import Nav from '../components/Nav';

function Mypage(){
    const [fold, setFold] = useState(false);
    const onClick=(e)=>{
        setFold(prev =>!prev);
    }
    return(
        <>
            <Nav />
            <div className={Styles.profile_container}>
                    <span>재롱이님 환영합니다👋</span>
            </div>
            <div className={Styles.mypage_container}>
                <div className={Styles.mypage_detail}>
                    <FormatListBulleted />
                    <Link to="/history">
                        <span className={Styles.mypage_title}>나의 히스토리</span>
                    </Link>
                </div>
                <div className={Styles.mypage_detail}>
                    <EditOutlined />
                    <Link to="edit">
                        <span className={Styles.mypage_title}>나의 정보 수정</span>
                    </Link>
                </div>
                <div className={Styles.mypage_detail}>
                    <Chat />
                    <span className={Styles.mypage_title}>1대1 문의 하기</span>
                </div>
                <div className={Styles.mypage_detail} >
                    <div onClick={onClick}>
                        <HiQuestionMarkCircle />
                        <span className={Styles.mypage_title}>자주 묻는 질문</span>
                    </div>
                    <div className={`${Styles.unfold}${fold?'active':''}`}> 
                        <div className={Styles.question_container}>
                        {[1, 2, 3, 4, 5, 6].map((_, i) => (
                            <details className={Styles.question_list} key={i}>
                                <summary>아이디는 어떻게 찾나요?</summary>
                                <span>나도 몰라요</span>
                            </details>
                        ))}
                        </div>
                    </div> 
                </div>
            </div>
        </>
        
        
    )
}
export default Mypage