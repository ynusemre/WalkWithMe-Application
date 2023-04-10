package com.example.WalkWithMe.repository;

import com.example.WalkWithMe.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog,Integer> {
}
