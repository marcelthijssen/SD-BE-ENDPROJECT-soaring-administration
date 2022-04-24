package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.AUser;
//import com.example.sdbesoaringadministration.models.AUser;
import com.example.sdbesoaringadministration.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface AUserRepository extends JpaRepository<AUser, Long> {

    AUser findByUsername( String username);

//    Optional<Role> findById( Long uid );
}