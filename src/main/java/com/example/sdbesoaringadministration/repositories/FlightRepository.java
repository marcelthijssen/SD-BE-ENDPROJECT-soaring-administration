package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    
    List<Flight>findFlightsByCaptain_Id( Long id );

//    boolean queryFlightsByCaptain( Long pid );
}
