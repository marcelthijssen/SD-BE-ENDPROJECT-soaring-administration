package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.dtos.RoleDto;

import java.util.List;

public interface RoleService {

    List<RoleDto> getAllRoles();

    RoleDto addNewRole( RoleDto roleDto );

    void assignRoleToAUser(Long rid, Long uid);

}
