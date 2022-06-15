/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Extends JpaRepository and communicates with database column 'starting_methodes'
 *
 */

package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.StartingMethode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StartingMethodeRepository extends JpaRepository<StartingMethode, Long> {
}
