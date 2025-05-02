package com.example.process.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.process.management.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT c FROM User c WHERE c.email= :useremail")
    User findByEmail(@Param("useremail") String useremail);
}
