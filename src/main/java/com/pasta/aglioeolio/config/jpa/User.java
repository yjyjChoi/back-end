package com.pasta.aglioeolio.config.jpa;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@DynamicInsert
@DynamicUpdate
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mt_number; // 군번

    private String password; // 비밀번호

    private String enlist_date; // 입대일자

    private String discharge_date; // 전역일자

    private String name; // 이름

    private String phone_number; // 핸드폰번호

    private String rank; // 계급

    private String affiliation; // 소속

    private String profile_image; // 프로필 사진

    private Boolean blue_falcon; // 관심병사 여부

    private String role; // 권한 // 병사 :  ROLE_SOLDIER, 간부 : ROLE_OFFICER

    private Integer fail_count; // 로그인 실패 카운트

    private Boolean is_delyn; // 삭제 여부

}
