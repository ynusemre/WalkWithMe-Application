package com.example.WalkWithMe.dto.converter;

import com.example.WalkWithMe.dto.CustomerDto;
import com.example.WalkWithMe.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {
    public CustomerDto convertToCustomerDto(Customer from){
        return new CustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getDog(),
                from.getReservation()
        );
    }
}
