package com.meetup.meetup.users.dtos;

import com.meetup.meetup.users.domain.User;
import com.meetup.meetup.users.domain.UsersType;
import lombok.Data;

@Data
public class UserResponseDto {

    private String email;
    private String picturePath;
    private UsersType type;

    public UserResponseDto(String email, String picturePath, UsersType type) {
        this.email = email;
        this.picturePath = picturePath;
        this.type = type;
    }

    public UserResponseDto(User user) {
        this.email = user.getEmail();
        this.picturePath = user.getPicturePath();
        this.type = user.getType();
    }
}
