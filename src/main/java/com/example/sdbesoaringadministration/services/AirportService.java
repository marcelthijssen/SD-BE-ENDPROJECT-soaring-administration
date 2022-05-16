/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.AirportDto;
import com.example.sdbesoaringadministration.models.Airport;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AirportService {

    List<AirportDto> getAllAirports();

    AirportDto getAirportById( Long airportId );

    Airport createAirport( AirportDto airportDto );

    ResponseEntity<Object> deleteAirportById( Long airportId );

    AirportDto updateAirport( Long airportId, AirportDto dto );
}
