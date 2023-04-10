package com.example.WalkWithMe.repository;

import com.example.WalkWithMe.model.Walker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalkerRepository extends JpaRepository<Walker,Integer> {
}
