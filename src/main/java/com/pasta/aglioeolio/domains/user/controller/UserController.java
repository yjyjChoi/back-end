package com.pasta.aglioeolio.domains.user.controller;

import com.pasta.aglioeolio.config.jpa.User;
import com.pasta.aglioeolio.domains.user.repository.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

//    private final PasswordEncoder passwordEncoder;
//    private final JwtTokenProvider jwtTokenProvider;
//    private final UserRepository userRepository;
//    private final CustomUserDetailService customUserDetailService;

    private final UserQueryRepository userQueryRepository;


    @GetMapping("/users")
    public User findAllUser() {
        System.out.println("id : "+userQueryRepository.findByMtNumber("222").getId());
        return userQueryRepository.findByMtNumber("222");
    }

//    // 회원가입
//    @PostMapping("/join")
//    public Long join(@RequestBody Map<String, String> user) {
//        return userRepository.save(UserRequest.builder()
//                .mtNumber(user.get("mtNumber"))
//                .password(passwordEncoder.encode(user.get("password")))
//                .build()).getId();
//    }

}
