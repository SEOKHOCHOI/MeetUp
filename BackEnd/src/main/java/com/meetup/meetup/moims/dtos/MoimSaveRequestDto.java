package com.meetup.meetup.moims.dtos;

import com.meetup.meetup.moims.domain.ActiveType;
import com.meetup.meetup.moims.domain.Category;
import com.meetup.meetup.moims.domain.Moim;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MoimSaveRequestDto {

    private String title;
    private String password;
    private int headCount;
    private Category category;

    @Builder
    public MoimSaveRequestDto(String title, String password, int headCount, Category category) {
        this.title = title;
        this.password = password;
        this.headCount = headCount;
        this.category = category;
    }

    public Moim toEntity() {
        return Moim.builder()
                .title(title)
                .password(password)
                .headCount(headCount)
                .category(category)
                .type(ActiveType.ACTIVE)
                .build();
    }
}
