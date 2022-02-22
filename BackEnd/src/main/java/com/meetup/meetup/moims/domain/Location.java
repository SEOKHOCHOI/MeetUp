package com.meetup.meetup.moims.domain;

import com.meetup.meetup.comments.domain.Comment;
import com.meetup.meetup.common.domain.BaseTimeEntity;
import com.meetup.meetup.likes.domain.Like;
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
public class Location extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String apiKey;

    @OneToMany(mappedBy = "location")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "location")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Location(String name, Category category, String apiKey, List<Like> likes, List<Comment> comments) {
        this.name = name;
        this.category = category;
        this.apiKey = apiKey;
    }
}
