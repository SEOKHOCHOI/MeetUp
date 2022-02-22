package com.meetup.meetup.likes.domain;

import com.meetup.meetup.common.domain.BaseEntity;
import com.meetup.meetup.moims.domain.Location;
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
@Table(name = "likes")
public class Like extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "like_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private LikeType type;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @Builder
    public Like(LikeType type, User user, Location location) {
        this.type = type;
        this.user = user;
        this.location = location;
    }
}
