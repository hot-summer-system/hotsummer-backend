package com.hotsummer.luvme.controller.api.exception;

import com.hotsummer.luvme.model.error.CustomError;

public class CustomNotFoundException extends BaseCustomException {

    public CustomNotFoundException(CustomError customerError) {
        super(customerError);
    }

}
