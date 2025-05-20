package com.example.process.management.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.process.management.Repository.ProcessRepository;
import com.example.process.management.Repository.SubProcessRepository;
import com.example.process.management.Model.Process;
import com.example.process.management.Model.SubProcess;

@Service
public class Processservice {
    @Autowired
    ProcessRepository processRepository ;
    @Autowired
    SubProcessRepository subProcessRepository;
    public Process SaveProcess(Process process)
    {   process.setCreated_at(new Date());
        return processRepository.save(process);
    }
    public Process UpdateProcess(Process process)
    {
        Process pro = processRepository.findById(process.getId()).orElse(null);
        if (pro != null)
        {   if(process.getName() !=null)
            pro.setName(process.getName());
            if(process.getWorkflow_id() !=null)
            pro.setWorkflow_id(process.getWorkflow_id());
            if(process.getStatus_id() !=null)
            pro.setStatus_id(process.getStatus_id());
            if(process.getOrder() != 0  )
            pro.setOrder(process.getOrder());
            if(process.getCreated_by() !=null)
            pro.setCreated_by(process.getCreated_by());
            if(process.getUpdated_by() !=null)
            pro.setUpdated_by(process.getUpdated_by());
            if(process.getUpdated_at() !=null)
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
    public List<Process> getProcessByuserId(Long id)
    {
       return processRepository.findAllByuserID(id);
    }
    public List<Process> getProcessByWorkflowId(Long workflowId) {
        List<Process> processes = processRepository.findAllByWorkflowID(workflowId);

        for (Process process : processes) {
            List<SubProcess> subProcesses = subProcessRepository.findAllByProcessID(process.getId());

            if (!subProcesses.isEmpty() &&
                subProcesses.stream().allMatch(sp -> sp.getStatus() != null && sp.getStatus() == 3)) {

                // Update the process status if not already 3
                if (process.getStatus_id() == null || process.getStatus_id() != 3) {
                    process.setStatus_id(3L);
                    process.setUpdated_at(new Date());
                    processRepository.save(process);
                }
            }
        }

        return processes;
    }
    public List<Process> getProcessBystatusId(Long id)
    {
       return processRepository.findAllByStatusID(id);
    }
}
