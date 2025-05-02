package com.example.process.management.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.process.management.Model.Role;
import com.example.process.management.Model.Status;
import com.example.process.management.Service.StatusService;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    @Autowired
    StatusService statusService ;
        @GetMapping("/byid/{id}")
    public Optional<Status> getMethodName(@PathVariable Long id) {
        return statusService.getStatusByID(id) ;
    }
    
}
