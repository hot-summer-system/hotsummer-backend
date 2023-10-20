package com.hotsummer.luvme.controller.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.hotsummer.luvme.controller.FavoriteController;
import com.hotsummer.luvme.controller.api.exception.CustomForbiddenException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.request.FavoriteRequest;
import com.hotsummer.luvme.model.response.FavoriteFullFieldRes;
import com.hotsummer.luvme.model.response.FavoriteResponse;
import com.hotsummer.luvme.service.FavoriteService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Favorite API")
public class FavoriteControllerImpl implements FavoriteController {
    private final FavoriteService favoriteService;

    @Override
    public ResponseEntity<FavoriteResponse> addFavoriteProduct(FavoriteRequest request) throws CustomNotFoundException {
        FavoriteResponse favoriteResponse = favoriteService.addFavoriteProduct(request);
        return ResponseEntity.ok(favoriteResponse);
    }

    @Override
    public ResponseEntity<String> deleteFavorite(UUID id) throws CustomNotFoundException, CustomForbiddenException {
        boolean isSuccess = favoriteService.deleteFavoriteProduct(id);
        if (!isSuccess) {
            ResponseEntity.badRequest();
        }
        return ResponseEntity.ok("Successfully");
    }

    @Override
    public ResponseEntity<List<FavoriteFullFieldRes>> getFavoriteOfCurrentUser() {
        List<FavoriteFullFieldRes> responses = favoriteService.getAllFavoriteProductOfCurrentUser();
        return ResponseEntity.ok(responses);
    }

}
