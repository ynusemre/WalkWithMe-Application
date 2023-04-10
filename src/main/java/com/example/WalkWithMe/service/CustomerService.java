package com.example.WalkWithMe.service;

import com.example.WalkWithMe.dto.CustomerDto;
import com.example.WalkWithMe.dto.DogDto;
import com.example.WalkWithMe.dto.ReservationDto;
import com.example.WalkWithMe.dto.converter.CustomerDtoConverter;
import com.example.WalkWithMe.dto.converter.DogDtoConverter;
import com.example.WalkWithMe.dto.converter.ReservationDtoConverter;
import com.example.WalkWithMe.dto.request.CreateCustomerRequest;
import com.example.WalkWithMe.dto.request.DogRequest;
import com.example.WalkWithMe.dto.request.ReservationRequest;
import com.example.WalkWithMe.dto.request.UpdateCustomerRequest;
import com.example.WalkWithMe.exception.CustomerNotFoundException;
import com.example.WalkWithMe.exception.ReservationTimeTakenException;
import com.example.WalkWithMe.model.Customer;
import com.example.WalkWithMe.model.Dog;
import com.example.WalkWithMe.model.Reservation;
import com.example.WalkWithMe.repository.CustomerRepository;
import com.example.WalkWithMe.repository.DogRepository;
import com.example.WalkWithMe.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;
    private final DogService dogService;
    private final ReservationService reservationService;

    public CustomerDto save(CreateCustomerRequest request){
        Customer customer = Customer.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .dog(new ArrayList<>())
                .reservation(new ArrayList<>()).build();

        return customerDtoConverter.convertToCustomerDto(customerRepository.save(customer));
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerDtoConverter::convertToCustomerDto)
                .collect(Collectors.toList());
    }

    protected Customer findCustomerById(Integer id){
        return customerRepository.findById(id)
                .orElseThrow(()-> new CustomerNotFoundException("Customer could not found by id :" + id));
    }

    public CustomerDto getCustomerById(Integer id) {
        return customerDtoConverter.convertToCustomerDto(findCustomerById(id));
    }


    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public CustomerDto updateCustomer(Integer id, UpdateCustomerRequest request) {
        Customer customer = findCustomerById(id);

        customer.setName(request.getName());
        customer.setSurname(request.getSurname());

        return customerDtoConverter.convertToCustomerDto(customerRepository.save(customer));
    }

    public DogDto defineDog(Integer id,DogRequest request){
        Customer customer = findCustomerById(id);

        return dogService.defineDog(customer,request);

    }

    public ReservationDto createRes(Integer id,ReservationRequest request) {
        Customer customer = findCustomerById(id);

        return  reservationService.createRes(customer,request);
    }


}
