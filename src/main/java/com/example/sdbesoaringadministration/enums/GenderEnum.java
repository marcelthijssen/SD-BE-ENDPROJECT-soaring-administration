package com.example.sdbesoaringadministration.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GenderEnum {

    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

private final String genderDisplayName;

    GenderEnum(  String genderDisplayName ) {
        this.genderDisplayName = genderDisplayName;
    }

    @JsonValue
    public String getGenderName() {
        return genderDisplayName;
    }
}
