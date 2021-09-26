package com.pasta.aglioeolio.domains.wish.controller;

import com.pasta.aglioeolio.common.Login;
import com.pasta.aglioeolio.common.LoginUser;
import com.pasta.aglioeolio.domains.wish.dto.request.CreateWishRequest;
import com.pasta.aglioeolio.domains.wish.dto.request.UpdateWishRequest;
import com.pasta.aglioeolio.domains.wish.dto.request.VerificationWishRequest;
import com.pasta.aglioeolio.domains.wish.dto.response.WishResponse;
import com.pasta.aglioeolio.domains.wish.service.WishService;
import java.net.URI;
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

    private WishService wishService;

    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @GetMapping
    public ResponseEntity<List<WishResponse>> findAllWish(
        @Login LoginUser loginUser
    ) {
        return ResponseEntity.ok(wishService.findAllWish(loginUser));
    }

    @GetMapping("/{wishId}")
    public ResponseEntity<WishResponse> findWishById(
        @PathVariable @NotNull Long wishId
    ) {
        return ResponseEntity.ok(wishService.findWishById(wishId));
    }

    @PostMapping
    public ResponseEntity<WishResponse> createWish(
        @Login LoginUser loginUser,
        @RequestBody @Valid CreateWishRequest createWishRequest
    ) {
        WishResponse wishResponse = wishService.createWish(createWishRequest, loginUser);

        return ResponseEntity.created(
            URI.create("/api/wishs" + wishResponse.getId())).body(wishResponse);
    }

    @PatchMapping("/{wishId}")
    public ResponseEntity<WishResponse> updateWish(
        @Login LoginUser loginUser,
        @RequestBody @Valid UpdateWishRequest createWishRequest,
        @PathVariable @NotNull Long wishId) {
        WishResponse wishResponse = wishService.updateWish(createWishRequest, wishId, loginUser);
        return ResponseEntity.ok(wishResponse);
    }

    @DeleteMapping("/{wishId}")
    public ResponseEntity<Void> deleteWish(
        @Login LoginUser loginUser,
        @PathVariable @NotNull Long wishId) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/verification/soldier")
    public ResponseEntity<WishResponse> verificationWishBySoldier(
        @Login LoginUser loginUser,
        @RequestBody @Valid VerificationWishRequest verificationWishRequest) {
        return ResponseEntity.noContent().build();
    }

}