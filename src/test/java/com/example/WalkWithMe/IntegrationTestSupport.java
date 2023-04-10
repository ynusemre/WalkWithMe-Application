package com.example.WalkWithMe;

import com.example.WalkWithMe.dto.converter.CustomerDtoConverter;
import com.example.WalkWithMe.repository.CustomerRepository;
import com.example.WalkWithMe.service.DogService;
import com.example.WalkWithMe.service.ReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public abstract class IntegrationTestSupport extends TestSupport{
    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public CustomerDtoConverter converter;

    @Autowired
    public DogService dogService;

    @Autowired
    public ReservationService reservationService;

    public final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup(){
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);

    }

}
