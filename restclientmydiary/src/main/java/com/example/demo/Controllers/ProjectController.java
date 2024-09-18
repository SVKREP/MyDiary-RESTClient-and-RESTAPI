package com.example.demo.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entities.Entries;
import com.example.demo.Entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProjectController
{
	
	@RequestMapping({"/login","/"})
	public String homepage()
	{
		return "login";
	}
	
	@RequestMapping("/register")
	public String registerpage()
	{
		return "register";
	}
	
	
	
	@RequestMapping("/updateentry")
	public String updateentry(@ModelAttribute Entries entry, HttpSession session) {
	    RestTemplate t = new RestTemplate();
	    
	    User user = (User) session.getAttribute("user");
	    
	    // Check if the user and entry object have been populated correctly
	    System.out.println("User: " + user.getUsername() + " Entry ID: " + entry.getEntryid() + " Description: " + entry.getDescription() + " Record ID: " + entry.getId());

	    entry.setId(user.getId());  // Set the user ID if necessary
	    
	    String s = "http://localhost:8080/MD/entries/" + entry.getEntryid();  // Include the entryId in the URL
	    t.put(s, entry);  // Pass the entry object to the API
	    
	    return "redirect:/dash";
	}

	
	
	
	@RequestMapping("/dash")
	public String Dashboard(HttpSession session, Model model) {
	    // Retrieve user from session
	    User user = (User) session.getAttribute("user");

	    // If user is null, redirect to login (handle session expiration, etc.)
	    if (user == null) {
	        return "redirect:/login"; // Or appropriate login page
	    }

	    // Retrieve the user ID or appropriate ID
	    Long userId = user.getId(); // Assuming user.getId() returns a Long

	    // Construct the URL with the correct ID type
	    String s = "http://localhost:8080/MD/entries/id/" + userId;

	    // Make the REST call using RestTemplate
	    RestTemplate t = new RestTemplate();
	    ResponseEntity<Entries[]> entriesResponse = t.getForEntity(s, Entries[].class);

	    // Add the records and username to the model for the JSP
	    model.addAttribute("records", entriesResponse.getBody()); // Use getBody() to get the actual list
	    model.addAttribute("username", user.getUsername());

	    return "dash"; // Return the view name
	}
	
	
	@RequestMapping("/view")
	public String View()
	{
		return "view";
	}
	
	
	@RequestMapping("/SRF")
	public String saveuser(@ModelAttribute User user)
	{
		
		System.out.print(user.getPassword());
		RestTemplate t = new RestTemplate();
		//t.getInterceptors().add(new BasicAuthenticationInterceptor("cook", "cook"));
		ResponseEntity<User> user1 = t.postForEntity("http://localhost:8080/MD/users/", user, User.class);
		
		return "login";
	}	
	
	
	@RequestMapping("/submitForm")
	public String loginuser(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session)
	{
		User user = null;
		RestTemplate t = new RestTemplate();
		System.out.println("This is the password  --------------------------------1-");
		String s = "http://localhost:8080/MD/users/username/";
		s = s.concat(username);
		System.out.println(s+" "+username+" "+password);
		try {
			ResponseEntity<User> user1 = t.getForEntity(s, User.class);
			System.out.println("This is the password  ---------------------------------2-+" + user1.getBody().toString());
			String ss = user1.getBody().getPassword();
			System.out.println("This is the password  ----------------------------------- "+ss);
			if(user1 != null && password.equals(ss) )
			{
				session.setAttribute("user", user1.getBody());
				return "redirect:/dash";
			}
		}
		//System.out.println("This is the password  ---------------------------------2");
		 catch (Exception e) {
			    // Handle other exceptions, e.g., connectivity issues
			 System.out.print(e);
			}
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/login";
	}
	
    @RequestMapping("/deleteentry")
    public String deleteentry(@RequestParam("entryId") long entryid)
    {
    	RestTemplate t = new RestTemplate();
    	String s = "http://localhost:8080/MD/entries/"+entryid;
    	System.out.println("deleting the record --- "+entryid);
    	t.delete(s);
    	return "redirect:/dash";
    }
    
	
	@RequestMapping("/submitentry")
	public String Entry(@ModelAttribute Entries entry, HttpSession session)
	{
		
		RestTemplate t = new RestTemplate();
		//t.getInterceptors().add(new BasicAuthenticationInterceptor("cook", "cook"));
		User user1 = (User)session.getAttribute("user");
		System.out.println("This is the password  ---------------------------------2");
		entry.setId(user1.getId());
		System.out.println("This is the date  ---------------------------------"+entry.getDate());
		ResponseEntity<Entries> e = t.postForEntity("http://localhost:8080/MD/entries/", entry, Entries.class);
		return "redirect:/dash";
	}
	
}
