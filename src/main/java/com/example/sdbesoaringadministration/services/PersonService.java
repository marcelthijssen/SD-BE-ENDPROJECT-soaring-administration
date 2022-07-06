/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.AddressDto;
import com.example.sdbesoaringadministration.dtos.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PersonService {

    List<PersonDto> getAllPersons();

    PersonDto getPersonById( Long person_id );

    PersonDto createPerson( PersonDto personDto );

    void deletePersonById( Long person_id );

    PersonDto updatePerson( Long person_id, PersonDto dto );

    void addMembershipToPerson( Long person_id, Long membership_id );

    void addAddressToPerson( Long person_id, AddressDto addressDto );

//    void addAddressToPerson( Long person_id );

//    void addAddressToPerson( Long person_id );
}
