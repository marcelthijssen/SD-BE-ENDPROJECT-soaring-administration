package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Person;
import com.example.sdbesoaringadministration.repositories.PersonRepository;
import com.example.sdbesoaringadministration.repositories.MembershipRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
//    private MembershipRepository tomRepository;

    public PersonServiceImpl( PersonRepository personRepository ) {
        this.personRepository = personRepository;
//        this.tomRepository = tomRepository;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> personsList = this.personRepository.findAll();
        List<PersonDto> personsDtoList = new ArrayList<>();

        for ( Person p : personsList ) {
            PersonDto dto = PersonDto.personToPersonDto( p );
            personsDtoList.add( dto );
        }
        return personsDtoList;
    }

    @Override
    public PersonDto getPersonById( Long pid ) {

        if ( personRepository.findById( pid ).isPresent() ) {
            Person p = personRepository.findById( pid ).get();
            PersonDto dto = PersonDto.personToPersonDto( p );
            return dto;

        } else {
            throw new RecordNotFoundException( "Person not found" );
        }
    }

    @Override
    public Person addPerson( PersonDto personDto ) {
        Person p = PersonDto.personDtoToPerson( personDto );

        return this.personRepository.save( p );
    }

    @Override
    public void deletePersonById( Long pid ) {
        if ( personRepository.findById( pid ).isPresent() ) {
            personRepository.deleteById( pid );
        } else {
            throw new RecordNotFoundException( "Person not found" );
        }
    }

    @Override
    public PersonDto updatePerson( Long pid, PersonDto dto ) {
        if ( personRepository.findById( pid ).isPresent() ) {
            Person p = personRepository.findById( pid ).get();

//            p.getId( dto.getId() );
            p.setGender( dto.getGender() );
            p.setFirstName( dto.getFirstName() );
            p.setLastName( dto.getLastName() );
            p.setDateOfBirth( dto.getDateOfBirth() );
            p.setStreetName( dto.getStreetName() );
            p.setHouseNumber( dto.getHouseNumber() );
            p.setPostalcode( dto.getPostalcode() );
            p.setCity( dto.getCity() );
            p.setCountry( dto.getCountry() );
            p.setEmail( dto.getEmail() );
            p.setPhone( dto.getPhone() );
            p.setUserName( dto.getUserName() );
            p.setPassword( dto.getPassword() );
            p.setRole( dto.getRole() );
            p.setMembership( dto.getMembership() );
            p.setPilotLicense( dto.getPilotLicense() );
            personRepository.save( p );
        } else {

            throw new RecordNotFoundException( "Person not found" );
        }
        return null;
    }

//    @Override
//    public PersonDto addTypeOfMembershipToPerson( Long pid, Long tomid ) {
//
//            var optionalTypeOfMembership = tomRepository.findById( tomid );
//            var optionalPerson = personRepository.findById( pid );
//
//            if ( optionalTypeOfMembership.isPresent() && optionalPerson.isPresent() ) {
//                var tom = optionalTypeOfMembership.get();
//                var person = optionalPerson.get();
//
//                person.getEmail().add( tom );
//                personRepository.save( person );
//            } else {
//                throw new RecordNotFoundException( "tv of wb bestaat niet" );
//            }
//        }
}
