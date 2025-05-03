package com.example.process.management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.process.management.Model.Notification;
import com.example.process.management.Model.SubProcess;
import com.example.process.management.Model.Workflow;

@Repository
public interface WorkflowRepository extends JpaRepository<Workflow,Long> {
        @Query("SELECT c FROM Workflow c WHERE c.name= :workflowname")
        Workflow findWorkflowByName(@Param("workflowname") String workflowname);

    
}
