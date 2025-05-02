package com.example.process.management.Mapper;

import com.example.process.management.Dto.RoleDto;
import com.example.process.management.Model.Role;

public class RoleMapper {
    public RoleDto TODO(Role role)
    {
        if(role == null)
        {
            return null ;
        }
        else {
            RoleDto dto = new RoleDto() ;
            dto .setId(role.getId());
            dto.setName(role.getName());
            return dto ;
        }

    }
    public Role ToEntity(RoleDto dto)
    {
        if(dto == null )
        {
            return null ;
        }
        else {
            Role role = new Role();
            role.setId(dto.getId());
            role.setName(dto.getName());
            return role ;
        }
    }
}
