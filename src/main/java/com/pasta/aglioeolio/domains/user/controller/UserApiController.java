package com.pasta.aglioeolio.domains.user.controller;

import com.pasta.aglioeolio.domains.user.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    // 유저 조회
    @GetMapping("")
    public ResponseEntity<List<UserResponse>> findAllUser(){

        UserResponse from = UserResponse.from();

        List<UserResponse> userResponse = new ArrayList<>();
        userResponse.add(from);

        return ResponseEntity.ok(userResponse);
    }

}
