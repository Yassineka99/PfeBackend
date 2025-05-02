package com.example.process.management.Mapper;

import com.example.process.management.Dto.StatusDto;
import com.example.process.management.Model.Status;

public class StatusMapper {
    public StatusDto TODO (Status status)
    {
        if (status ==null)
        {
            return null ;
        }
        else {
            StatusDto dto = new StatusDto();
            dto.setId(status.getId());
            dto.setName(status.getName());
            return dto ;

        }
    }
    public Status ToEntity (StatusDto dto )
    {
        if(dto == null)
        {
            return null ;
        }
        else {
            Status status = new Status();
            status.setId(dto.getId());
            status.setName(dto.getName());
            return status ;
        }
    }
}
