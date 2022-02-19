/*eslint-disable*/
import React, {useState} from 'react';
import Styles from './Historypage.module.scss';
import Nav from './Nav.js';

function Historypage() {
    let [name, nameset] = useState(['테스트방', 'npc 모임']);
    let [people, peopleset] = useState(['3', '9']);
    let [ing, ingset] = useState(['참여중', '종료'])
    let [place, placeset] = useState(['카페', '음식점']);
    
    return(
        <div className= {Styles.history}>
            <Nav/>
            <div className= {Styles.row}>
                {
                    name.map((a, i)=>{
                        return <Card name={name[i]} people={people[i]} ing = {ing[i]} 
                        place={place[i]} key={i}/>
                    })
                }
            </div>
        </div>
    );

    
}

function Card (props){
    return(
        <div className= {Styles.col}>
            <span> &lt; {props.name} &gt; </span> <span className={Styles.ing}>{props.ing}</span><br/>
            <span>인원수: {props.people}명</span><br/>
            <span>장소: {props.place}</span>
        </div>
    );
}

export default Historypage;