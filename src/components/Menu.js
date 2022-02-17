import React from 'react';
import { useHistory } from 'react-router-dom';
import { VscChromeClose } from "react-icons/vsc";
import Style from './Menu.module.scss';
import {Link} from 'react-router-dom';

function Menu() {
    let history = useHistory();
    return (
    <>
        <div className={Style.overlay}>
            <VscChromeClose className={Style.xicon} onClick={() => {history.goBack()}}/>
            <div className={Style.menu}>
                <ul>
                    <li>
                        <Link to = "/">
                            홈
                        </Link>
                    </li>
                    <li><Link to ="mypage">마이페이지</Link></li>
                    <li>
                        <Link to = "/history">
                            히스토리
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