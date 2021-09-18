package com.pasta.aglioeolio.domains.wish.controller;

import com.pasta.aglioeolio.domains.wish.dto.request.CreateWishRequest;
import com.pasta.aglioeolio.domains.wish.dto.response.WishResponse;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wishs")
public class WishController {

    //게시글 다건 조회
    @GetMapping("")
    public ResponseEntity<List<WishResponse>> findAllWish(){

        WishResponse from = WishResponse.from();
        WishResponse from2 = WishResponse.from();

        List<WishResponse> wishResponse = new ArrayList<>();
        wishResponse.add(from);
        wishResponse.add(from2);

        return ResponseEntity.ok(wishResponse);
    }

    //게시글 단건 조회
    @GetMapping("/{wishId}")
    public ResponseEntity<WishResponse> findWishById(
        @PathVariable @NotNull Long wishId
    ){
        WishResponse wishResponse = WishResponse.from();
        return ResponseEntity.ok(wishResponse);
    }

    //게시글 등록
    @PostMapping
    public ResponseEntity<WishResponse> createWish(
        @RequestBody @Valid CreateWishRequest createWishRequest
    ){
        WishResponse wishResponse = WishResponse.from();
        return ResponseEntity.ok(wishResponse);
    }

}