package com.example.sdbesoaringadministration.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "planes")
public class Plane {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String callSign;

    private String brand;

    private String type;

    private String registration;

    private boolean twoSeater;

    private boolean privatePlane;
}
