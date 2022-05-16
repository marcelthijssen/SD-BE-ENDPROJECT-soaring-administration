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

import com.example.sdbesoaringadministration.dtos.StartingMethodeDto;

import java.util.List;

public interface StartingMethodeService {

    List<StartingMethodeDto> getAllStartingMethodes();

    StartingMethodeDto getStartingMethodeById( Long startingMethodeId );

    void createStartingMethode( StartingMethodeDto startingMethodeDto );

    void deleteStartingMethodeById( Long startingMethodeId );

    void updateStartingMethode( Long startingMethodeId, StartingMethodeDto dto );
}
