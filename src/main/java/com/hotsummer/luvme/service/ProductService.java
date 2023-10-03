package com.hotsummer.luvme.service;

import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.entity.Product;
import com.hotsummer.luvme.model.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getProductWithSuitableSkinType() throws CustomNotFoundException, CustomInternalServerException;
}
