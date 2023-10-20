package com.hotsummer.luvme.model.response;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteResponse {
    private UUID favoriteId;
    private Date addDate;
    private UUID productId;
    private int userId;
}
