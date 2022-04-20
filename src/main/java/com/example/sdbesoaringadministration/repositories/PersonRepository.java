package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

//    List<Person> findAllByMembership();
}
