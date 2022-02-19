import Styles from './Nav.module.scss';
import { HiMenu } from "react-icons/hi";
import {Link } from 'react-router-dom';

function Nav() {
    return (
        <div className= {Styles.nav}>
            <p className={Styles.nav_logo}>Meet Up</p>
            <Link to = "/menu">
                <HiMenu className= {Styles.nav_icon}/>
            </Link>
        </div>

    );
}

export default Nav;