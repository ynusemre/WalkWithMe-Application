package com.example.WalkWithMe.service;

import com.example.WalkWithMe.dto.ReservationDto;
import com.example.WalkWithMe.dto.converter.ReservationDtoConverter;
import com.example.WalkWithMe.dto.request.ReservationRequest;
import com.example.WalkWithMe.exception.ReservationNotFoundException;
import com.example.WalkWithMe.exception.ReservationTimeTakenException;
import com.example.WalkWithMe.model.Customer;
import com.example.WalkWithMe.model.Reservation;
import com.example.WalkWithMe.model.Walker;
import com.example.WalkWithMe.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationDtoConverter reservationDtoConverter;
    protected Reservation findReservationById(Integer id){
        return reservationRepository.findById(id)
                .orElseThrow(()-> new ReservationNotFoundException("Reservation could not found by id :" + id));
    }

    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(reservationDtoConverter::convertToReservationDto)
                .collect(Collectors.toList());
    }

    public ReservationDto createRes(Customer customer,ReservationRequest request) {


        for (Reservation reservation: customer.getReservation()     ) {
            if(reservation.getStartRes().isBefore(request.getStartRes()) &&
                    reservation.getFinishRes().isAfter(request.getStartRes()) ){

                throw new ReservationTimeTakenException("This reservation time taken before : " + request.getStartRes());
            }
        }

        Reservation reservation = Reservation.builder()
                .startRes(request.getStartRes())
                .finishRes(request.getFinishRes())
                .customer(customer)
                .walker(null)
                .build();

        return reservationDtoConverter.convertToReservationDto(reservationRepository.save(reservation));
    }

    public ReservationDto selectReservation(Integer reservation_id,Walker walker){
        Reservation reservation = findReservationById(reservation_id);


        for (Reservation res: walker.getReservation() ) {
            if(res.getId() ==  reservation_id){
                throw new ReservationTimeTakenException("This reservation time taken before : " + reservation.getStartRes());
            }
        }
        reservation.setWalker(walker);
        return reservationDtoConverter.convertToReservationDto(reservationRepository.save(reservation));
    }

    public String startReservation(Integer reservation_id){
        Reservation reservation = findReservationById(reservation_id);

        int result = reservation.getStartRes().getMinute() - LocalDateTime.now().getMinute() ;

        if(result == 5){
            return "Reservation is Started";
        }

        return "You can not start reservation yet" ;
    }

    public void deleteReservation(Integer reservation_id) {
        Reservation reservation = findReservationById(reservation_id);

        reservationRepository.delete(reservation);
    }

}
