package com.meetup.meetup.users.domain;

import com.meetup.meetup.comments.domain.Comment;
import com.meetup.meetup.common.domain.BaseTimeEntity;
import com.meetup.meetup.likes.domain.Like;
import com.meetup.meetup.moims.domain.UserToMoim;
import com.meetup.meetup.users.dtos.UserResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String password;

    @Embedded
    private Address address;

    private String picturePath;

    @Enumerated(EnumType.STRING)
    private UsersType type;

    @OneToMany(mappedBy = "user")
    private List<UserToMoim> userToMoims = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public User(String email, String password, Address address, String picturePath, UsersType type) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.picturePath = picturePath;
        this.type = type;
    }

    public UserResponseDto toResponseDto() {
        return new UserResponseDto(email, picturePath, type);
    }

    public void update(String password, Address address, String picturePath) {
        if (password != null || password.equals("")) {
            this.password = password;
        }

        if (address != null) {
            this.address = address;
        }

        if (picturePath != null || picturePath.equals("")) {
            this.picturePath = picturePath;
        }
    }
}
