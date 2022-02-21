package com.meetup.meetup.users.dtos;

import com.meetup.meetup.users.domain.User;
import com.meetup.meetup.users.domain.Role;
import lombok.Data;

@Data
public class UserResponseDto {

    private String email;
    private String picturePath;
    private Role type;

    public UserResponseDto(String email, String picturePath, Role type) {
        this.email = email;
        this.picturePath = picturePath;
        this.type = type;
    }

    public UserResponseDto(User user) {
        this.email = user.getEmail();
        this.picturePath = user.getPicture();
        this.type = user.getRole();
    }
}
