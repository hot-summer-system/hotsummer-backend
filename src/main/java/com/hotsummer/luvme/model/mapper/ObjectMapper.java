package com.hotsummer.luvme.model.mapper;

import com.hotsummer.luvme.model.entity.*;
import com.hotsummer.luvme.model.response.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapper {
    public static ProductResponse fromProductToProductResponse(Product product){
        if(product == null){
            return null;
        }

        List<ProductSkinTypeResponse> productSkinTypeResponseList = product.getProductSkinTypes().stream()
                .map(skinType -> new ProductSkinTypeResponse(
                        skinType.getProductSkinTypeId(),
                        skinType.getDescription(),
                        new SuitableSkinTypeResponse(
                                skinType.getSuitableSkinType().getSuitableSkinTypeId(),
                                skinType.getSuitableSkinType().getDescription()
                        )
                ))
                .collect(Collectors.toList());

        List<ProductCategoryResponse> productCategoryResponseList = product.getProductCategories().stream()
                .map(category -> new ProductCategoryResponse(
                        category.getProductCategoryId(),
                        category.getDescription(),
                        new CategoryResponse(
                                category.getCategory().getCategoryId(),
                                category.getCategory().getCategoryName(),
                                category.getCategory().getCategoryCode(),
                                category.getCategory().getImage()
                        )
                ))
                .collect(Collectors.toList());

        List<ProductCharacteristicsResponse> productCharacteristicsResponseList = product.getProductCharacteristics().stream()
                .map(productCharacteristics -> new ProductCharacteristicsResponse(
                        productCharacteristics.getProductCharacteristicsId(),
                        new CharacteristicResponse(
                                productCharacteristics.getCharacteristic().getCharacteristicsId(),
                                productCharacteristics.getCharacteristic().getDescription()
                        )
                ))
                .collect(Collectors.toList());

        List<ProductIngredientResponse> productIngredientResponseList = product.getProductIngredients().stream()
                .map(ingredient -> new ProductIngredientResponse(
                        ingredient.getProductIngredientId(),
                        ingredient.getDescription(),
                        new IngredientResponse(
                                ingredient.getIngredient().getIngredientId(),
                                ingredient.getIngredient().getName(),
                                ingredient.getIngredient().getDescription()
                        )
                ))
                .collect(Collectors.toList());

        ProductResponse.ProductResponseBuilder builder = ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productImage(product.getProductImage())
                .description(product.getDescription())
                .productSkinTypeResponses(productSkinTypeResponseList)
                .productCategoryResponses(productCategoryResponseList)
                .productCharacteristicsResponses(productCharacteristicsResponseList)
                .productIngredientResponses(productIngredientResponseList);


        return  builder.build();
    }
    public static QuestionResponse fromQuestionToQuestionResponseFullFill(Question question) {
        List<AnswerResponse> answerResponseList = new ArrayList<>();
        if (question != null) {
            if (question.getAnswers() != null) {
                for (Answer answer : question.getAnswers()) {
                    AnswerResponse.AnswerResponseBuilder builder = AnswerResponse.builder()
                            .answerId(answer.getAnswerId())
                            .content(answer.getContent())
                            .linkedQuestionId(answer.getLinkedQuestionId());
                    if (answer.getResult() != null) {
                        builder.resultId(answer.getResult().getResultId());
                    }
                    answerResponseList.add(builder.build());
                }
            }
        }
        return QuestionResponse.builder()
                .questionId(question.getQuestionId())
                .content(question.getContent())
                .answers(answerResponseList)
                .build();
    }

    public static ResultResponse fromResultToResultResponse(Result result) {
        return result == null ? null
                : ResultResponse.builder()
                        .resultId(result.getResultId())
                        .content(result.getContent())
                        .image(result.getImage() == null ? "" : result.getImage())
                        .build();
    }

    public static AnswerResponse fromAnswerToAnswerResponse(Answer answer) {
        return answer == null ? null
                : AnswerResponse.builder()
                        .answerId(answer.getAnswerId())
                        .content(answer.getContent())
                        .build();
    }

    public static UserResponse fromUserTblToUserResponse(UserTbl userTbl){
        return userTbl == null ? null
                : UserResponse.builder()
                .userId(userTbl.getUserId())
                .email(userTbl.getEmail())
                .fullName(userTbl.getFullName())
                .gender(userTbl.getGender())
                .status(userTbl.getStatus())
                .birthDay(userTbl.getBirthDay())
                .bankAccount(userTbl.getBankAccount())
                .isPremium(userTbl.getIsPremium())
                .startPremiumDate(userTbl.getStartPremiumDate())
                .endPremiumDate(userTbl.getEndPremiumDate())
                .isTest(userTbl.getIsTest())
                .build();
    }


}
