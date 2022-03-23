package com.example.sdbesoaringadministration.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "members")
public class Member extends Person {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String membership;

    private String pilotLicense;

    private String ownerOfPlane;

}
