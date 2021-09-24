package com.pasta.aglioeolio.domains.user.service;

import com.pasta.aglioeolio.domains.user.repository.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserQueryRepository userQueryRepository;

}
