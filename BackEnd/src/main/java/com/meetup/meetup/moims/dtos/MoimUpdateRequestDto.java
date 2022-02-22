package com.meetup.meetup.moims.dtos;

import com.meetup.meetup.moims.domain.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MoimUpdateRequestDto {

    private String title;
    private String password;
    private int headCount;
    private Category category;

    @Builder
    public MoimUpdateRequestDto(String title, String password, int headCount, Category category) {
        this.title = title;
        this.password = password;
        this.headCount = headCount;
        this.category = category;
    }
}
