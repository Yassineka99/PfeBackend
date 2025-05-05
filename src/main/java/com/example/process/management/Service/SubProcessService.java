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
        {  System.out.println("sub process id : "+sub.getId()+"sub process name :"+sub.getName()+"sub process status "+sub.getStatus());
             if(sub.getAssigned_to()!=null)
            currentSub.setAssigned_to(sub.getAssigned_to());
            if(sub.getName()!=null)
            currentSub.setName(sub.getName());
            if(sub.getMessage()!=null)
            currentSub.setMessage(sub.getMessage());
            if(sub.getProcess_id()!=null)
            currentSub.setProcess_id(sub.getProcess_id());
            if(sub.getStatus()!=null)
            currentSub.setStatus(sub.getStatus());
            return subProcessRepository.save(currentSub);
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
    public List<SubProcess> GetAll()
    {
        return subProcessRepository.findAll();
    }
    public List<SubProcess> getallbyuserid(Long id)
    {
        return subProcessRepository.findAlluserID(id);
    }
    public List<SubProcess> getbyuserandprocessid(Long user,Long process)
    {
        return subProcessRepository.findAllByProcessIdAndUserId(process,user);
    }

    public List<SubProcess> findAllByStatusAndAssignedTo(Long status,Long userid)
    {
        return subProcessRepository.findAllByStatusAndAssignedTo(status,userid);
    }

    
}
