package com.example.MD.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.MD.Entities.User;
import com.example.MD.Repository.UsersRepo;

@Component
public class UserServiceIMP implements UserService {
	
	@Autowired
	UsersRepo ur;

	@Override
	public User get(long id) {
		// TODO Auto-generated method stub
		return ur.findById(id).get();
	}

	@Override
	public List<User> getall() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return ur.save(user);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return ur.save(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		 ur.delete(user);
	}

	public User getbyusername(String username)
	{
		return ur.findByUsername(username);
		
	}
}
