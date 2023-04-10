package com.example.WalkWithMe.dto.converter;

import com.example.WalkWithMe.dto.DogDto;
import com.example.WalkWithMe.model.Dog;
import org.springframework.stereotype.Component;

@Component
public class DogDtoConverter {
    public DogDto convertToDogDto(Dog from){
        return new DogDto(
                from.getId(),
                from.getName(),
                from.getDogBreed()
        );
    }
}
