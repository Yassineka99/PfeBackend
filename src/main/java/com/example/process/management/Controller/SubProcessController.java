package com.example.process.management.Controller;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.process.management.Model.SubProcess;
import com.example.process.management.Service.SubProcessService;

@RestController
@RequestMapping("/api/subprocess")
public class SubProcessController {
    @Autowired
    SubProcessService subProcessService ;

    @PostMapping("/create")
    public ResponseEntity<SubProcess> CreatSubProcess( @RequestBody SubProcess sub)
    {
        SubProcess subsave = subProcessService.Saveprocess(sub);
        return ResponseEntity.status(HttpStatus.CREATED).body(subsave);
    }
    @PostMapping("/update")
    public ResponseEntity<SubProcess> UpdateSubProcess(@RequestBody SubProcess sub)
    {
        SubProcess subupdate = subProcessService.UpdateSubProcess(sub);
        return ResponseEntity.status(HttpStatus.OK).body(subupdate);
    }
    @PostMapping("/delete/{id}")
    public void DeleteSubProcess(@PathVariable Long id )
    {
        subProcessService.DeleteSubProcess(id);
    }
    @GetMapping("/get-by-id/{id}")
    public Optional<SubProcess> GetSubProcessById (@PathVariable Long id)
    {
        return subProcessService.GetProcessById(id);
    }
    @GetMapping("/get-all-by-process-id/{id}")
    public List<SubProcess> GetAllByProcessID(@PathVariable Long id )
    {
        return subProcessService.GetAllByProcessID(id);
    }
    @GetMapping("/get-all")
    public List<SubProcess> GetAllSubProcess( )
    {
        return subProcessService.GetAll();
    }
    @GetMapping("/get-all-by-user-id/{id}")
    public List<SubProcess> GetAllbyuserid( @PathVariable Long id)
    {
        return subProcessService.getallbyuserid(id);
    }
    @GetMapping("/get-all-by-user-process-id/{user}/{process}")
    public List<SubProcess> GetAllbyuserid( @PathVariable Long process ,@PathVariable Long user )
    {
        return subProcessService.getbyuserandprocessid(user,process);
    }

    @GetMapping("/get-all-by-status-and-user-id/{status}/{userid}")
    public List<SubProcess> findAllByStatusAndAssignedTo( @PathVariable Long status ,@PathVariable Long userid )
    {
        return subProcessService.findAllByStatusAndAssignedTo(status,userid);
    }

}
