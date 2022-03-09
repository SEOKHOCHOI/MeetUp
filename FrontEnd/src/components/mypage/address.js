import React, { useState } from 'react'
import DaumPostcode from 'react-daum-postcode';

const Address=(props)=>{
    const address = props.address;
    const setAddress = props.setAddress;
    const zipcode = props.setZipcode;
    const setZipcode = props.setZipcode;

    const handleComplete = (data) => {
        let fullAddress = data.address;
        let extraAddress = ''; 
        
        if (data.addressType === 'R') {
          if (data.bname !== '') {
            extraAddress += data.bname;
          }
          if (data.buildingName !== '') {
            extraAddress += (extraAddress !== '' ? `, ${data.buildingName}` : data.buildingName);
          }
          fullAddress += (extraAddress !== '' ? ` (${extraAddress})` : '');
        }
      
        setAddress(fullAddress);
        setZipcode(data.zonecode);
    }
    const addressStyle = {
        display: "block",
        position: "absolute",
        top: "10%",
    
        width: "380px",
        height: "350px",
        border:"2px solid #f2a341"
      };
    return (
        <div>    
        <DaumPostcode style={addressStyle} onComplete={handleComplete} className="post-code" autoClose />
    </div>
    );
}
export default Address