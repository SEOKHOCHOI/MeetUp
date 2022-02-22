package com.meetup.meetup.users.dtos;

import com.meetup.meetup.users.domain.Address;
import com.meetup.meetup.users.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String password;
    private Address address;
    private String picture;

    @Builder
    public UserUpdateRequestDto(String password, Address address, String picture) {
        this.password = password;
        this.address = address;
        this.picture = picture;
    }

    @Builder
    public UserUpdateRequestDto(User user) {
        this.password = user.getPassword();
        this.address = user.getAddress();
        this.picture = user.getPicture();
    }
}
