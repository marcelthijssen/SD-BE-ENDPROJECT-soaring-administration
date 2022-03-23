package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.models.Person;

import java.util.List;

public interface PersonService {

    List<PersonDto> getAllPersons();

    PersonDto getPersonById( Long id );

    Person addPerson( PersonDto personDto );

    void deletePersonById( Long id );

    PersonDto updatePerson( Long id, PersonDto dto );

}
