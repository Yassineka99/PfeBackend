package com.example.process.management.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.process.management.Service.Processservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.process.management.Model.Process;
import com.example.process.management.Model.Workflow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/process")
public class ProcessController {
    @Autowired
    Processservice processService ;

    @PostMapping("/create")
    public ResponseEntity<Process> createProcess(@RequestBody Process process)
    {
        Process pro = processService.SaveProcess(process);
        return ResponseEntity.status(HttpStatus.CREATED).body(pro);
    }
    
    @PostMapping("/update")
    public ResponseEntity<Process> updateProcess(@RequestBody Process process){
        Process pro = processService.UpdateProcess(process);
        pro.setUpdated_at(new Date());
        pro.setUpdated_by(process.getCreated_by());
        return ResponseEntity.status(HttpStatus.OK).body(pro);
    }
    @PostMapping("/delete/{id}")
    public void DeleteProcess(@PathVariable Long id)
    {
        processService.DeleteProcess(id);
    }

    @GetMapping("/get-process-by-id/{id}")
    public Optional<Process> getMethodName(@PathVariable Long id) {
        return processService.getProcessById(id);
    }

    @GetMapping("/get-all-by-workflow-id/{id}")
    public List<Process> GetAllbyWorkflowid(@PathVariable Long id){
        return processService.getProcessByWorkflowId(id);
    }
    @GetMapping("/get-all-by-user-id/{id}")
    public List<Process> GetAllbyUserid(@PathVariable Long id){
        return processService.getProcessByuserId(id);
    }
    @GetMapping("/get-all-by-status-id/{id}")
    public List<Process> GetAllbyStatusid(@PathVariable Long id){
        return processService.getProcessBystatusId(id);
    }
    
}
