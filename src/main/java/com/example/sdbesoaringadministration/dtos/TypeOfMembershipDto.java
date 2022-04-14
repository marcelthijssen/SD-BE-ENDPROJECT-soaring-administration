package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.TypeOfMembership;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Validated
public class TypeOfMembershipDto {

    private Long id;

    @NotBlank(message = "Must have a title")
    private String title;

    @Column(precision = 10, scale = 2)
    @Digits(integer = 4, fraction = 2)
    private BigDecimal costsPerMonth;

    //    Constructors
    public TypeOfMembershipDto() {
    }

    public TypeOfMembershipDto( Long id, String title, BigDecimal costsPerMonth, BigDecimal max ) {
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

    public BigDecimal getCostsPerMonth() {
        return costsPerMonth;
    }

    public void setCostsPerMonth( BigDecimal costsPerMonth ) {
        this.costsPerMonth = costsPerMonth;
    }


    public static TypeOfMembership typeOfMembershipDtoToTypeOfMembership( TypeOfMembershipDto dto ) {
        TypeOfMembership tom = new TypeOfMembership();

        tom.setId( dto.getId() );
        tom.setTitle( dto.getTitle() );
        tom.setCostsPerMonth( dto.getCostsPerMonth() );

        return tom;
    }

    public static TypeOfMembershipDto typeOfMembershipToTypeOfMembershipDto( TypeOfMembership tom ) {
        TypeOfMembershipDto dto = new TypeOfMembershipDto();

        dto.setId( tom.getId() );
        dto.setTitle( tom.getTitle() );
        dto.setCostsPerMonth( tom.getCostsPerMonth() );

        return dto;
    }
}
