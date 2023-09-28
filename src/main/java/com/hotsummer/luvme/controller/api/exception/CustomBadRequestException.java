package com.hotsummer.luvme.controller.api.exception;

import com.hotsummer.luvme.model.error.CustomError;

public class CustomBadRequestException extends BaseCustomException {

    public CustomBadRequestException(CustomError customerError) {
        super(customerError);
    }

}
