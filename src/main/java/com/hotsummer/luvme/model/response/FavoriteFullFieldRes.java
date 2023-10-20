package com.hotsummer.luvme.model.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteFullFieldRes {
    private UUID favoriteId;
    private ProductResponse productResponse;
}
