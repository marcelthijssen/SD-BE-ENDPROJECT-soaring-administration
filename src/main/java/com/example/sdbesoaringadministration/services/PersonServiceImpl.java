/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Implements methodes for PersonController
 *
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Address;
import com.example.sdbesoaringadministration.models.Person;
import com.example.sdbesoaringadministration.repositories.AddressRepository;
import com.example.sdbesoaringadministration.repositories.MembershipRepository;
import com.example.sdbesoaringadministration.repositories.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final MembershipRepository membershipRepository;
    private final AddressRepository addressRepository;

    public PersonServiceImpl( PersonRepository personRepository, MembershipRepository membershipRepository, AddressRepository addressRepository ) {
        this.personRepository = personRepository;
        this.membershipRepository = membershipRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> personsList = personRepository.findAll();
        List<PersonDto> dtoList = new ArrayList<>();

        for ( Person p : personsList ) {
            dtoList.add( personToPersonDto( p ) );
        }
        return dtoList;
    }

    @Override
    public PersonDto getPersonById( Long person_id ) {
        Optional<Person> person = personRepository.findById( person_id );
        if ( person.isPresent() ) {
            return personToPersonDto( person.get() );

        } else {
            throw new RecordNotFoundException( "Person not found", HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public PersonDto createPerson( PersonDto personDto ) {
            Person p = personDtoToPerson( personDto );
            personRepository.save( p );

            Address addr = new Address();
            addr.setId( p.getId());
            addressRepository.save(addr);

            return personDto;
    }

    @Override
    public void deletePersonById( Long person_id ) {

        if ( personRepository.findById( person_id ).isPresent() ) {
            personRepository.deleteById( person_id );
        } else {
            throw new RecordNotFoundException( "Person not found", HttpStatus.NOT_FOUND );
//        } else {
//            thrown new BadRequestException( "unable to delete, item is used in other table" )
        }
    }

    @Override
    public PersonDto updatePerson( Long person_id, PersonDto dto ) {
        if ( personRepository.findById( person_id ).isPresent() ) {
            Person p = personRepository.findById( person_id ).get();

            p.setId( p.getId() );
            p.setGender( dto.getGender() );
            p.setFirstName( dto.getFirstName() );
            p.setLastName( dto.getLastName() );
            p.setDateOfBirth( dto.getDateOfBirth() );
            p.setEmail( dto.getEmail() );
            p.setPhone( dto.getPhone() );
//            p.setMembership( dto.getMembership() );
            p.setPilotLicense( dto.getPilotLicense() );
            personRepository.save( p );
        } else {

            throw new RecordNotFoundException( "Person not found", HttpStatus.NOT_FOUND );
        }
        return null;
    }

    @Override
    public void addMembershipToPerson( Long person_id, Long membership_id ) {

        var optionalMembership = membershipRepository.findById( membership_id );
        var optionalPerson = personRepository.findById( person_id );

        if ( optionalMembership.isPresent() && optionalPerson.isPresent() ) {
            var m = optionalMembership.get();
            var p = optionalPerson.get();

//            p.setMembership( m );
            personRepository.save( p );
        } else {
            throw new RecordNotFoundException( "Person or membership bestaat niet", HttpStatus.NOT_FOUND );
        }
    }


//    @Override
//    public void addAddressToPerson( Long person_id, Long addressId ) {
//
//        var optionalAddress = membershipRepository.findById( addressId );
//        var optionalPerson = personRepository.findById( person_id );
//
//        if ( optionalAddress.isPresent() && optionalPerson.isPresent() ) {
//            var m = optionalAddress.get();
//            var p = optionalPerson.get();
//
//            p.setMembership( m );
//            personRepository.save( p );
//        } else {
//            throw new RecordNotFoundException( "Person or membership bestaat niet", HttpStatus.NOT_FOUND );
//        }
//    }


//    @Override
//    public void addAddressToPerson( Long person_id ) {
// check if person_id has an address assigned. 
//        List<Address> address = addressRepository.findAddressByPerson_id( person_id );
//
//        if ( address.isEmpty() ) {
//
//            var optionalAddress = addressRepository.findAddressByPerson_id( person_id );
//            var optionalPerson = personRepository.findById( person_id );
//
//            if ( optionalAddress.isPresent() && optionalPerson.isPresent() ) {
//                var a = optionalAddress.get();
//                var p = optionalPerson.get();
//
//                p.setAddress( a );
//                personRepository.save( p );
//            } else {
//                throw new RecordNotFoundException( "Person or address does not exist", HttpStatus.NOT_FOUND );
//            }
//        }
//    }

    public static PersonDto personToPersonDto( Person p ) {
        PersonDto dto = new PersonDto();

        dto.setId( p.getId() );
        dto.setGender( p.getGender() );
        dto.setFirstName( p.getFirstName() );
        dto.setLastName( p.getLastName() );
        dto.setDateOfBirth( p.getDateOfBirth() );
        dto.setAddress( p.getAddress() );
        dto.setEmail( p.getEmail() );
        dto.setPhone( p.getPhone() );
        dto.setPilotLicense( p.getPilotLicense() );
//        dto.setMembership( p.getMembership() );
        return dto;
    }


    public static Person personDtoToPerson( PersonDto dto ) {

        Person p = new Person();
        p.setId( dto.getId() );
        p.setGender( dto.getGender() );
        p.setFirstName( dto.getFirstName() );
        p.setLastName( dto.getLastName() );
        p.setDateOfBirth( dto.getDateOfBirth() );
        p.setAddress( dto.getAddress() );
        p.setEmail( dto.getEmail() );
        p.setPhone( dto.getPhone() );
        p.setPilotLicense( dto.getPilotLicense() );
//        p.setMembership( dto.getMembership() );
        return p;
    }
}

