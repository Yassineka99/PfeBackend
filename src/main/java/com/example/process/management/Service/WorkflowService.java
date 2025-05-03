package com.example.process.management.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.process.management.Model.SubProcess;
import com.example.process.management.Model.Workflow;
import com.example.process.management.Repository.WorkflowRepository;

@Service
public class WorkflowService {
      @Autowired
      WorkflowRepository workflowrepo ;
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
      public List<Workflow> findall ()
      {
        return workflowrepo.findAll();
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
