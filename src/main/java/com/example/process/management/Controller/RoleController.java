package com.example.process.management.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.process.management.Model.Role;
import com.example.process.management.Service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    RoleService roleService ;
    @GetMapping("/byid/{id}")
    public Optional<Role> getMethodName(@PathVariable Long id) {
        return roleService.getRoleByID(id);
    }
    
}
