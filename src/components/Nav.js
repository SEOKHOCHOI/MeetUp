import './Nav.scss';
import { HiMenu } from "react-icons/hi";
import {Link } from 'react-router-dom';



function Nav() {
    return (
        <div className='nav'>
            <p className='nav-logo'>Meet Up</p>
            <Link to = "/menu">
                <HiMenu className='nav-icon'/>
            </Link>
        </div>

    );
}

export default Nav;