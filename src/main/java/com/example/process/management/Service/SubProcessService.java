package com.example.process.management.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.process.management.Model.SubProcess;
import com.example.process.management.Repository.SubProcessRepository;

@Service
public class SubProcessService {
    @Autowired
    SubProcessRepository subProcessRepository ;

    public SubProcess Saveprocess(SubProcess sub)
    {
        sub.setCreated_at(new Date());
        sub.setStatus(1L);
        return subProcessRepository.save(sub);
        
    }

    public SubProcess UpdateSubProcess(SubProcess sub)
    {
        SubProcess currentSub = subProcessRepository.findById(sub.getId()).orElse(null);
        if ( currentSub != null )
        {
            currentSub.setAssigned_to(sub.getAssigned_to());
            currentSub.setName(sub.getName());
            currentSub.setMessage(sub.getMessage());
            currentSub.setProcess_id(sub.getProcess_id());
            return currentSub;
        }
        return null ;

    }
    public void DeleteSubProcess (Long id )
    {
        SubProcess sub = subProcessRepository.findById(id).orElse(null);
        if(sub != null)
        {
            subProcessRepository.delete(sub);
        }
    }
    public Optional<SubProcess> GetProcessById(Long id)
    {
        return subProcessRepository.findById(id);
        
    }
    public List<SubProcess> GetAllByProcessID(Long id)
    {
        return subProcessRepository.findAllByProcessID(id);
    }

    
}
