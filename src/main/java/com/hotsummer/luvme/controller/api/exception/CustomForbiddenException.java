package com.hotsummer.luvme.controller.api.exception;

import com.hotsummer.luvme.model.error.CustomError;

public class CustomForbiddenException extends BaseCustomException {

    public CustomForbiddenException(CustomError customerError) {
        super(customerError);
    }
}
