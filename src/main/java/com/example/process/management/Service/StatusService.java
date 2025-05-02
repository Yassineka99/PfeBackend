package com.example.process.management.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.process.management.Model.Role;
import com.example.process.management.Model.Status;
import com.example.process.management.Repository.StatusRepository;

@Service
public class StatusService {
    @Autowired
    StatusRepository statusRepository;

        public Optional<Status> getStatusByID( Long id )
    {
        return statusRepository.findById(id);
    }
}
