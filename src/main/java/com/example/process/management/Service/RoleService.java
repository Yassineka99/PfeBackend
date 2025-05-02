package com.example.process.management.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.process.management.Model.Role;
import com.example.process.management.Repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository ;

    public Optional<Role> getRoleByID( Long id )
    {
        return roleRepository.findById(id);
    }
    
}
