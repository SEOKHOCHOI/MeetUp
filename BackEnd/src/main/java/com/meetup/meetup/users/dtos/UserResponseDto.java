package com.meetup.meetup.users.dtos;

import com.meetup.meetup.users.domain.User;
import com.meetup.meetup.users.domain.Role;
import lombok.Data;

@Data
public class UserResponseDto {

    private String email;
    private String picture;
    private Role type;

    public UserResponseDto(String email, String picture, Role type) {
        this.email = email;
        this.picture = picture;
        this.type = type;
    }

    public UserResponseDto(User user) {
        this.email = user.getEmail();
        this.picture = user.getPicture();
        this.type = user.getRole();
    }
}
