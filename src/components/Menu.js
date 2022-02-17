import React from 'react';
import { useHistory } from 'react-router-dom';
import { VscChromeClose } from "react-icons/vsc";
import './Menu.scss';
import {Link} from 'react-router-dom';

function Menu() {
    let history = useHistory();
    return (
    <>
        <div className='overlay'>
            <VscChromeClose className='xicon' onClick={() => {history.goBack()}}/>
            <div className='menu'>
                <ul>
                    <li>
                        <Link to = "/">
                            홈
                        </Link>
                    </li>
                    <li><a href='#'>마이페이지</a></li>
                    <li>
                        <Link to = "/history">
                            히스토리
                        </Link>
                    </li>
                    <li><a href='#'>로그아웃</a></li>
                </ul>
            </div>
        </div>        
    </>
    );
}

export default Menu;