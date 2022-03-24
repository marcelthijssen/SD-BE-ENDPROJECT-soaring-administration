package com.example.sdbesoaringadministration.dtos;

public class TypeOfMembershipDto {

    private Long id;

    private String title;
    private int costsPerMonth;

    //    Constructors
    public TypeOfMembershipDto() {
    }

    public TypeOfMembershipDto( Long id, String title, int costsPerMonth ) {
        this.id = id;
        this.title = title;
        this.costsPerMonth = costsPerMonth;
    }


    //    GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public int getCostsPerMonth() {
        return costsPerMonth;
    }

    public void setCostsPerMonth( int costsPerMonth ) {
        this.costsPerMonth = costsPerMonth;
    }
}
