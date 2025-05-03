package com.example.process.management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.process.management.Model.Process;
import com.example.process.management.Model.SubProcess;
@Repository
public interface ProcessRepository extends JpaRepository <Process,Long> {
        @Query("SELECT c FROM Process c WHERE c.workflow_id= :id")
        List< Process> findAllByWorkflowID(@Param("id") Long id);
        @Query("SELECT c FROM Process c WHERE c.status_id= :id")
        List< Process> findAllByStatusID(@Param("id") Long id);
        @Query("SELECT c FROM Process c WHERE c.created_by= :id")
        List< Process> findAllByuserID(@Param("id") Long id);

}
