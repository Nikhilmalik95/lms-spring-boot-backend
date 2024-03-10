package com.nme.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nme.lms.entity.Book;
import com.nme.lms.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepo;
	
	@PostMapping("/book/createbook")
	public Book createBook(@RequestBody Book book) {
		
		return bookRepo.save(book);
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		
		return bookRepo.findAll();
		
	}
}
