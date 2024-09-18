package com.example.MD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MD.Entities.User;

public interface UsersRepo extends JpaRepository<User,Long>
{
	
	public User findByUsername(String username);
}
