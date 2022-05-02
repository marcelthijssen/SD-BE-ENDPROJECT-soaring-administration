/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Extends JpaRepository and communicates with database column 'memberschips'
 */

package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {

}
