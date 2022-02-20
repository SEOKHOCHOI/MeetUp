package com.meetup.meetup.users.dtos;

import com.meetup.meetup.users.domain.Address;
import com.meetup.meetup.users.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
public class UserUpdateRequestDto {

    private String password;
    private Address address;
    private String picturePath;

    @Builder
    public UserUpdateRequestDto(String password, Address address, String picturePath) {
        this.password = password;
        this.address = address;
        this.picturePath = picturePath;
    }

    @Builder
    public UserUpdateRequestDto(User user) {
        this.password = user.getPassword();
        this.address = user.getAddress();
        this.picturePath = user.getPicturePath();
    }
}
