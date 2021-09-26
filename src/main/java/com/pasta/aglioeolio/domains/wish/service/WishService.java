package com.pasta.aglioeolio.domains.wish.service;

import com.pasta.aglioeolio.common.LoginUser;
import com.pasta.aglioeolio.config.jpa.OfficerWish;
import com.pasta.aglioeolio.config.jpa.User;
import com.pasta.aglioeolio.config.jpa.Wish;
import com.pasta.aglioeolio.domains.wish.dto.request.CreateWishRequest;
import com.pasta.aglioeolio.domains.wish.dto.request.UpdateWishRequest;
import com.pasta.aglioeolio.domains.wish.dto.response.WishResponse;
import com.pasta.aglioeolio.domains.wish.repository.WishOfficerRepository;
import com.pasta.aglioeolio.domains.wish.repository.WishQueryRepository;
import com.pasta.aglioeolio.domains.wish.repository.WishRepository;
import com.pasta.aglioeolio.exception.wish.WishNotFoundException;
import com.pasta.aglioeolio.exception.wish.WishReadByOfficerException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WishService {

    private final WishQueryRepository wishQueryRepository;
    private final WishRepository wishRepository;
    private final WishOfficerRepository wishOfficerRepository;

    public WishService(
        WishQueryRepository wishQueryRepository,
        WishRepository wishRepository,
        WishOfficerRepository wishOfficerRepository) {
        this.wishQueryRepository = wishQueryRepository;
        this.wishRepository = wishRepository;
        this.wishOfficerRepository = wishOfficerRepository;
    }

    //TODO: 병사/간부 구분 > 조회쿼리 수정
    public List<WishResponse> findAllWish(LoginUser loginUser) {

        //간부인지 병사인지 조회

        //간부면 간부한테 온 소원 리스트 + 익명이면 유저정보 X

        //병사면 병사가 작성한 소원 리스트

        return WishResponse.listOf(wishQueryRepository.findAllWish(loginUser.getId()));
    }

    public WishResponse findWishById(Long wishId) {
        return WishResponse.of(wishQueryRepository.findWishById(wishId));
    }

    @Transactional
    public WishResponse createWish(CreateWishRequest createWishRequest, LoginUser loginUser) {

        //유저 조회 & 소속 조회 한번에...
        User user = User.builder()
            .id(1L)
            .mt_number("15-72005960")
            .name("김우철")
            .rank("병장")
            .affiliation("소속")
            .profile_image("http://www.naver.com")
            .build();

        //카테고리 조회
        String categoryName = "카테고리 이름";

        //저장
        Wish savedWish = wishRepository.save(createWishRequest.toWishEntity(user));
        createOfficerWish(createWishRequest, savedWish.getId());

        return WishResponse.of(savedWish, user, categoryName);
    }

    @Transactional
    public WishResponse updateWish(UpdateWishRequest updateWishRequest, Long wishId, LoginUser loginUser) {

        //유저 조회 & 소속 조회 한번에...
        User user = User.builder()
            .id(1L)
            .mt_number("15-72005960")
            .name("김우철")
            .rank("병장")
            .affiliation("소속")
            .profile_image("http://www.naver.com")
            .build();

        //지정한 간부가 한명이라도 읽었다면 수정 X
        List<OfficerWish> officerWishes = wishOfficerRepository.findAllByWishId(wishId);

        for (OfficerWish officerWish : officerWishes) {
            if(officerWish.getIs_checked()){
                throw new WishReadByOfficerException();
            }
        }

        Wish updatedWish = wishRepository.findById(wishId).orElseThrow(WishNotFoundException::new);

        //wish 수정
        updatedWish.changeWish(
            updateWishRequest.getTitle(),
            updateWishRequest.getContent(),
            updateWishRequest.getRound(),
            updateWishRequest.getIsAnonymous(),
            updateWishRequest.getCategoryId()
        );

        //기존 officer_wish 삭제 후 재 insert
        wishOfficerRepository.deleteOfficerWishByWishId(wishId);

        //officer_wish 재 insert
        updateOfficerWish(updateWishRequest, wishId);

        //카테고리 조회
        String categoryName = "카테고리 이름";

        return WishResponse.of(updatedWish, user, categoryName);

    }

    //officer_wish 테이블 삽입, TODO: 추후 다중 insert로 바꾸기
    private void createOfficerWish(CreateWishRequest createWishRequest, Long wishId){
        wishOfficerRepository.saveAll(createWishRequest.toOfficerWishEntity(wishId));
    }

    //officer_wish 테이블 삽입, TODO: 추후 다중 insert로 바꾸기
    private void updateOfficerWish(UpdateWishRequest updateWishRequest, Long wishId){
        wishOfficerRepository.saveAll(updateWishRequest.toOfficerWishEntity(wishId));
    }

}