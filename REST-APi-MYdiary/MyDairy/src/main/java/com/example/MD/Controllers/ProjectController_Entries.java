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

import com.example.MD.Entities.Entries;
import com.example.MD.Services.EntriesService;

@RestController
@RequestMapping("/entries/")
public class ProjectController_Entries {

	@Autowired
	EntriesService us;
	
	
	@PostMapping("/")
	public Entries saveEntries(@RequestBody Entries entry)
	{
		return us.save(entry);
	}
	
	@GetMapping("/")
	public List<Entries> getallEntriess()
	{
		return us.getall();
	}
	
	@GetMapping("/{id}")
	public Entries getEntries(@PathVariable long id)
	{
		return us.get(id);
	}
	
	@GetMapping("/id/{id}")
	public List<Entries> getEntry(@PathVariable long id)
	{
		return us.getid(id);
	}
	
	@PutMapping("/")
	public Entries updateEntry(@RequestBody Entries entry)
	{
		return us.update(entry);
	}
	
	
	@PutMapping("/{id}")
	public Entries updateEntries(@RequestBody Entries entry)
	{
		return us.update(entry);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEntries(@PathVariable long id)
	{
		Entries entry = us.get(id);
		us.delete(entry);
	}
}
