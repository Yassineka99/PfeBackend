package com.example.process.management.Mapper;

import com.example.process.management.Dto.SubprocessDto;
import com.example.process.management.Model.SubProcess;

public class SubprocessMapper {
    public SubprocessDto TODO ( SubProcess sub)
    {
        if(sub == null)
        {
            return null ;
        }
        else {
            SubprocessDto dto = new SubprocessDto() ;
            dto.setId(sub.getId());
            dto.setName(sub.getName());
            dto.setCreated_by(sub.getCreated_by());
            dto.setStatus(sub.getStatus()); 
            dto.setMessage(sub.getMessage());
            dto.setAssigned_to(sub.getAssigned_to());
            dto.setCreated_at(sub.getCreated_at());  // Add created_at field
            dto.setFinished_at(sub.getFinished_at());
            return dto ;
        }
    }
    public SubProcess ToEntity ( SubProcess sub)
    {
        if(sub == null)
        {
            return null ;
        }
        else {
            SubProcess dto = new SubProcess() ;
            dto.setId(sub.getId());
            dto.setName(sub.getName());
            dto.setStatus(sub.getStatus()); 
            dto.setCreated_by(sub.getCreated_by());
            dto.setMessage(sub.getMessage());
            dto.setAssigned_to(sub.getAssigned_to());
            dto.setCreated_at(sub.getCreated_at());  // Add created_at field
            dto.setFinished_at(sub.getFinished_at());
            return dto ;
        }
    }
}
