package com.example.WalkWithMe.controller;

import com.example.WalkWithMe.dto.CustomerDto;
import com.example.WalkWithMe.dto.DogDto;
import com.example.WalkWithMe.dto.ReservationDto;
import com.example.WalkWithMe.dto.request.CreateCustomerRequest;
import com.example.WalkWithMe.dto.request.DogRequest;
import com.example.WalkWithMe.dto.request.ReservationRequest;
import com.example.WalkWithMe.dto.request.UpdateCustomerRequest;
import com.example.WalkWithMe.service.CustomerService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> save(@Valid @RequestBody CreateCustomerRequest customerRequest){
        return ResponseEntity.ok(customerService.save(customerRequest));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Integer id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Integer id,
                                                      @Valid @RequestBody UpdateCustomerRequest customerRequest){
        return ResponseEntity.ok(customerService.updateCustomer(id,customerRequest));
    }

    @PostMapping("/defineDog/{id}")
    public ResponseEntity<DogDto> defineDog(@PathVariable  Integer id,
                                            @Valid @RequestBody DogRequest request){

        return ResponseEntity.ok(customerService.defineDog(id,request));
    }

    @PostMapping("/createRes/{id}")
    public ResponseEntity<ReservationDto> createRes(@PathVariable Integer id,
                                                    @RequestBody ReservationRequest request){

        return  ResponseEntity.ok(customerService.createRes(id,request));
    }


}
