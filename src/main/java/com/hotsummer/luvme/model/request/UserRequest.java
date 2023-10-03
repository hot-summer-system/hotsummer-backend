package com.hotsummer.luvme.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.auto.value.AutoValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@Data
public class UserRequest {
    @NotBlank
    private String fullName;
    @NotBlank
    private String gender;
    private String birthDay;

}
