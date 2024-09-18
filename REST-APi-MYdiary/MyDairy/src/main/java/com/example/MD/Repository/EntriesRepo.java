package com.example.MD.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MD.Entities.Entries;

public interface EntriesRepo extends JpaRepository<Entries,Long>{
	
	public List<Entries> findByid(long id);

}
