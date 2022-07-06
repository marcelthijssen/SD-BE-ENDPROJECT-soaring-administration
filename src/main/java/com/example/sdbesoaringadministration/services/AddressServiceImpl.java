package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.AddressDto;
import com.example.sdbesoaringadministration.models.Address;
import com.example.sdbesoaringadministration.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {


    private final AddressRepository addressRepository;

    public AddressServiceImpl( AddressRepository addressRepository ) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressDto> getAllAddresses() {
        List<Address> addressList = this.addressRepository.findAll();
        List<AddressDto> addressDtoList = new ArrayList<>();

        for ( Address address : addressList ) {
            AddressDto dto = addressToAddressDto( address );

            addressDtoList.add( dto );
        }
        return addressDtoList;
    }

//    @Override
//    public AddressDto getAddressByPerson_id( Long person_id ) {
//        try {
//            Address address = addressRepository.getAddressByPerson_id( person_id ).get();
//            return addressToAddressDto( address );
//        } catch ( Exception e ) {
//                throw new RecordNotFoundException( "Invalid person_id: " + person_id, HttpStatus.NOT_FOUND );
//            }
//        }



        public static Address addressDtoToAddress ( AddressDto dto ){

            Address address = new Address();
//        p.setId( p.getId );
            address.setStreetName( dto.getStreetName() );
            address.setHouseNumber( dto.getHouseNumber() );
            address.setPostalcode( dto.getPostalcode() );
            address.setCity( dto.getCity() );
            address.setCountry( dto.getCountry() );
            return address;
        }

        public static AddressDto addressToAddressDto ( Address address ){
            AddressDto dto = new AddressDto();

            dto.setId( address.getId() );
            dto.setStreetName( address.getStreetName() );
            dto.setHouseNumber( address.getHouseNumber() );
            dto.setPostalcode( address.getPostalcode() );
            dto.setCity( address.getCity() );
            dto.setCountry( address.getCountry() );

            return dto;
        }

    }
