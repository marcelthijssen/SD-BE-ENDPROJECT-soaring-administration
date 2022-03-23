package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Person;
import com.example.sdbesoaringadministration.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl( PersonRepository personRepository ) {
        this.personRepository = personRepository;
    }


    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> personsList = this.personRepository.findAll();
        List<PersonDto> personsDtoList = new ArrayList<>();

        for ( Person p : personsList ) {
            PersonDto dto = new PersonDto();

            dto.setId( p.getId() );
            dto.setId( p.getId() );
            dto.setGender( p.getGender() );
            dto.setFirstName( p.getFirstName() );
            dto.setLastName( p.getLastName() );
            dto.setDateOfBirth( p.getDateOfBirth() );
            dto.setStreetName( p.getStreetName() );
            dto.setHouseNumber( p.getHouseNumber() );
            dto.setCity( p.getCity() );
            dto.setCountry( p.getCountry() );
            dto.setEmail( p.getEmail() );
            dto.setPhone( p.getPhone() );
            personsDtoList.add( dto );
        }
        return personsDtoList;
    }

    @Override
    public PersonDto getPersonById( Long id ) {
        PersonDto dto = new PersonDto();
        if ( personRepository.findById( id ).isPresent() ) {
            Person p = personRepository.findById( id ).get();
            dto.setId( p.getId() );
            dto.setGender( p.getGender() );
            dto.setFirstName( p.getFirstName() );
            dto.setLastName( p.getLastName() );
            dto.setDateOfBirth( p.getDateOfBirth() );
            dto.setStreetName( p.getStreetName() );
            dto.setHouseNumber( p.getHouseNumber() );
            dto.setCity( p.getCity() );
            dto.setCountry( p.getCountry() );
            dto.setEmail( p.getEmail() );
            dto.setPhone( p.getPhone() );
            return dto;
        } else {
            throw new RecordNotFoundException( "Person not fuond" );
        }
    }

    @Override
    public Person addPerson( PersonDto personDto ) {
        Person p = new Person();
        p.setId( personDto.getId() );
        p.setGender( personDto.getGender() );
        p.setFirstName( personDto.getFirstName() );
        p.setLastName( personDto.getLastName() );
        p.setDateOfBirth( personDto.getDateOfBirth() );
        p.setStreetName( personDto.getStreetName() );
        p.setHouseNumber( personDto.getHouseNumber() );
        p.setCity( personDto.getCity() );
        p.setCountry( personDto.getCountry() );
        p.setEmail( personDto.getEmail() );
        p.setPhone( personDto.getPhone() );
        return this.personRepository.save( p );
    }

    @Override
    public void deletePersonById( Long id ) {
        if ( personRepository.findById( id ).isPresent() ) {
            personRepository.deleteById( id );
        } else {
            throw new RecordNotFoundException( "Person not found" );
        }
    }

    @Override
    public PersonDto updatePerson( Long id, PersonDto dto ) {
        if ( personRepository.findById( id ).isPresent() ) {
            Person p = personRepository.findById( id ).get();

            p.setId( p.getId() );
            p.setGender( p.getGender() );
            p.setFirstName( p.getFirstName() );
            p.setLastName( p.getLastName() );
            p.setDateOfBirth( p.getDateOfBirth() );
            p.setStreetName( p.getStreetName() );
            p.setHouseNumber( p.getHouseNumber() );
            p.setCity( p.getCity() );
            p.setCountry( p.getCountry() );
            p.setEmail( p.getEmail() );
            p.setPhone( p.getPhone() );
            personRepository.save( p );
        }

        return null;
    }
}
