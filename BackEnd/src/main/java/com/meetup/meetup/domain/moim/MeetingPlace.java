package com.meetup.meetup.domain.moim;

import com.meetup.meetup.domain.location.Location;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MeetingPlace {

    private Long id;
    private Moim moim;
    private Location location;
    private Boolean main;

}
