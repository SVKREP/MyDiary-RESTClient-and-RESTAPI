package com.example.MD.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.MD.Entities.Entries;
import com.example.MD.Repository.EntriesRepo;

@Component
public class EntriesServiceIMP implements EntriesService {

	@Autowired
	EntriesRepo er;
	
	@Override
	public Entries get(long entryid) {
		// TODO Auto-generated method stub
		return er.getReferenceById(entryid);
	}

	@Override
	public List<Entries> getall() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public Entries save(Entries entry) {
		// TODO Auto-generated method stub
		return er.save(entry);
	}

	@Override
	public Entries update(Entries entry) {
		// TODO Auto-generated method stub
		return er.save(entry);
	}

	@Override
	public void delete(Entries entry) {
		// TODO Auto-generated method stub
		er.delete(entry);
		
	}

	public List<Entries> getid(long id)
	{
		return er.findByid(id);
	}

}
