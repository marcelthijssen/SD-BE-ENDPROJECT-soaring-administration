package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.AirportDto;
import com.example.sdbesoaringadministration.models.Airport;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AirportService{

    List<AirportDto> getAllAirports();

    AirportDto getAirportsById ( Long id);

    Airport addAirport(AirportDto airportDto);

    ResponseEntity<Object> deleteAirportById( Long id);

    AirportDto updateAirport(Long id, AirportDto dto);
}
