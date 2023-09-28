package com.hotsummer.luvme.controller.api.exception;

import com.hotsummer.luvme.model.error.CustomError;

public class CustomInternalServerException extends BaseCustomException {

    public CustomInternalServerException(CustomError customerError) {
        super(customerError);
    }

}
