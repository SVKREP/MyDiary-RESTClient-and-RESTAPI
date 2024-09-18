package com.example.MD.Entities;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
@Table(name="entries")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Entries {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long entryid;
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	LocalDate date;
	String description;
	long id;
	public long getEntryid() {
		return entryid;
	}
	public void setEntryid(long entryid) {
		this.entryid = entryid;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
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
