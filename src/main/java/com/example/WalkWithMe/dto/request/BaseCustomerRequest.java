package com.example.WalkWithMe.dto.request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseCustomerRequest {

    @NotNull
    @NotBlank(message = "Customer name must not bu blank")
    private String name;

    @NotNull
    @NotBlank(message = "Customer surname must not bu blank")
    private String surname;

}
