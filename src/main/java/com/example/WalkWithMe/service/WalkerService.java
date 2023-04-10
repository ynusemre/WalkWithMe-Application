package com.example.WalkWithMe.service;

import com.example.WalkWithMe.dto.ReservationDto;
import com.example.WalkWithMe.dto.WalkerDto;
import com.example.WalkWithMe.dto.converter.ReservationDtoConverter;
import com.example.WalkWithMe.dto.converter.WalkerDtoConverter;
import com.example.WalkWithMe.dto.request.CreateWalkerRequest;
import com.example.WalkWithMe.dto.request.UpdateCustomerRequest;
import com.example.WalkWithMe.dto.request.UpdateWalkerRequest;
import com.example.WalkWithMe.exception.ReservationTimeTakenException;
import com.example.WalkWithMe.exception.WalkerNotFoundException;
import com.example.WalkWithMe.model.Customer;
import com.example.WalkWithMe.model.Reservation;
import com.example.WalkWithMe.model.Walker;
import com.example.WalkWithMe.repository.ReservationRepository;
import com.example.WalkWithMe.repository.WalkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WalkerService {
    private final WalkerRepository walkerRepository;
    private final WalkerDtoConverter walkerDtoConverter;
    private final ReservationService reservationService;

    public WalkerDto save(CreateWalkerRequest request){
        Walker walker = Walker.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .reservation(new ArrayList<>()).build();

        return walkerDtoConverter.convertToWalkerDto(walkerRepository.save(walker));
    }

    public List<WalkerDto> getAllWalkers() {
        return walkerRepository.findAll()
                .stream()
                .map(walkerDtoConverter::convertToWalkerDto)
                .collect(Collectors.toList());
    }

    protected Walker findWalkerById(Integer id){
        return walkerRepository.findById(id)
                .orElseThrow(()-> new WalkerNotFoundException("Walker could not found by id :" + id));
    }

    public WalkerDto getWalkerById(Integer id) {
        return walkerDtoConverter.convertToWalkerDto(findWalkerById(id));
    }


    public void deleteWalker(Integer id) {
        walkerRepository.deleteById(id);
    }

    public WalkerDto updateWalker(Integer id, UpdateWalkerRequest request) {
        Walker walker = findWalkerById(id);

        walker.setName(request.getName());
        walker.setSurname(request.getSurname());

        return walkerDtoConverter.convertToWalkerDto(walkerRepository.save(walker));
    }

    public ReservationDto selectReservation(Integer reservation_id,Integer walker_id){

        Walker walker = findWalkerById(walker_id);

        return reservationService.selectReservation(reservation_id,walker);
    }

    public String startReservation(Integer reservation_id){

        return reservationService.startReservation(reservation_id);
    }

    public void deleteReservation(Integer reservation_id) {
        reservationService.deleteReservation(reservation_id);
    }

}
