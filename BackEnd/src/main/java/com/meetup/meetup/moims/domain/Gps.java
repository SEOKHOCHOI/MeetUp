package com.meetup.meetup.moims.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Gps {

    private String longitude; //경도(x)
    private String latitude; //위도(y)

    @Builder
    public Gps(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
