import React from 'react';
import { useNavigate,Link } from 'react-router-dom';
import { VscChromeClose } from "react-icons/vsc";
import Style from './Menu.module.scss';

function  Menu() {
    let navigate = useNavigate();
    return (
    <>
        <div className={Style.overlay}>
            <VscChromeClose className={Style.xicon} onClick={() => {navigate(-1)}}/>
            <div className={Style.menu}>
                <ul>
                    <li>
                        <Link to = "/">
                            홈
                        </Link>
                    </li>
                    <li><Link to ="/mypage">마이페이지</Link></li>
                    <li>
                        <Link to = "/history">
                            히스토리
                        </Link>
                    </li>
                    <li>
                        <Link to = "test">
                            테스프페이지
                        </Link>
                    </li>
                    <li><Link to = "logout">로그아웃</Link></li>
                </ul>
            </div>
        </div>        
    </>
    );
}

export default Menu;