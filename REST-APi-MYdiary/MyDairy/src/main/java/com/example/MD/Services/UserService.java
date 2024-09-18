package com.example.MD.Services;

import java.util.List;

import com.example.MD.Entities.User;

public interface UserService {
	
	public User get(long id);
	public List<User> getall();
	public User save(User user);
	public User update(User user);
	public void delete(User user);
	public User getbyusername(String username);
	
}
