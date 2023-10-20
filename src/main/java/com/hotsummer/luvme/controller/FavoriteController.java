package com.hotsummer.luvme.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotsummer.luvme.controller.api.exception.CustomForbiddenException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.request.FavoriteRequest;
import com.hotsummer.luvme.model.response.FavoriteFullFieldRes;
import com.hotsummer.luvme.model.response.FavoriteResponse;
import com.hotsummer.luvme.model.response.ProductResponse;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("api/v1/favorite")
public interface FavoriteController {
        @Operation(summary = "Add Favorite Product", description = "Add Favorite Product Of a user")
        @PostMapping("/add")
        @PreAuthorize("hasAuthority('CUSTOMER')")
        public ResponseEntity<FavoriteResponse> addFavoriteProduct(@RequestBody FavoriteRequest request)
                        throws CustomNotFoundException;

        @Operation(summary = "Delete Favorite Product", description = "Delete Favorite Product Of a User")
        @PreAuthorize("hasAuthority('CUSTOMER')")
        @DeleteMapping("/remove/{id}")
        public ResponseEntity<String> deleteFavorite(@PathVariable UUID id)
                        throws CustomNotFoundException, CustomForbiddenException;

        @Operation(summary = "Get Favorite Product", description = "Get Favorite Product Of a User")
        @PreAuthorize("hasAuthority('CUSTOMER')")
        @GetMapping("/get")
        public ResponseEntity<List<FavoriteFullFieldRes>> getFavoriteOfCurrentUser();
}
