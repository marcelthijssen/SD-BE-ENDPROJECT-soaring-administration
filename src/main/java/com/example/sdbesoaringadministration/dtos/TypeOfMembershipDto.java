package com.example.sdbesoaringadministration.dtos;

public class TypeOfMembershipDto {
    private Long id;

    public TypeOfMembershipDto() {
    }

    public TypeOfMembershipDto(Long id, String title, int price ) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
    private String title;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String typeOfMembership ) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice( int price ) {
        this.price = price;
    }
}
