package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.AddressDto;
import com.example.sdbesoaringadministration.dtos.AirportDto;
import com.example.sdbesoaringadministration.models.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<AddressDto> getAllAddresses();

//    void addAddressToPerson( Long person_id, AddressDto addressDto );

    //     AddressDto getAddressByPerson_id( Long person_id );
//    void updateAddress( Address address );
//
//    void deleteAddressById( Long addressId );

}
