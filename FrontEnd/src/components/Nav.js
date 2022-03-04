import Styles from './Nav.module.scss';
import {Link} from 'react-router-dom';
import { useState } from 'react';


function Nav() {
    let [close, closeset] = useState(false);

    return (

        <div className= {Styles.nav}>

          <div className={Styles.nav_in}>
            <p className={Styles.nav_logo}>
                <Link to = "/">
                    Meet Up
                </Link>
            </p>
                <div className={Styles.overlay}>
                    <input className={Styles.check} type="checkbox" id="menuicon"/>
                    <label for = "menuicon">
                        <span></span>
                        <span></span>
                        <span></span>
                    </label>
                    <div className={Styles.sidebar}>
                    {
                        close === false
                        ? <Sidebar close={closeset}/>
                        : null
                    }
              </div>  
            </div>
        </div>
        </div>
        

    );
}
function Sidebar(props){
            return(
            <div className={Styles.menu}>
                        <label for="menuicon">
                            <ul>
                                <li className={Styles.home}>
                                    <Link to = "/" className={Styles.menu_item} onClick={() =>  {props.closeset(!props.close)}}>
                                        홈
                                    </Link>
                                </li>
                                <li><Link to ="mypage" className={Styles.menu_item} onClick={() =>  {props.closeset(!props.close)}}>마이페이지</Link></li>
                                <li>
                                    <Link to = "/history" className={Styles.menu_item} onClick={() =>  {props.closeset(!props.close)}}>
                                        히스토리
                                    </Link>
                                </li>
                                <li><Link to = "logout" className={Styles.menu_item} onClick={() =>  {props.closeset(!props.close)}}>로그아웃</Link></li>
                            </ul>
                            <label for="menuicon" className={Styles.back}/>
                        </label>
                        </div>
            )
        }
export default Nav;