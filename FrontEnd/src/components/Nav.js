import Styles from './Nav.module.scss';
import { useNavigate } from 'react-router-dom';
import {Link} from 'react-router-dom';


function Nav() {
    
    let navigate = useNavigate();

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
                        <div className={Styles.menu}>
                            <ul>
                                <li className={Styles.home}>
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

              </div>  
            </div>
        </div>

    );
}

export default Nav;