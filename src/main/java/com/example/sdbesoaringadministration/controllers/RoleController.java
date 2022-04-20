package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.RoleDto;
import com.example.sdbesoaringadministration.services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
