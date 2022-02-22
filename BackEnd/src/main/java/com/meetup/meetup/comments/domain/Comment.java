package com.meetup.meetup.comments.domain;

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
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    private String comment;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @Builder
    public Comment(String comment, User user, Location location) {
        this.comment = comment;
        this.user = user;
        this.location = location;
    }
}
