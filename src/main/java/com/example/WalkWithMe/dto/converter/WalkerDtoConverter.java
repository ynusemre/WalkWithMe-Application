package com.example.WalkWithMe.dto.converter;

import com.example.WalkWithMe.dto.WalkerDto;
import com.example.WalkWithMe.model.Walker;
import org.springframework.stereotype.Component;

@Component
public class WalkerDtoConverter {

    public WalkerDto convertToWalkerDto(Walker from){
        return new WalkerDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getReservation()
        );
    }

}
