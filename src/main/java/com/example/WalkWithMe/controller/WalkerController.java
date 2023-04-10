package com.example.WalkWithMe.controller;

import com.example.WalkWithMe.dto.CustomerDto;
import com.example.WalkWithMe.dto.ReservationDto;
import com.example.WalkWithMe.dto.WalkerDto;
import com.example.WalkWithMe.dto.request.CreateCustomerRequest;
import com.example.WalkWithMe.dto.request.CreateWalkerRequest;
import com.example.WalkWithMe.dto.request.UpdateCustomerRequest;
import com.example.WalkWithMe.dto.request.UpdateWalkerRequest;
import com.example.WalkWithMe.service.WalkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/walkers")
public class WalkerController {
    private final WalkerService walkerService;

    @PostMapping
    public ResponseEntity<WalkerDto> save(@Valid @RequestBody CreateWalkerRequest walkerRequest){
        return ResponseEntity.ok(walkerService.save(walkerRequest));
    }

    @GetMapping
    public ResponseEntity<List<WalkerDto>> getAllWalkers(){
        return ResponseEntity.ok(walkerService.getAllWalkers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalkerDto> getWalkerById(@PathVariable Integer id){
        return ResponseEntity.ok(walkerService.getWalkerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWalker(@PathVariable Integer id){
        walkerService.deleteWalker(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WalkerDto> updateWalker(@PathVariable Integer id,
                                                      @Valid @RequestBody UpdateWalkerRequest walkerRequest){
        return ResponseEntity.ok(walkerService.updateWalker(id,walkerRequest));
    }


    @PutMapping("/select/{reservation_id}/{walker_id}")
    public ResponseEntity<ReservationDto> selectReservation(@PathVariable Integer reservation_id,
                                                            @PathVariable Integer walker_id){
        return ResponseEntity.ok(walkerService.selectReservation(reservation_id,walker_id));
    }

    @GetMapping("/start/{reservation_id}")
    public ResponseEntity<String> startReservation(@PathVariable Integer reservation_id){
        return ResponseEntity.ok(walkerService.startReservation(reservation_id));
    }

    @DeleteMapping("/deleteReservation/{reservation_id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Integer reservation_id){
        walkerService.deleteReservation(reservation_id);
        return ResponseEntity.ok().build();
    }
}
