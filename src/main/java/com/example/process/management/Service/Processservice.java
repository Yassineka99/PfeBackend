package com.example.process.management.Service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.process.management.Repository.ProcessRepository;
import com.example.process.management.Model.Process;

@Service
public class Processservice {
    @Autowired
    ProcessRepository processRepository ;
    
    public Process SaveProcess(Process process)
    {   process.setCreated_at(new Date());
        return processRepository.save(process);
    }
    public Process UpdateProcess(Process process)
    {
        Process pro = processRepository.findById(process.getId()).orElse(null);
        if (pro != null)
        {
            pro.setName(process.getName());
            pro.setWorkflow_id(process.getWorkflow_id());
            pro.setStatus_id(process.getStatus_id());
            pro.setOrder(process.getOrder());
            pro.setCreated_by(process.getCreated_by());
            pro.setUpdated_by(process.getUpdated_by());
            pro.setUpdated_at(process.getUpdated_at());
            return processRepository.save(pro) ;
            
        }
        return null ;
       

    }
    public void DeleteProcess (Long id)
    {
        Process process = processRepository.findById(id).orElse(null);
        if(process !=null)
        {
            processRepository.delete(process);
        }
    } 
    public Optional<Process> getProcessById(Long id)
    {
       return processRepository.findById(id);
    }
}
