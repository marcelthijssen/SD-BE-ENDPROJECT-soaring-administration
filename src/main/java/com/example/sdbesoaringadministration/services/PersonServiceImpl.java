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
            dto.setGender( p.getGender() );
            dto.setFirstName( p.getFirstName() );
            dto.setLastName( p.getLastName() );
            dto.setBirthday( p.getBirthday() );
            dto.setStreetName( p.getStreetName() );
            dto.setHouseNumber( p.getHouseNumber() );
            dto.setPostalcode( p.getPostalcode() );
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
            dto.setBirthday( p.getBirthday() );
            dto.setStreetName( p.getStreetName() );
            dto.setHouseNumber( p.getHouseNumber() );
            dto.setPostalcode( p.getPostalcode() );
            dto.setCity( p.getCity() );
            dto.setCountry( p.getCountry() );
            dto.setEmail( p.getEmail() );
            dto.setPhone( p.getPhone() );
            return dto;
        } else {
            throw new RecordNotFoundException( "Person not found" );
        }
    }

    @Override
    public Person addPerson( PersonDto personDto ) {
        Person p = new Person();
        p.setId( personDto.getId() );
        p.setGender( personDto.getGender() );
        p.setFirstName( personDto.getFirstName() );
        p.setLastName( personDto.getLastName() );
        p.setBirthday( personDto.getBirthday() );
        p.setStreetName( personDto.getStreetName() );
        p.setHouseNumber( personDto.getHouseNumber() );
        p.setPostalcode( personDto.getPostalcode() );
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
            p.setBirthday( p.getBirthday() );
            p.setStreetName( p.getStreetName() );
            p.setHouseNumber( p.getHouseNumber() );
            p.setPostalcode( p.getPostalcode() );
            p.setCity( p.getCity() );
            p.setCountry( p.getCountry() );
            p.setEmail( p.getEmail() );
            p.setPhone( p.getPhone() );
            personRepository.save( p );
        } else {

            throw new RecordNotFoundException( "Person not found" );
        }
        return null;
    }
}
