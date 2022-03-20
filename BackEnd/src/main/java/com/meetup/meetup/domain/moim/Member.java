package com.meetup.meetup.domain.moim;

import com.meetup.meetup.domain.location.Location;
import com.meetup.meetup.domain.user.Role;
import com.meetup.meetup.domain.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;
    private User user;
    private Moim moim;
    private Role role;
    private Location location;
}
