package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.AirportDto;
import com.example.sdbesoaringadministration.models.Airport;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AirportService{

    List<AirportDto> getAllAirports();

    AirportDto getAirportById ( Long id);

    Airport createAirport( AirportDto airportDto);

    ResponseEntity<Object> deleteAirportById( Long id);

    AirportDto updateAirport(Long id, AirportDto dto);
}
