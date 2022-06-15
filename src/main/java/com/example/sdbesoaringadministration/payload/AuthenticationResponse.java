/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Handles the AutheticationResponse
 *
 */

package com.example.sdbesoaringadministration.payload;

public class AuthenticationResponse {

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

}