package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.Airport;
import com.example.sdbesoaringadministration.models.StartingMethode;

import java.math.BigDecimal;

public class StartingMethodeDto {

    private Long id;
    private String title;
    private String unit;
//    BigDecimal bd1 = new BigDecimal.valueOf(...) OF BigDecimal("...")
    private BigDecimal price;
    private BigDecimal max;

    // constructors
    public StartingMethodeDto() {
    }

    public StartingMethodeDto( Long id, String title, String unit, BigDecimal price, BigDecimal max ) {
        this.title = title;
        this.unit = unit;
        this.price = price;
    }


    //    Dto to Model
    public static StartingMethode startingMethodeDtoToStartingMethode( StartingMethodeDto dto) {
        StartingMethode startingMethode = new StartingMethode();

        startingMethode.setId( dto.getId() );
        startingMethode.setTitle( dto.getTitle());
        startingMethode.setUnit( dto.getUnit() );
        startingMethode.setPrice( dto.getPrice() );

        return startingMethode;
    }

//model to dto
    public StartingMethodeDto startingMethodeToStartingMethodeDto ( StartingMethode startingMethode ) {
        var dto = new StartingMethodeDto();

        dto.setId( startingMethode.getId() );
        dto.setTitle( startingMethode.getTitle() );
        dto.setUnit( startingMethode.getUnit() );
        dto.setPrice( startingMethode.getPrice() );
        return dto;
    }
    //getters an setters
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit( String unit ) {
        this.unit = unit;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice( BigDecimal price ) {
        this.price = price;
    }

}
