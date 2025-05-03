package com.example.process.management.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.process.management.Model.SubProcess;
import com.example.process.management.Model.User;
import com.example.process.management.Model.Workflow;
import com.example.process.management.Service.WorkflowService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/workflow")
public class WorkflowController {
    @Autowired
    WorkflowService workflowService ;

    @PostMapping("/create")
    public ResponseEntity<Workflow> createWorkflow(@RequestBody Workflow entity) {
        //TODO: process POST request
        Workflow workflowToSave = workflowService.SaveWorkflow(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(workflowToSave);
    }
    @GetMapping("/id/{workflowid}")
    public Optional<Workflow> getWorkflowByID(@PathVariable Long workflowid) {
        return workflowService.getWorkflowByID(workflowid);
    }
    @GetMapping("/workflow-name/{workflowname}")
    public ResponseEntity<Workflow> getWorkflowByID(@PathVariable String workflowname) {
        Workflow workflow = workflowService.getWorkflowByName(workflowname) ;
        if (workflow != null)
        {
             return ResponseEntity.status(HttpStatus.OK).body(workflow);
        }
        else 
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(workflow);
        }
        }
        @GetMapping("/get-all")
        public List<Workflow> GetAllWorkflows()
        {
        return workflowService.findall();
        }
    
        @PostMapping("/update")
        public ResponseEntity <Workflow> Updateworkflow(@RequestBody Workflow workflow){
            Workflow updatedworkflow = workflowService.update(workflow);
            return ResponseEntity.status(HttpStatus.OK).body(updatedworkflow);
        }

        @PostMapping("/delete/{id}")
        public void DeleteSubProcess(@PathVariable Long id )
        {
            workflowService.DeleteWorkflow(id);
        }
}
