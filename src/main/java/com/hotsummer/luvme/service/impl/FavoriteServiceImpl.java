package com.hotsummer.luvme.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hotsummer.luvme.controller.api.exception.CustomForbiddenException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.entity.Favorite;
import com.hotsummer.luvme.model.entity.Product;
import com.hotsummer.luvme.model.entity.UserTbl;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.mapper.ObjectMapper;
import com.hotsummer.luvme.model.request.FavoriteRequest;
import com.hotsummer.luvme.model.response.FavoriteResponse;
import com.hotsummer.luvme.model.response.ProductResponse;
import com.hotsummer.luvme.repository.FavoriteRepository;
import com.hotsummer.luvme.repository.ProductRepository;
import com.hotsummer.luvme.service.FavoriteService;
import com.hotsummer.luvme.service.Authentication.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final ProductRepository productRepository;

    @Override
    public FavoriteResponse addFavoriteProduct(FavoriteRequest request) throws CustomNotFoundException {
        Product product = productRepository.findByProductId(request.getProductId());
        if (product == null) {
            throw new CustomNotFoundException(
                    CustomError.builder().errorCode("404").message("Not found product").build());
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(currentDateTime);
        UserTbl userTbl = AuthenticationService.getCurrentUserFromSecurityContext();
        Favorite favorite = new Favorite(UUID.randomUUID(), timestamp, product, userTbl);
        favoriteRepository.save(favorite);
        FavoriteResponse favoriteResponse = ObjectMapper.fromFavoriteToFavoriteResponse(favorite);
        return favoriteResponse;
    }

    @Override
    public boolean deleteFavoriteProduct(UUID id) throws CustomNotFoundException, CustomForbiddenException {
        Favorite favorite = favoriteRepository.findById(id).orElse(null);
        if (favorite == null) {
            throw new CustomNotFoundException(
                    CustomError.builder().errorCode("404").message("Not found product").build());
        }
        if (favorite.getUserAct().getUserId() != AuthenticationService.getCurrentUserFromSecurityContext()
                .getUserId()) {
            throw new CustomForbiddenException(
                    CustomError.builder().errorCode("403").message("favorite not belongs of you").build());
        }
        favoriteRepository.deleteById(id);
        return true;
    }

    @Override
    public List<ProductResponse> getAllFavoriteProductOfCurrentUser() {
        UserTbl user = AuthenticationService.getCurrentUserFromSecurityContext();
        List<Favorite> favorites = favoriteRepository.findAll().stream()
                .filter(f -> user.getUserId() == f.getUserAct().getUserId()).toList();
        List<ProductResponse> responses = new ArrayList<>();
        for (Favorite favorite : favorites) {
            Product product = favorite.getProduct();
            responses.add(ObjectMapper.fromProductToProductResponse(product));
        }
        return responses;
    }

}
