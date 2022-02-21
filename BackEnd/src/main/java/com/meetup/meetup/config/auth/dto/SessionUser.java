package com.meetup.meetup.config.auth.dto;

import com.meetup.meetup.users.domain.OAuthUser;
import lombok.Getter;

import java.io.Serializable;

/**
 * 세션에 사용자 정보를 저장하기 위한 DTO 클래스
 * 이는 User 엔티티를 직접 사용하기 위해 직렬화를 해야하는데, 성능 이슈나 부수 효과 발생 위험이 존재
 * 따라서 직렬화 기능을 지닌 DTO를 추가로 만드는 것이 유지보수에 탁월하다.
 */
@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(OAuthUser user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

}
