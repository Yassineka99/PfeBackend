package com.example.process.management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.process.management.Model.SubProcess;
import com.example.process.management.Model.User;

@Repository
public interface SubProcessRepository extends JpaRepository<SubProcess,Long>{

        @Query("SELECT c FROM SubProcess c WHERE c.process_id= :id")
        List< SubProcess> findAllByProcessID(@Param("id") Long id);
        @Query("SELECT c FROM SubProcess c WHERE c.assigned_to= :id")
        List< SubProcess> findAlluserID(@Param("id") Long id);
        @Query("SELECT c FROM SubProcess c WHERE c.process_id = :processId AND c.assigned_to = :userId")
        List<SubProcess> findAllByProcessIdAndUserId(@Param("processId") Long processId, @Param("userId") Long userId);
        @Query("SELECT c FROM SubProcess c WHERE c.status = :status AND c.assigned_to = :userId")
        List<SubProcess> findAllByStatusAndAssignedTo(@Param("status") Long status, @Param("userId") Long userId);
}
