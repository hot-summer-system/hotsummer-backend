package com.hotsummer.luvme.service;

import java.util.List;

import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.response.ProductResponse;

public interface ProductService {
    List<ProductResponse> getProductWithSuitableSkinType()
            throws CustomNotFoundException, CustomInternalServerException;

    List<ProductResponse> getProductWithCategory(String categoryCode) throws CustomNotFoundException, CustomInternalServerException
}
