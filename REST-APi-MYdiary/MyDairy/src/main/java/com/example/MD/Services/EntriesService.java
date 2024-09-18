package com.example.MD.Services;

import java.util.List;

import com.example.MD.Entities.Entries;

public interface EntriesService {
	
	public Entries get(long entryid);
	public List<Entries> getall();
	public Entries save(Entries entry);
	public Entries update(Entries entry);
	public void delete(Entries entry);
	public List<Entries> getid(long id);
}
