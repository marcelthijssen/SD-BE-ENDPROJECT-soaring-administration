package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.models.Person;

import java.util.List;

public interface PersonService {

    List<PersonDto> getAllPersons();

    PersonDto getPersonById( Long pid );

    Person addPerson( PersonDto personDto );

    void deletePersonById( Long pid );

    PersonDto updatePerson( Long pid, PersonDto dto );

//    PersonDto addTypeOfMembershipToPerson(Long  pid, Long tomid);

}
