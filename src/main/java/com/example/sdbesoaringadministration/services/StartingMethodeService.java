/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.StartingMethodeDto;

import java.util.List;

public interface StartingMethodeService {

    List<StartingMethodeDto> getAllStartingMethodes();

    StartingMethodeDto getStartingMethodeById( Long startingMethode_id );

    void createStartingMethode( StartingMethodeDto startingMethodeDto );

    void deleteStartingMethodeById( Long startingMethode_id );

    void updateStartingMethode( Long startingMethode_id, StartingMethodeDto dto );
}
