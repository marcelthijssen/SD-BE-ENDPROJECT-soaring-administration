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

    StartingMethodeDto getStartingMethodeById( Long smid );

    void createStartingMethode( StartingMethodeDto startingMethodeDto );

    void deleteStartingMethodeById( Long smid );

    void updateStartingMethode( Long smid, StartingMethodeDto dto );
}
