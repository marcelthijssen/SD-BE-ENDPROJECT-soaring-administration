/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Extends JpaRepository and communicates with database column 'users'
 *
 */

package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.User;
//import com.example.sdbesoaringadministration.models.AUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {

//    User findByUsername( String username);

}