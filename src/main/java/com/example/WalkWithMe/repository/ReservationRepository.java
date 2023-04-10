package com.example.WalkWithMe.repository;

import com.example.WalkWithMe.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
