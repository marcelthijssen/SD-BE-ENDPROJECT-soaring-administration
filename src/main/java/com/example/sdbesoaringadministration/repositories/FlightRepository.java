package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
