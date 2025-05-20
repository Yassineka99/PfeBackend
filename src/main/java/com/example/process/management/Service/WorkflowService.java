package com.example.process.management.Service;

import java.util.List;
import java.util.Optional;
import com.example.process.management.Model.Process;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.process.management.Model.SubProcess;
import com.example.process.management.Model.Workflow;
import com.example.process.management.Repository.ProcessRepository;
import com.example.process.management.Repository.WorkflowRepository;

@Service
public class WorkflowService {
      @Autowired
      WorkflowRepository workflowrepo ;
      @Autowired
      ProcessRepository processRepository ;
      public Optional<Workflow> getWorkflowByID (Long id )
      {
        return workflowrepo.findById(id) ;
      }
      public Workflow SaveWorkflow( Workflow workflow)
      {
        return workflowrepo.save(workflow);
      }
      public Workflow getWorkflowByName (String workflow)
      {
        return workflowrepo.findWorkflowByName(workflow);
      }
      public List<Workflow> findall() {
        List<Workflow> workflows = workflowrepo.findAll();

        for (Workflow wf : workflows) {
            List<Process> processes = processRepository.findAllByWorkflowID(wf.getId());

            if (!processes.isEmpty()) {
                long countStatus3 = processes.stream()
                        .filter(p -> p.getStatus_id() != null && p.getStatus_id() == 3)
                        .count();

                if (countStatus3 == processes.size()) {
                    // All processes completed
                    wf.setStatus_id(3);
                } else if (countStatus3 > 0) {
                    // Some processes completed
                    wf.setStatus_id(2);
                } else {
                    // None completed or all status != 3, leave it as is (or set to default like 1)
                    // wf.setStatus_id(1);
                }

                workflowrepo.save(wf);
            }
        }

        return workflows;
    }
      public Workflow update(Workflow workflow)
      {

          Workflow wf = workflowrepo.findById(workflow.getId()).orElse(null);
          if(workflow != null)
          {
            wf.setId(workflow.getId());
            wf.setName(workflow.getName());
            wf.setCreated_by(workflow.getCreated_by());
            workflowrepo.save(wf);

          }
          return null ;
      }
    public void DeleteWorkflow (Long id )
    {
        Workflow sub = workflowrepo.findById(id).orElse(null);
        if(sub != null)
        {
          workflowrepo.delete(sub);
        }
    }
}
