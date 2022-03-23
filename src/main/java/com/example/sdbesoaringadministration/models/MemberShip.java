package com.example.sdbesoaringadministration.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "memberships")
public class MemberShip {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String typeOfMembership;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }


}
