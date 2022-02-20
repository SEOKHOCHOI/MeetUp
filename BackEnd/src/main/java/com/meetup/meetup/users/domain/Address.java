package com.meetup.meetup.users.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String city;
    private String street;
    private String zipcode;
    private String longitude;
    private String latitude;

    @Builder
    public Address(String city, String street, String zipcode, String longitude, String latitude) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
