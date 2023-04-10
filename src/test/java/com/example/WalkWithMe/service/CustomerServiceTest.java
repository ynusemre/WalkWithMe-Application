package com.example.WalkWithMe.service;

import com.example.WalkWithMe.dto.CustomerDto;
import com.example.WalkWithMe.dto.converter.CustomerDtoConverter;
import com.example.WalkWithMe.dto.converter.DogDtoConverter;
import com.example.WalkWithMe.dto.converter.ReservationDtoConverter;
import com.example.WalkWithMe.exception.CustomerNotFoundException;
import com.example.WalkWithMe.model.Customer;
import com.example.WalkWithMe.repository.CustomerRepository;
import com.example.WalkWithMe.repository.DogRepository;
import com.example.WalkWithMe.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CustomerServiceTest {

    private  CustomerRepository customerRepository;
    private  CustomerDtoConverter customerDtoConverter;
    private  DogService dogService;
    private  ReservationService reservationService;

    private CustomerService service;

    @BeforeEach
    public void setUp(){
        customerRepository= mock(CustomerRepository.class);
        customerDtoConverter=mock(CustomerDtoConverter.class);
        dogService=mock(DogService.class);
        reservationService=mock(ReservationService.class);
        service = new CustomerService(customerRepository,customerDtoConverter,dogService,reservationService);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer= new Customer(0,"name","surname", List.of(),List.of());

        Mockito.when(customerRepository.findById(0)).thenReturn(Optional.of(customer));

        Customer result = service.findCustomerById(0);

        assertEquals(result,customer);

    }

    @Test
    public void testFindByCustomerId_whenCustomerIdDoesNotExist_shouldThrowCustomerNotFoundException(){
        Mockito.when(customerRepository.findById(0)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class,() -> service.findCustomerById(0));
    }

    @Test
    public void testGetCustomerId_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer= new Customer(0,"name","surname", List.of(),List.of());
        CustomerDto customerDto = new CustomerDto(0,"name","surname", List.of(),List.of());

        Mockito.when(customerRepository.findById(0)).thenReturn(Optional.of(customer));
        Mockito.when(customerDtoConverter.convertToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto result = service.getCustomerById(0);

        assertEquals(result,customerDto);

    }

    @Test
    public void testGetCustomerId_whenCustomerIdDoesNotExists_shouldThrowCustomerDoesNotException(){
        Mockito.when(customerRepository.findById(0)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class,()->service.getCustomerById(0));

        Mockito.verifyNoInteractions(customerDtoConverter);

    }

}