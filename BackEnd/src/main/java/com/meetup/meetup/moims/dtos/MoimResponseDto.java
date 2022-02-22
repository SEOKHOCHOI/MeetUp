package com.meetup.meetup.moims.dtos;

import com.meetup.meetup.moims.domain.ActiveType;
import com.meetup.meetup.moims.domain.Category;
import com.meetup.meetup.moims.domain.Moim;
import lombok.Builder;
import lombok.Data;

@Data
public class MoimResponseDto {

    private Long id;
    private String title;
    private int headCount;
    private Category category;
    private ActiveType type;

    @Builder
    public MoimResponseDto(Moim moim) {
        this.id = moim.getId();
        this.title = moim.getTitle();
        this.headCount = moim.getHeadCount();
        this.category = moim.getCategory();
        this.type = moim.getType();
    }


}
