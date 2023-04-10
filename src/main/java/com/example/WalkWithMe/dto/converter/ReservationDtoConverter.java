package com.example.WalkWithMe.dto.converter;

import com.example.WalkWithMe.dto.ReservationDto;
import com.example.WalkWithMe.model.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationDtoConverter {
    public ReservationDto convertToReservationDto(Reservation from){
        return new ReservationDto(
                from.getId(),
                from.getStartRes(),
                from.getFinishRes(),
                from.getCustomer(),
                from.getWalker()
        );
    }
}
