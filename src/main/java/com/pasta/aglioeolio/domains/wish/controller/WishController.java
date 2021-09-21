package com.pasta.aglioeolio.domains.wish.controller;

import com.pasta.aglioeolio.common.Login;
import com.pasta.aglioeolio.common.LoginUser;
import com.pasta.aglioeolio.domains.wish.dto.request.CreateWishRequest;
import com.pasta.aglioeolio.domains.wish.dto.request.UpdateWishRequest;
import com.pasta.aglioeolio.domains.wish.dto.response.WishResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wishs")
public class WishController {

    @GetMapping
    public ResponseEntity<List<WishResponse>> findAllWish(
        @Login LoginUser loginUser
    ) {

        WishResponse from = WishResponse.builder()
            .title("제목")
            .content("내용")
            .round(1)
            .isAnonymous(true)
            .categoryId(1L)
            .verificationSoldier(true)
            .officers(Arrays.asList(1L, 2L, 3L))
            .build();

        WishResponse from2 = WishResponse.builder()
            .title("제목2")
            .content("내용2")
            .round(1)
            .isAnonymous(true)
            .categoryId(1L)
            .verificationSoldier(true)
            .officers(Arrays.asList(1L, 2L, 3L))
            .build();

        List<WishResponse> wishResponse = new ArrayList<>();
        wishResponse.add(from);
        wishResponse.add(from2);

        return ResponseEntity.ok(wishResponse);
    }

    @GetMapping("/{wishId}")
    public ResponseEntity<WishResponse> findWishById(
        @Login LoginUser loginUser,
        @PathVariable @NotNull Long wishId
    ) {
        WishResponse wishResponse = WishResponse.builder()
            .title("제목")
            .content("내용")
            .round(1)
            .isAnonymous(true)
            .categoryId(1L)
            .verificationSoldier(true)
            .officers(Arrays.asList(1L, 2L, 3L))
            .build();

        return ResponseEntity.ok(wishResponse);
    }

    @PostMapping
    public ResponseEntity<WishResponse> createWish(
        @Login LoginUser loginUser,
        @RequestBody @Valid CreateWishRequest createWishRequest
    ) {
        WishResponse wishResponse = WishResponse.builder()
            .title("제목")
            .content("내용")
            .round(1)
            .isAnonymous(true)
            .categoryId(1L)
            .verificationSoldier(true)
            .officers(Arrays.asList(1L, 2L, 3L))
            .build();

        return ResponseEntity.ok(wishResponse);
    }

    @PatchMapping("/{wishId}")
    public ResponseEntity<WishResponse> updateWish(
        @Login LoginUser loginUser,
        @RequestBody @Valid UpdateWishRequest createWishRequest,
        @PathVariable @NotNull Long wishId) {

        WishResponse wishResponse = WishResponse.builder()
            .title("제목(수정)")
            .content("내용(수정)")
            .round(1)
            .isAnonymous(true)
            .categoryId(1L)
            .verificationSoldier(false)
            .officers(Arrays.asList(1L, 2L, 3L))
            .build();

        return ResponseEntity.ok(wishResponse);
    }

    @DeleteMapping("/{wishId}")
    public ResponseEntity<Void> deleteWish(
        @Login LoginUser loginUser,
        @PathVariable @NotNull Long wishId) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/verification/{wishId}/soldier")
    public ResponseEntity<WishResponse> verificationWishBySoldier(
        @Login LoginUser loginUser,
        @PathVariable @NotNull Long wishId) {
        return ResponseEntity.noContent().build();
    }

}