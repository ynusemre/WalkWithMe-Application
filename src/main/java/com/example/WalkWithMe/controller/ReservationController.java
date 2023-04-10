package com.example.WalkWithMe.controller;

import com.example.WalkWithMe.dto.CustomerDto;
import com.example.WalkWithMe.dto.ReservationDto;
import com.example.WalkWithMe.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservations(){
        return ResponseEntity.ok(reservationService.getAllReservations());
    }
}
