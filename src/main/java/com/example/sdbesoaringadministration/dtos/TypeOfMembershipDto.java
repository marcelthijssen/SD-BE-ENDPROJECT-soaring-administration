package com.example.sdbesoaringadministration.dtos;

public class TypeOfMembershipDto {
    private Long id;

    public TypeOfMembershipDto() {
    }

    public TypeOfMembershipDto(Long id, String typeOfMembership, int price ) {
        this.id = id;
        this.typeOfMembership = typeOfMembership;
        this.price = price;
    }
    private String typeOfMembership;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

}
