package com.hotsummer.luvme.service;

import java.util.List;
import java.util.UUID;

import com.hotsummer.luvme.controller.api.exception.CustomForbiddenException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.request.FavoriteRequest;
import com.hotsummer.luvme.model.response.FavoriteFullFieldRes;
import com.hotsummer.luvme.model.response.FavoriteResponse;

public interface FavoriteService {
    FavoriteResponse addFavoriteProduct(FavoriteRequest request) throws CustomNotFoundException;

    boolean deleteFavoriteProduct(UUID id) throws CustomNotFoundException, CustomForbiddenException;

    List<FavoriteFullFieldRes> getAllFavoriteProductOfCurrentUser();
}
