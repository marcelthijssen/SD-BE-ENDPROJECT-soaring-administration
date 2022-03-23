package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.dtos.StartingMethodeDto;
import com.example.sdbesoaringadministration.models.Person;

import java.util.List;

public interface StartingMethodeService {

    List<StartingMethodeDto> getAllStartingMethodes();

    StartingMethodeDto getStartingMethodeById( Long id );

    Person addStartingMethode( StartingMethodeDto startingMethodeDto );

    void deleteStartingMethodeById( Long id );

    StartingMethodeDto updateStartingMethode( Long id, StartingMethodeDto dto );
}
