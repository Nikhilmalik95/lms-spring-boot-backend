package com.nme.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nme.lms.entity.Library;
import com.nme.lms.repository.LibraryRepository;

@RestController
public class LibraryController {
	
	@Autowired
	private LibraryRepository libRepo;
	
	@PostMapping("/library/createlibrary")
	public Library createLibrary(@RequestBody Library lib) {
		
		return libRepo.save(lib);
		
	}
	
	@GetMapping("/alllibrary")
	public List<Library> getAllLibrary(){
		
		return libRepo.findAll();
	}
}
