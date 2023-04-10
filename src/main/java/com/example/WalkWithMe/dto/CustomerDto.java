package com.example.WalkWithMe.dto;

import com.example.WalkWithMe.model.Dog;
import com.example.WalkWithMe.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Integer id ;
    private String name;
    private String surname;
    private List<Dog> dog;
    private List<Reservation> reservation;
}
