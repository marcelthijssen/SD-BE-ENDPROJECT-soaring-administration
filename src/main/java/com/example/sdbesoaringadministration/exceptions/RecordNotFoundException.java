package com.example.sdbesoaringadministration.exceptions;

import org.springframework.http.HttpStatus;

public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

//    public RecordNotFoundException() {
//
//        super();
//
//    }

    public RecordNotFoundException( String message, HttpStatus notFound ) {

        super( message );

    }

}
