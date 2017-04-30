package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cinema.model.UserRole;
 
@Repository
public interface UserRolesRepository extends JpaRepository<UserRole, Long> {
  
    @Query("select a.role from UserRole a, User b where b.name=?1 and a.userid=b.id")
    public List<String> findRoleByUserName(String username);
  
}
