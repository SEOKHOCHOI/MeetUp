package com.meetup.meetup.domain.moim;

import com.meetup.meetup.domain.BaseTimeEntity;

import javax.persistence.*;

public class Moim extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Boolean isActive;

    private int maxMembers;

    private int password;
}
