package com.hotsummer.luvme.controller.api.exception;

import com.hotsummer.luvme.model.error.CustomError;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class BaseCustomException extends Exception {
    protected Map<String, CustomError> errorHashMap;

    public BaseCustomException(CustomError customerError) {
        errorHashMap = new HashMap<>();
        errorHashMap.put("error", customerError);
    }
}
