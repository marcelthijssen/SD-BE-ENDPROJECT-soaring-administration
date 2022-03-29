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
            PersonDto dto = PersonDto.modelToDto( p );
            personsDtoList.add( dto );
        }
        return personsDtoList;
    }

    @Override
    public PersonDto getPersonById( Long id ) {

        if ( personRepository.findById( id ).isPresent() ) {
            Person p = personRepository.findById( id ).get();
            PersonDto dto = PersonDto.modelToDto( p );
            return dto;

        } else {
            throw new RecordNotFoundException( "Person not found" );
        }
    }

    @Override
    public Person addPerson( PersonDto personDto ) {
        Person p = PersonDto.dtoToModel(personDto);

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

//            p.getId( dto.getId() );
            p.setGender( dto.getGender() );
            p.setFirstName( dto.getFirstName() );
            p.setLastName( dto.getLastName() );
            p.setBirthday( dto.getBirthday() );
            p.setStreetName( dto.getStreetName() );
            p.setHouseNumber( dto.getHouseNumber() );
            p.setPostalcode( dto.getPostalcode() );
            p.setCity( dto.getCity() );
            p.setCountry( dto.getCountry() );
            p.setEmail( dto.getEmail() );
            p.setPhone( dto.getPhone() );
            personRepository.save( p );
        } else {

            throw new RecordNotFoundException( "Person not found" );
        }
        return null;
    }
}
