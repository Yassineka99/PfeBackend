package com.example.process.management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
