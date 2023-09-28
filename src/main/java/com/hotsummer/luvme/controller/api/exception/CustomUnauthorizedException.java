package com.hotsummer.luvme.controller.api.exception;


import com.hotsummer.luvme.model.error.CustomError;

public class CustomUnauthorizedException extends BaseCustomException {

    public CustomUnauthorizedException(CustomError customerError) {
        super(customerError);
    }

}
