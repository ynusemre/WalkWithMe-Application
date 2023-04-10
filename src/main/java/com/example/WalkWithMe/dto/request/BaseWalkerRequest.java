package com.example.WalkWithMe.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseWalkerRequest {

    @NotNull
    @NotBlank(message = "Walker name must not bu blank")
    private String name;

    @NotNull
    @NotBlank(message = "Walker surname must not bu blank")
    private String surname;

}
