package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.RoleDto;
import com.example.sdbesoaringadministration.models.Role;
import com.example.sdbesoaringadministration.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl( RoleRepository roleRepository ) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        List<RoleDto> dtoList = new ArrayList<>();

        for ( Role role : roleList ) {
            dtoList.add( roleToRoleDto(role) );
        }
        return dtoList;
    }


    public static Role roleDtoToRole( RoleDto dto ) {
        Role role = new Role();

        role.setId( dto.getId() );
        role.setName( dto.getName() );
        return role;
    }

    public static RoleDto roleToRoleDto( Role role ) {
        RoleDto dto = new RoleDto();

        dto.setId( role.getId() );
        dto.setName( role.getName() );
        return dto;
    }
}
