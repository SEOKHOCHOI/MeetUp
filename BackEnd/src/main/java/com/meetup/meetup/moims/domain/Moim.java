package com.meetup.meetup.moims.domain;

import com.meetup.meetup.common.domain.BaseEntity;
import com.meetup.meetup.moims.dtos.MoimResponseDto;
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
    private Category category;

    @Enumerated(EnumType.STRING)
    private ActiveType type;

    @Builder
    public Moim(String title, String password, int headCount, Category category, ActiveType type) {
        this.title = title;
        this.password = password;
        this.headCount = headCount;
        this.category = category;
        this.type = type;
    }

    //todo (1. 약속 일정 -> 지나면 deactivate 변경)

    public MoimResponseDto toResponseDto() {
        return new MoimResponseDto(this);
    }

    public void update(String title, String password, int headCount, Category category) {
        this.title = title;
        this.password = password;
        this.headCount = headCount;
        this.category = category;
    }

}
