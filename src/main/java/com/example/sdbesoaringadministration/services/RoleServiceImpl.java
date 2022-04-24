package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.RoleDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Role;
import com.example.sdbesoaringadministration.repositories.AUserRepository;
import com.example.sdbesoaringadministration.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final AUserRepository aUserRepository;

    public RoleServiceImpl( RoleRepository roleRepository, AUserRepository aUserRepository ) {
        this.roleRepository = roleRepository;
        this.aUserRepository = aUserRepository;
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        List<RoleDto> dtoList = new ArrayList<>();

        for ( Role role : roleList ) {
            dtoList.add( roleToRoleDto( role ) );
        }
        return dtoList;
    }

    @Override
    public RoleDto addNewRole( RoleDto roleDto ) {
        roleRepository.save( roleDtoToRole( roleDto ) );
        return roleDto;
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


    @Override
    public void assignRoleToAUser( Long rid, Long uid ) {

        var optionalRole = roleRepository.findById( rid );
        var optionalAUser = aUserRepository.findById( uid  );

        if ( optionalRole.isPresent() && optionalAUser.isPresent() ) {
            var role = optionalRole.get();
            var aUser = optionalAUser.get();

            aUser.getRoles().add( role );
            aUserRepository.save( aUser );
        } else {
            throw new RecordNotFoundException( "Person or role bestaat niet" );
        }
    }

}
