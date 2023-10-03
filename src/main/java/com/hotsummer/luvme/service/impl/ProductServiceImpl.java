package com.hotsummer.luvme.service.impl;

import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.entity.Product;
import com.hotsummer.luvme.model.entity.TestHistory;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.mapper.ObjectMapper;
import com.hotsummer.luvme.model.mapper.SkinTypeConverter;
import com.hotsummer.luvme.model.response.ProductResponse;
import com.hotsummer.luvme.repository.ProductRepository;
import com.hotsummer.luvme.repository.TestHistoryRepository;
import com.hotsummer.luvme.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final TestHistoryRepository testHistoryRepository;
    @Override
    public List<ProductResponse> getProductWithSuitableSkinType() throws CustomNotFoundException, CustomInternalServerException {

         String skinType = SkinTypeConverter.fromResultToSkinType(testHistoryRepository.findSpecificFieldFromNewestRecord());

          List<Product> products = productRepository.findProductsBySuitableSkinTypeDescription(skinType)
                  .orElseThrow(() -> new CustomNotFoundException(
                          CustomError.builder().errorCode("400").message("No Product Found").field("Suitable Skin Type").build()));

          List<ProductResponse> productResponses = new ArrayList<>();
          try{
              for (Product product : products){
                  productResponses.add(ObjectMapper.fromProductToProductResponse(product));
              }
          }catch (Exception e){
              throw new CustomInternalServerException(
                      CustomError.builder().errorCode("500").errorCode(e.getMessage()).field("Suitable Skin Type").build());
          }

          return productResponses;
    }
}
