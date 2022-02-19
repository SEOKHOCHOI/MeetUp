package com.meetup.meetup.moims.domain;

import com.meetup.meetup.common.domain.BaseTimeEntity;
import com.meetup.meetup.users.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserToMoim extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_to_moim_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "moim_id")
    private Moim moim;

    @Embedded
    private Gps gps;

    @Builder
    public UserToMoim(User user, Moim moim, Gps gps) {
        this.user = user;
        this.moim = moim;
        this.gps = gps;
    }
}
