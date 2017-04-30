package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cinema.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Modifying
	@Query("update User u set u.userDetails=?1 where u.id=?2")
	public int editUserDetails(String details, Long id);
	
	@Query("select u from User u where u.name=?1")
	public User findUserByName(String name);
}
