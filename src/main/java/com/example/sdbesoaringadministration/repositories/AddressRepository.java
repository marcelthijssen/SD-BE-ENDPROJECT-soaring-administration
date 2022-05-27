package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

//    List<Address> getAddressByPerson_id( Long personId );
}
