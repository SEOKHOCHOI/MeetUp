import { Add } from '@material-ui/icons';
import React, { Fragment, useState } from 'react';
import Styles from './Manager.module.scss'
import data from "../misc/mock-data.json"
import {nanoid} from 'nanoid';
import ReadOnly from '../components/manager/ReadOnly';
import Editable from '../components/manager/Editable';

function Manager(){
const [user, setUser] = useState(data);
const [addForm, setAddForm] = useState({
    name:'',
    email:'',
    password:'',
    zipcode:'',
    address:''
})
const [editForm, setEditForm] =useState({
    name:'',
    email:'',
    password:'',
    zipcode:'',
    address:''
})
const [editUserId, setEditUserId] = useState(null);


const handleAddFormChange=(ev)=>{
    ev.preventDefault();
    const filedName = ev.target.getAttribute('name');
    const filedValue= ev.target.value;

    const newFormData = {...addForm};
    newFormData[filedName] =filedValue;
    setAddForm(newFormData);
};

const handleEditFormChange=(ev)=>{
    ev.preventDefault();
    const filedName = ev.target.getAttribute('name');
    const filedValue= ev.target.value;
    const newFormData = {...editForm};
    newFormData[filedName] =filedValue;
    setEditForm(newFormData);
}
const handleAddFormSubmit=(ev)=>{
    ev.preventDefault();
    const newUser={
        id: nanoid(),
        name: addForm.name,
        email:addForm.email,
        password:addForm.password,
        zipcode:addForm.zipcode,
        address:addForm.address
    }

    const newUsers = [...user, newUser];
    setUser(newUsers);
}

const handleEditFormSubmit=(ev)=>{
    ev.preventDefault();
    const EditedUser={
        id: editUserId,
        name: editForm.name,
        email:editForm.email,
        password:editForm.password,
        zipcode:editForm.zipcode,
        address:editForm.address
    }

    const newUsers = [...user];
    const index = user.findIndex((user)=> user.id === editUserId);
    newUsers[index] = EditedUser;
    setUser(newUsers);
    setEditUserId(null);

}
const handleEditClick = (ev, user)=>{
    ev.preventDefault();
    setEditUserId(user.id);

    const formValues={
        name: user.name,
        email:user.email,
        password: user.password,
        zipcode: user.zipcode,
        address:user.address
    }
    setEditForm(formValues);
}


const onCancle=()=>{
    setEditUserId(null);
}

const onDelete=(userid)=>{
    const newUser = [...user];
    const index = user.findIndex((user)=>user.id === userid);
    newUser.splice(index, 1);
    setUser(newUser);

}
return(
    <>
    <div className={Styles.container}>
        <h2>회원관리</h2>
        <form onSubmit={handleEditFormSubmit}>
            <table className={Styles.table_container}>
                <thead>
                    <tr>
                        <th>이름</th>
                        <th>이메일</th>
                        <th>비밀번호</th>
                        <th colSpan="2">주소</th>
                        <th colSpan="2">관리</th>
                    </tr>
                </thead>
                <tbody>
                    {user.map((user) => (
                        <Fragment>
                            {editUserId === user.id ?
                            (<Editable user={user} editForm={editForm} handleEditFormChange={handleEditFormChange} onCancle={onCancle}/>)
                            : 
                            (<ReadOnly user={user} handleEditClick={handleEditClick} onDelete={onDelete}/>)
                            }
                        </Fragment>
                ))}
                </tbody>
            </table>
        </form>


        <h2>회원 등록</h2>
        <form onSubmit={handleAddFormSubmit} className={Styles.addForm}>
            <input type="text" name="name" required="required" placeholder='이름을 입력하세요' onChange={handleAddFormChange}/>
            <input type="text" name="email" required="required" placeholder='이메일을 입력하세요' onChange={handleAddFormChange}/>
            <input type="text" name="password" required="required" placeholder='비밀번호를 입력하세요' onChange={handleAddFormChange}/>
            <input type="text" name="zipcode" required="required" placeholder='우편번호를 입력하세요' onChange={handleAddFormChange}/>
            <input type="text" name="address" required="required" placeholder='상세주소를 입력하세요' onChange={handleAddFormChange} className={Styles.add}/>
            <button type="submit">회원등록</button>
        </form>
      
    </div>

   

</>
)
}
export default Manager