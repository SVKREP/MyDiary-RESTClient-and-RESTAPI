package com.example.demo.Entities;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Entries {


	long entryid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	Date date;
	String description;
	long id;
	public long getEntryid() {
		return entryid;
	}
	public void setEntryid(long entryid) {
		this.entryid = entryid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
