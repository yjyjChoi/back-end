package com.pasta.aglioeolio.domains.user.controller;

import com.pasta.aglioeolio.config.jpa.User;
import com.pasta.aglioeolio.domains.user.dto.response.UserResponse;
import com.pasta.aglioeolio.domains.user.repository.UserQueryRepository;
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
public class UserController {

    private final UserQueryRepository userQueryRepository;

    // 유저 조회
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUser(){

        UserResponse from = UserResponse.from();
        UserResponse from2 = UserResponse.from();

        List<UserResponse> userResponse = new ArrayList<>();
        userResponse.add(from);
        userResponse.add(from2);

        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/users")
    public User findAllUser() {
        System.out.println("id : "+userQueryRepository.findByMtNumber("222").getId());
        return userQueryRepository.findByMtNumber("222");
    }

}
