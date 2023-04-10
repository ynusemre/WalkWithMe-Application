package com.example.WalkWithMe;

import com.example.WalkWithMe.dto.request.DogRequest;
import com.example.WalkWithMe.dto.request.ReservationRequest;
import com.example.WalkWithMe.model.Customer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class TestSupport {

    public static final String CUSTOMER_API_ENDPOINT = "/v1/api/customers/";

    public Customer generateCustomer() {
        return new Customer(0,"name","surname", List.of(),List.of());
    }

    public DogRequest genretateDogRequest(String name,String dogBreed){
        return new DogRequest(name,dogBreed);
    }

    public ReservationRequest genretateReservationRequest(LocalDateTime startRes, LocalDateTime finishRes){
        return new ReservationRequest(startRes,finishRes);
    }

}
