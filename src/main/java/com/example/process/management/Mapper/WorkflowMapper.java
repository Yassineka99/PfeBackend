package com.example.process.management.Mapper;

import com.example.process.management.Dto.WorkflowDto;
import com.example.process.management.Model.Notification;
import com.example.process.management.Model.Workflow;

public class WorkflowMapper {
    
    public WorkflowDto TODO (Workflow workflow)
    {
        if(workflow ==null)
        {
            return null ;
        }
        WorkflowDto dto = new WorkflowDto() ;
        dto.setId(workflow.getId());
        dto.setCreated_by(workflow.getCreated_by());
        dto.setName(workflow.getName());
        dto.setProduct_id(workflow.getProduct_id());
        dto.setQty(workflow.getQty());
        dto.setStatus_id(workflow.getStatus_id());
        dto.setImage(workflow.getImage());
        dto.setImageType(workflow.getImageType());
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
        workflow.setProduct_id(dto.getProduct_id());
        workflow.setQty(dto.getQty());
        workflow.setStatus_id(dto.getStatus_id());
        workflow.setImage(dto.getImage());
        workflow.setImageType(dto.getImageType());
         return workflow;
    }
}
