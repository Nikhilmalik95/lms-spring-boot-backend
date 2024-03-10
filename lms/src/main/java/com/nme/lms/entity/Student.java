package com.nme.lms.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;


@Entity
public class Student {
	
	

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String branch;
	
	private String batch;
	
	@Column(unique = true)
	private String collage_id;
	
	private String email;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "STUDENT_BOOK_MAPPING")
    private List<Book> book;
	
	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCollage_id() {
		return collage_id;
	}

	public void setCollage_id(String collage_id) {
		this.collage_id = collage_id;
	}

	
	
	
}
