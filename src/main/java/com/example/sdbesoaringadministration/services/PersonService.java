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

import com.example.sdbesoaringadministration.dtos.PersonDto;

import java.util.List;

public interface PersonService {

    List<PersonDto> getAllPersons();

    PersonDto getPersonById( Long personId );

    PersonDto createPerson( PersonDto personDto );

    void deletePersonById( Long personId );

    PersonDto updatePerson( Long personId, PersonDto dto );

    void addMembershipToPerson(Long  personId, Long membershipId);


}
