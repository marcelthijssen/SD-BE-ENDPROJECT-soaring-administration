package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
