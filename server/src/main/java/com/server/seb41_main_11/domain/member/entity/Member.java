package com.server.seb41_main_11.domain.member.entity;

import com.server.seb41_main_11.domain.common.BaseEntity;
import com.server.seb41_main_11.domain.member.constant.MemberType;
import com.server.seb41_main_11.domain.member.constant.Role;
import com.server.seb41_main_11.global.jwt.dto.JwtTokenDto;
import com.server.seb41_main_11.global.util.DateTimeUtils;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(length = 200)
    private String password;
    // 소셜 로그인 인증 같은 경우 비밀번호를 직접 다루지 않기 때문에 nullable

    @Column(nullable = false, length = 20)
    private String memberName;
    //실명

    @Column(length = 10)
    private String nickName;
    //닉네임 추가

    @Column(length = 10)
    private String birth;
    // 생년월일 저장
    @Column(length = 200)
    private String profile;
    // 해당 회원의 프로필 사진 주소 저장
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Role role;
    // 따로 권한테이블을 두어서 여러 역할을 가질 수 있도록 설정할 수도 있음
    // 현재는 한개만 갖도록 구성(일반 유저와 Admin 유저로 구분)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private MemberType memberType;
    // 카카오 회원인지, 네이버 회원인지 Enum으로 관리
    @Column(length = 250)
    private String refreshToken;
    // 리프레쉬 토큰
    private LocalDateTime tokenExpirationTime;
    // 토큰 만료 시간
//    @Builder
//    public Member(MemberType memberType, String email, String password, String memberName,
//                  String profile, Role role) {
//        this.memberType = memberType;
//        this.email = email;
//        this.password = password;
//        this.memberName = memberName;
//        this.profile = profile;
//        this.role = role;
//    }

    @Builder
    public Member(Long memberId, String email, String password, String memberName, String profile, String nickName, String birth, Role role, MemberType memberType) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.profile = profile;
        this.nickName = nickName;
        this.birth = birth;
        this.role = role;
        this.memberType = memberType;
    }

    public void updateRefreshToken(JwtTokenDto jwtTokenDto) {
        this.refreshToken = jwtTokenDto.getRefreshToken();
        this.tokenExpirationTime = DateTimeUtils.convertToLocalDateTime(jwtTokenDto.getRefreshTokenExpireTime());
    }

    public void expireRefreshToken(LocalDateTime now) {
        this.tokenExpirationTime = now;
    }
}
