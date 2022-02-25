import { Delete, Edit } from '@material-ui/icons'
import React from 'react'
import Styles from '../Manager.module.scss'

const ReadOnly =({user, handleEditClick, onDelete})=>{
    return(
        <tr>
            <td>{user.name}</td>
            <td>{user.email}</td>
            <td>{user.password}</td>
            <td>{user.zipcode}</td>
            <td>{user.address}</td>
            <td><button type="button" onClick={(ev)=>handleEditClick(ev, user)}><Edit /></button></td>
            <td><button type='button' onClick={()=>onDelete(user.id)} ><Delete /></button></td>
        </tr>
    )
}

export default ReadOnly