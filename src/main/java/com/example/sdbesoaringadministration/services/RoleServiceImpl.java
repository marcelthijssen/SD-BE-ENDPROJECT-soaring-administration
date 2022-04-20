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
        List<Role> roleList = this.roleRepository.findAll();
        List<RoleDto> roleDtoList = new ArrayList<>();

        for ( Role role : roleList ) {
            RoleDto dto = new RoleDto().roleToRoleDto( role );
            roleDtoList.add( dto );
        }
        return roleDtoList;
    }
}
