package com.example.process.management.Mapper;

import com.example.process.management.Dto.ProcessDto;
import com.example.process.management.Model.Process;

public class ProcessMapper {
    public ProcessDto TODO ( Process process)
    {
        if(process == null )
        {
            return null;
        }
        else {
            ProcessDto dto = new ProcessDto();
            dto.setId(process.getId());
            dto.setName(process.getName());
            dto.setWorkflow_id(process.getWorkflow_id());
            dto.setStatus_id(process.getStatus_id());
            dto.setOrder(process.getOrder());
            dto.setCreated_by(process.getCreated_by());

            return dto ;
        }
    }
    public Process ToEntity ( ProcessDto process)
    {
        if(process == null )
        {
            return null;
        }
        else {
            Process dto = new Process();
            dto.setId(process.getId());
            dto.setName(process.getName());
            dto.setWorkflow_id(process.getWorkflow_id());
            dto.setStatus_id(process.getStatus_id());
            dto.setOrder(process.getOrder());
            dto.setCreated_by(process.getCreated_by());

            return dto ;
        }
    }
}
