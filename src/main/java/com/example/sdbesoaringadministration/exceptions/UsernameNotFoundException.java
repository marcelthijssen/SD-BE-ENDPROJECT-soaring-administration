/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Handles UsernameNotFoundException
 *
 */

package com.example.sdbesoaringadministration.exceptions;

import org.springframework.http.HttpStatus;

public class UsernameNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsernameNotFoundException( HttpStatus notFound, String username) {
        super("Cannot find user " + username);
    }

}