package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.AddressDto;
import com.example.sdbesoaringadministration.dtos.AirportDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Address;
import com.example.sdbesoaringadministration.services.AddressService;
import com.example.sdbesoaringadministration.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;
    private final PersonService personService;

    public AddressController( AddressService addressService, PersonService personService ) {
        this.addressService = addressService;
        this.personService = personService;
    }

    
    @GetMapping("")
    public ResponseEntity<Object>getAllAddresses() {
        List<AddressDto> listAddressesDto = addressService.getAllAddresses();

        return new ResponseEntity<>( listAddressesDto, HttpStatus.OK);
    }

//    @GetMapping("/{person_id}")
//    public ResponseEntity<Object> getAddressByPerson_id( @PathVariable(name = "addressId") Long person_id ) {
//        try {
//            AddressDto addressDto = addressService.getAddressByPerson_id( person_id );
//            return ResponseEntity.ok( addressDto );
//        } catch ( RecordNotFoundException e ) {
//            throw new RecordNotFoundException( "Invalid address-id: " + person_id, HttpStatus.NOT_FOUND );
//        }
//    }

//    @PostMapping("")
//    public ResponseEntity<Object> createAddress( @Valid @RequestBody AddressDto addressDto, BindingResult br ) {
//        if ( br.hasErrors() ) {
//            StringBuilder sb = new StringBuilder();
//            for ( FieldError fe : br.getFieldErrors() ) {
//                sb.append( fe.getDefaultMessage() );
//                sb.append( "\n" );
//            }
//            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
//        } else {
//            addressService.createAddress( addressDto );
////            Create addressRepo for this person
////            addressService.createAddres()
//            return new ResponseEntity<>( "Person added to systeem", HttpStatus.CREATED );
//        }
//    }
//
//    @PutMapping("/{addressId}")
//    public ResponseEntity<Void> updateAddress(@PathVariable Long id, @RequestBody @Valid Address address) {
//        address.setId(id);
//        addressService.updateAddress(address);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/{addressId}")
//    public ResponseEntity<Object> deleteAddressById(@PathVariable Long addressId) {
//        addressService.deleteAddressById(addressId);
//        return ResponseEntity.ok().build();
//    }
}
