package com.pasta.aglioeolio.domains.wish.service;

import com.pasta.aglioeolio.common.LoginUser;
import com.pasta.aglioeolio.domains.wish.dto.response.WishResponse;
import com.pasta.aglioeolio.domains.wish.repository.WishQueryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WishService {

    private WishQueryRepository wishQueryRepository;

    public WishService(
        WishQueryRepository wishQueryRepository) {
        this.wishQueryRepository = wishQueryRepository;
    }

    //TODO: 병사/간부 구분 > 조회쿼리 수정
    public List<WishResponse> findAllWish(LoginUser loginUser){

        //간부인지 병사인지 조회

        //간부면 간부한테 온 소원 리스트 + 익명이면 유저정보 X

        //병사면 병사가 작성한 소원 리스트

        return WishResponse.listOf(wishQueryRepository.findAllWish(loginUser.getId()));
    }


    public void findWishById(){

    }

}