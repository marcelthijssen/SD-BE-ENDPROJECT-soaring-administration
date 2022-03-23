package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.AirportDto;
import com.example.sdbesoaringadministration.models.Airport;

import java.util.List;

public interface AirportService{

    List<AirportDto> getAllAirports();

    AirportDto getAirportsById ( Long id);

    Airport addAirport(AirportDto airportDto);

    void deleteAirportById( Long id);

    AirportDto updateAirport(Long id, AirportDto dto);
}
