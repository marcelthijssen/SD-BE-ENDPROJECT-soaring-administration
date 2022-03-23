package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.TypeOfMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberShipRepository extends JpaRepository<TypeOfMembership, Long> {
}
