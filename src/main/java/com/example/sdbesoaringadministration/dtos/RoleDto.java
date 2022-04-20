package com.example.sdbesoaringadministration.dtos;


import com.example.sdbesoaringadministration.models.Role;

public class RoleDto {

    private Long id;
    private String name;

    public RoleDto() {

    }
    public RoleDto( Long id, String name ) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
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
