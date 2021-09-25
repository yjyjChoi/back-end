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
            .mtNumber("군번")
            .password("비밀번호")
            .enlistDate("입대일자")
            .dischargeDate("전역일자")
            .name("이름")
            .phoneNumber("핸드폰번호")
            .rank("계급")
            .affiliation("소속")
            .profileImage("프로필사진")
            .blueFalcon(false)
            .role("권한")
            .failCount(0)
            .isDelyn(false)
            .build();

        UserResponse from2 = UserResponse.builder()
            .mtNumber("군번")
            .password("비밀번호")
            .enlistDate("입대일자")
            .dischargeDate("전역일자")
            .name("이름")
            .phoneNumber("핸드폰번호")
            .rank("계급")
            .affiliation("소속")
            .profileImage("프로필사진")
            .blueFalcon(false)
            .role("권한")
            .failCount(0)
            .isDelyn(false)
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
            .mtNumber("군번")
            .password("비밀번호")
            .enlistDate("입대일자")
            .dischargeDate("전역일자")
            .name("이름")
            .phoneNumber("핸드폰번호")
            .rank("계급")
            .affiliation("소속")
            .profileImage("프로필사진")
            .blueFalcon(false)
            .role("권한")
            .failCount(0)
            .isDelyn(false)
            .build();

        return ResponseEntity.ok(userResponse);
    }

    // 유저 등록 // 가입
    @PostMapping
    public ResponseEntity<UserResponse> createUser(
        @RequestBody @Valid CreateUserRequest createUserRequest
    ) {
        UserResponse userResponse = UserResponse.builder()
            .mtNumber("군번")
            .password("비밀번호")
            .enlistDate("입대일자")
            .dischargeDate("전역일자")
            .name("이름")
            .phoneNumber("핸드폰번호")
            .rank("계급")
            .affiliation("소속")
            .profileImage("프로필사진")
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
            .mtNumber("군번(수정)")
            .password("비밀번호(수정)")
            .enlistDate("입대일자(수정)")
            .dischargeDate("전역일자(수정)")
            .name("이름(수정)")
            .phoneNumber("핸드폰번호(수정)")
            .rank("계급(수정)")
            .affiliation("소속(수정)")
            .profileImage("프로필사진(수정)")
            .blueFalcon(false)
            .role("권한(수정)")
            .failCount(0)
            .isDelyn(false)
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
