package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.models.Person;

import java.util.List;

public interface PersonService {

    List<PersonDto> getAllPersons();

    PersonDto getPersonById( Long pid );

    PersonDto addPerson( PersonDto personDto );

    void deletePersonById( Long pid );

    PersonDto updatePerson( Long pid, PersonDto dto );

    void addMembershipToPerson(Long  pid, Long mbid);

    void assignRoleToPerson(Long  pid, Long rid);

}
