package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.dtos.RoleDto;
import com.example.sdbesoaringadministration.services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController( RoleService roleService ) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<Object> getAllRoles() {
        List<RoleDto> roleDtoList = roleService.getAllRoles();

        return new ResponseEntity<>( roleDtoList, HttpStatus.OK );
    }

    @PostMapping("/roles")
    public ResponseEntity<Object> addNewRole( @Valid @RequestBody RoleDto roleDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            roleService.addNewRole( roleDto );
            return new ResponseEntity<>( "New Role added to systeem, unfortunately you can not do anything with this new role", HttpStatus.CREATED );
        }
    }

}
