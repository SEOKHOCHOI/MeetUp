package com.meetup.meetup.users.dtos;

import com.meetup.meetup.users.domain.Address;
import com.meetup.meetup.users.domain.User;
import com.meetup.meetup.users.domain.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String email;
    private String password;
    private Address address;
    private String picturePath;
    private Role type;

    @Builder
    public UserSaveRequestDto(String email, String password, Address address, String picturePath, Role type) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.picturePath = picturePath;
        this.type = type;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .address(address)
                .picturePath(picturePath)
                .type(type)
                .build();
    }
}
