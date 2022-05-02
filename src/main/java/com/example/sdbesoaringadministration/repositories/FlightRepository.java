/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Extends JpaRepository and communicates with database column 'flights'
 *
 */

package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

//    List<Flight> findFlightsByBilledPersonEquals( Long id );

    List<Flight> findFlightsByCaptain_Id( Long cpid );
}
