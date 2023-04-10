package com.example.WalkWithMe.dto;

import com.example.WalkWithMe.model.Customer;
import com.example.WalkWithMe.model.Walker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Integer id ;
    private LocalDateTime startRes;
    private LocalDateTime finishRes;
    private Customer customer;
    private Walker walker;
}
