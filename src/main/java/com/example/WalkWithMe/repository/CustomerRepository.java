package com.example.WalkWithMe.repository;

import com.example.WalkWithMe.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
