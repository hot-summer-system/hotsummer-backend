package com.hotsummer.luvme.controller.api.exception;


import com.hotsummer.luvme.model.error.CustomError;

public class CustomDuplicateFieldException extends BaseCustomException {

    public CustomDuplicateFieldException(CustomError customerError) {
        super(customerError);
    }

}
