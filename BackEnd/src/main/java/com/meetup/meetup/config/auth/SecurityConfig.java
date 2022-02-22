package com.meetup.meetup.config.auth;

import com.meetup.meetup.users.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 태그 및 메서드 정리
 * 1. @EnableWebSecurity : Spring Security 설정 활성화
 * 2. crsf().disable().headers().frameOptions().disable() : h2-console 화면 사용을 위해 해당 옵션 disable
 * 3. authorizeRequests : URL별 권한 관리를 설정하는 옵션 시작점, 이를 통해 antMatchers 옵션 사용 가능
 * 4. antMatchers : 권한 관리 대상 지정 옵션, URL, HTTP 메소드별로 관리 가능
 * - "/" 등 지정된 URL들을 permitAll() 옵션을 통해 전체 열람 권한 부여
 * - "/users/" 주소를 가진 API는 USER 권한을 가져야 접근 가능
 * 5. anyRequest : 설정 값 이외의 URL들 (인증된 사용자들에게만 허용 -> authenticated())
 * 6. logout().logoutSuccessUrl("/") : 로그아웃 기능의 진입점, 로그아웃 시 / 주소로 이동
 * 7. ouath2Login() : OAuth2 로그인 기능의 진입점
 * 8. userInfoEndpoint() : OAuth2 로그인 성공 이후 사용자 정보를 가져올 때 설정 담당
 * 9. userService() : 소셜 로그인 성공 시 후속 조치를 취할 UserService 인터페이스 구현체 등록
 */

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
            .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/users/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
            .and()
                .logout()
                    .logoutSuccessUrl("/")
            .and()
                .oauth2Login()
                    .userInfoEndpoint()
                        .userService(customOAuth2UserService);
        
    }
}
