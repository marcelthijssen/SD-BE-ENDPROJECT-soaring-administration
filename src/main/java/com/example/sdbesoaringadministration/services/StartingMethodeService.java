package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.StartingMethodeDto;
import com.example.sdbesoaringadministration.models.StartingMethode;

import java.util.List;

public interface StartingMethodeService {

    List<StartingMethodeDto> getAllStartingMethodes();

    StartingMethodeDto getStartingMethodeById( Long id );

    StartingMethode addStartingMethode( StartingMethodeDto startingMethodeDto );

    void deleteStartingMethodeById( Long id );

    StartingMethodeDto updateStartingMethode( Long id, StartingMethodeDto dto );
}
