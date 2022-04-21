package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Person;
import com.example.sdbesoaringadministration.repositories.PersonRepository;
import com.example.sdbesoaringadministration.repositories.MembershipRepository;
import com.example.sdbesoaringadministration.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private MembershipRepository tomRepository;
private RoleRepository roleRepository;
    public PersonServiceImpl( PersonRepository personRepository, MembershipRepository tomRepository, RoleRepository roleRepository ) {
        this.personRepository = personRepository;
        this.tomRepository = tomRepository;
        this.roleRepository=roleRepository;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> personsList = personRepository.findAll();
        List<PersonDto> dtoList = new ArrayList<>();

        for ( Person p : personsList ) {
            dtoList.add(personToPersonDto( p ));
        }
        return dtoList;
    }

    @Override
    public PersonDto getPersonById( Long pid ) {
        Optional<Person> person = personRepository.findById( pid );
        if ( person.isPresent() ) {
            PersonDto dto = personToPersonDto( person.get() );
            return dto;

        } else {
            throw new RecordNotFoundException( "Person not found" );
        }
    }

    @Override
    public PersonDto addPerson( PersonDto personDto ) {
        personRepository.save( personDtoToPerson( personDto ) );
    return personDto;
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
            p.setUsername( dto.getUsername() );
            p.setPassword( dto.getPassword() );
            p.setRoles( dto.getRoles() );
            p.setMembership( dto.getMembership() );
            p.setPilotLicense( dto.getPilotLicense() );
            personRepository.save( p );
        } else {

            throw new RecordNotFoundException( "Person not found" );
        }
        return null;
    }

    @Override
    public void addMembershipToPerson( Long pid, Long mbid ) {

            var optionalMembership = tomRepository.findById( mbid );
            var optionalPerson = personRepository.findById( pid );

            if ( optionalMembership.isPresent() && optionalPerson.isPresent() ) {
                var m = optionalMembership.get();
                var p = optionalPerson.get();

                p.setMembership( m );
                personRepository.save( p );
            } else {
                throw new RecordNotFoundException( "Person or membership bestaat niet" );
            }
        }


    @Override
    public void assignRoleToPerson( Long pid, Long rid ) {

        var optionalRole = roleRepository.findById( rid );
        var optionalPerson = personRepository.findById( pid );

        if ( optionalRole.isPresent() && optionalPerson.isPresent() ) {
            var role = optionalRole.get();
            var person = optionalPerson.get();

            person.getRoles().add( role );
            personRepository.save( person );
        } else {
            throw new RecordNotFoundException( "Person or role bestaat niet" );
        }
    }



    public static PersonDto personToPersonDto( Person p ) {
        PersonDto dto = new PersonDto();

        dto.setId( p.getId() );
        dto.setGender( p.getGender() );
        dto.setFirstName( p.getFirstName() );
        dto.setLastName( p.getLastName() );
        dto.setDateOfBirth( p.getDateOfBirth() );
        dto.setStreetName( p.getStreetName() );
        dto.setHouseNumber( p.getHouseNumber() );
        dto.setPostalcode( p.getPostalcode() );
        dto.setCity( p.getCity() );
        dto.setCountry( p.getCountry() );
        dto.setEmail( p.getEmail() );
        dto.setPhone( p.getPhone() );

        dto.setPilotLicense( p.getPilotLicense() );
        dto.setMembership( p.getMembership() );
//        dto.setUsername( p.getUsername() );
//        dto.setPhone( p.getPassword() );
        dto.setRoles( p.getRoles() );
        return dto;
    }


    public static Person personDtoToPerson( PersonDto dto ) {

        Person p = new Person();
        p.setId( dto.getId() );
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
        p.setUsername( dto.getUsername() );
        p.setPhone( dto.getPassword() );
        p.setRoles( dto.getRoles() );
        p.setPilotLicense( dto.getPilotLicense() );
        p.setMembership( dto.getMembership() );
        return p;
    }

}
