package com.meetup.meetup.moims.domain;

import com.meetup.meetup.common.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Moim extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "moim_id")
    private Long id;

    private String title;

    private String password;

    private int headCount;

    @Enumerated(EnumType.STRING)
    private ActiveType type;

    @Builder
    public Moim(String title, String password, int headCount, ActiveType type) {
        this.title = title;
        this.password = password;
        this.headCount = headCount;
        this.type = type;
    }
    
/*
    1. 약속 일정 -> 지나면 deactivate로 변경
*/
}
