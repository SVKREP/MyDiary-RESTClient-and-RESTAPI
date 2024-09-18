package com.example.MD.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MD.Entities.User;
import com.example.MD.Services.UserService;


@RestController
@RequestMapping("/users")
public class ProjectController_User {

	@Autowired
	UserService us;
	
	
	@PostMapping("/")
	public User saveuser(@RequestBody User user)
	{
		System.out.println(user);
		return us.save(user);
	}
	
	@GetMapping("/")
	public List<User> getallusers()
	{
		return us.getall();
	}
	
	@GetMapping("/{id}")
	public User getuser(@PathVariable long id)
	{
		return us.get(id);
	}
	
	@GetMapping("/username/{username}")
	public User getuseruser(@PathVariable String username) 
	{  
	
		User user = us.getbyusername(username);
		System.out.println("new user password "+user.getPassword());
		return user;
	}
	
	@PutMapping("/")
	public User updateuser(@RequestBody User user)
	{
		return us.update(user);
	}
	
	@PutMapping("/{id}")
	public User updateuser(@PathVariable long id)
	{
		User user = us.get(id);
		return us.update(user);
	}
	
	@DeleteMapping("/{id}")
	public User deleteuser(@PathVariable long id)
	{
		User user = us.get(id);
		us.delete(user);
		return user;
	}
	
	
}
