package com.example.WalkWithMe.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogRequest {
    @NotNull
    @NotBlank(message = "Dog name must not bu blank")
    private String name;

    @NotNull
    @NotBlank(message = "Dog breed must not bu blank")
    private String dogBreed;
}
