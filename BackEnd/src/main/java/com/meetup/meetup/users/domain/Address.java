package com.meetup.meetup.users.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String city;
    private String street;
    private String zipcode;
    private String longitude;
    private String latitude;

    public Address(String city, String street, String zipcode, String longitude, String latitude) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
