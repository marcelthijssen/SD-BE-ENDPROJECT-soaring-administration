package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.TypeOfMembership;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

public interface TypeOfMembershipRepository extends JpaRepository<TypeOfMembership, Long> {

}
