package com.pasta.aglioeolio.domains.user.controller;

import com.pasta.aglioeolio.common.Login;
import com.pasta.aglioeolio.common.LoginUser;
import com.pasta.aglioeolio.domains.user.dto.request.CreateUserRequest;
import com.pasta.aglioeolio.domains.user.dto.request.UpdateUserRequest;
import com.pasta.aglioeolio.domains.user.dto.response.UserResponse;
import com.pasta.aglioeolio.domains.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // 유저 조회
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUser() {
        UserResponse from = UserResponse.builder()
            .mt_number("군번")
            .password("비밀번호")
            .enlist_date("입대일자")
            .discharge_date("전역일자")
            .name("이름")
            .phone_number("핸드폰번호")
            .rank("계급")
            .affiliation("소속")
            .profile_image("프로필사진")
            .blue_falcon(false)
            .role("권한")
            .fail_count(0)
            .is_delyn(false)
            .build();

        UserResponse from2 = UserResponse.builder()
            .mt_number("군번")
            .password("비밀번호")
            .enlist_date("입대일자")
            .discharge_date("전역일자")
            .name("이름")
            .phone_number("핸드폰번호")
            .rank("계급")
            .affiliation("소속")
            .profile_image("프로필사진")
            .blue_falcon(false)
            .role("권한")
            .fail_count(0)
            .is_delyn(false)
            .build();

        List<UserResponse> userResponse = new ArrayList<>();
        userResponse.add(from);
        userResponse.add(from2);

        return ResponseEntity.ok(userResponse);
    }

    // 유저 단건 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> findUserById(
        @PathVariable @NotNull Long userId
    ) {
        UserResponse userResponse = UserResponse.builder()
            .mt_number("군번")
            .password("비밀번호")
            .enlist_date("입대일자")
            .discharge_date("전역일자")
            .name("이름")
            .phone_number("핸드폰번호")
            .rank("계급")
            .affiliation("소속")
            .profile_image("프로필사진")
            .blue_falcon(false)
            .role("권한")
            .fail_count(0)
            .is_delyn(false)
            .build();

        return ResponseEntity.ok(userResponse);
    }

    // 유저 등록 // 가입
    @PostMapping
    public ResponseEntity<UserResponse> createUser(
        @RequestBody @Valid CreateUserRequest createUserRequest
    ) {
        UserResponse userResponse = UserResponse.builder()
            .mt_number("군번")
            .password("비밀번호")
            .enlist_date("입대일자")
            .discharge_date("전역일자")
            .name("이름")
            .phone_number("핸드폰번호")
            .rank("계급")
            .affiliation("소속")
            .profile_image("프로필사진")
            .build();

        return ResponseEntity.ok(userResponse);
    }

    // 유저 수정
    @PatchMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(
        @Login LoginUser loginUser,
        @RequestBody @Valid UpdateUserRequest createUserRequest,
        @PathVariable @NotNull Long userId
    ) {
        UserResponse userResponse = UserResponse.builder()
            .mt_number("군번(수정)")
            .password("비밀번호(수정)")
            .enlist_date("입대일자(수정)")
            .discharge_date("전역일자(수정)")
            .name("이름(수정)")
            .phone_number("핸드폰번호(수정)")
            .rank("계급(수정)")
            .affiliation("소속(수정)")
            .profile_image("프로필사진(수정)")
            .blue_falcon(false)
            .role("권한(수정)")
            .fail_count(0)
            .is_delyn(false)
            .build();

        return ResponseEntity.ok(userResponse);
    }

    // 유저 삭제 // 탈퇴
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(
        @Login LoginUser loginUser,
        @PathVariable @NotNull Long userId
    ) {
        return ResponseEntity.noContent().build();
    }

}
