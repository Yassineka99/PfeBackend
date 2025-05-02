package com.example.process.management.Mapper;

import com.example.process.management.Dto.WorkflowDto;
import com.example.process.management.Model.Notification;
import com.example.process.management.Model.Workflow;

public class WorkflowMapper {
    
    public WorkflowDto TODO (Workflow workflow)
    {
        if(workflow !=null)
        {
            return null ;
        }
        WorkflowDto dto = new WorkflowDto() ;
        dto.setId(workflow.getId());
        dto.setCreated_by(workflow.getCreated_by());
        dto.setName(workflow.getName());
        return dto ;
    }

    public Workflow ToEntity ( WorkflowDto dto)
    {
        if(dto != null)
        {
            return null ;
        }
        Workflow workflow = new Workflow() ;
        workflow.setId(dto.getId());
        workflow.setCreated_by(dto.getCreated_by());
        workflow.setName(dto.getName());
         return workflow;
    }
}
