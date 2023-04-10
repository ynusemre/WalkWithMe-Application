package com.example.WalkWithMe.dto;


import com.example.WalkWithMe.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalkerDto {
    private Integer id ;
    private String name;
    private String surname;
    private List<Reservation> reservation;
}
