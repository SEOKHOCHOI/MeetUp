import { CancelOutlined, Publish } from '@material-ui/icons'
import React from 'react'
import Styles from '../Manager.module.scss'
const Editable = ({ editForm, handleEditFormChange, onCancle }) => {
    
  return (
    <tr className={Styles.edit}>
        <td><input type="text" name="name" className={Styles.name} required="required" value={editForm.name} onChange={handleEditFormChange}/></td>
        <td><input type="text" name="email"  required="required"value={editForm.email} onChange={handleEditFormChange}/></td>
        <td><input type="text" name="password" className={Styles.pwd} required="required" value={editForm.password} onChange={handleEditFormChange}/></td>
        <td><input type="text" name="zipcode" className={Styles.zipcode} required="required" value={editForm.zipcode} onChange={handleEditFormChange}/></td>
        <td><input type="text" name="address" className={Styles.address} required="required" value={editForm.address} onChange={handleEditFormChange}/></td>
        <td><button type='submit'><Publish /></button></td>
        <td><button type='button' onClick={onCancle}><CancelOutlined /></button></td>
</tr>
  )
}

export default Editable