package com.example.WalkWithMe.service;

import com.example.WalkWithMe.dto.DogDto;
import com.example.WalkWithMe.dto.converter.DogDtoConverter;
import com.example.WalkWithMe.dto.request.DogRequest;
import com.example.WalkWithMe.model.Customer;
import com.example.WalkWithMe.model.Dog;
import com.example.WalkWithMe.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DogService {
    private final DogDtoConverter dogDtoConverter;
    private final DogRepository dogRepository;


    public DogDto defineDog (Customer customer,DogRequest request){

        Dog dog = Dog.builder()
                .name(request.getName())
                .dogBreed(request.getDogBreed())
                .customer(customer)
                .build();

        return dogDtoConverter.convertToDogDto(dogRepository.save(dog));

    }
}
