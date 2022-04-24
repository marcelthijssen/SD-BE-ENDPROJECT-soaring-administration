package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.AUser;
//import com.example.sdbesoaringadministration.models.AUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface AUserRepository extends JpaRepository<AUser, Integer> {

    AUser findByUsername( String username);

}