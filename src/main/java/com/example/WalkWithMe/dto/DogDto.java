package com.example.WalkWithMe.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogDto {
    private Integer id ;
    private String name;
    private String dogBreed;
}
