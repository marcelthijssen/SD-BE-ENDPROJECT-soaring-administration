/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Creates an object of Authority
 * 
 */

package com.example.sdbesoaringadministration.models;

import com.example.sdbesoaringadministration.utils.AuthorityKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Authority")
@IdClass(AuthorityKey.class)
@Table(name = "AUTHORITIES")
public class Authority implements Serializable {

    @Id
    @Column(nullable = false)
    private String username;

    @Id
    @Column(nullable = false)
    private String authority;

    public Authority() {
    }

    public Authority( String username, String authority ) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority( String authority ) {
        this.authority = authority;
    }

}