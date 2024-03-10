package com.nme.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nme.lms.entity.Book;
import com.nme.lms.entity.Student;
import com.nme.lms.repository.BookRepository;
import com.nme.lms.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	@PostMapping("/student/createstudent")
	public Student createStudent(@RequestBody Student s) {
		
		System.out.println(s);
		return studentRepo.save(s);
		
	}
	
	@GetMapping("/student/{student-id}")
	public Student getStudentById(@PathVariable("student-id") int id) {
		return studentRepo.findById(id).orElse(new Student());
	}
	
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		
		return studentRepo.findAll();	
	}
	
	@PutMapping("/issuebook/{student-id}/{book-id}")
	public String issueBook(@PathVariable("student-id") int studentId , @PathVariable("book-id") int bookId){
		List<Book> bookList = null;
		Student s = studentRepo.findById(studentId).get();
		Book b =  bookRepo.findById(bookId).get();
		int noOfBooks = b.getNoOfBooks();
		if(noOfBooks > 0) {
			bookList = s.getBook();
			bookList.add(b);
			b.setNoOfBooks(noOfBooks-1);
			s.setBook(bookList);
			studentRepo.save(s);
			return "issued successfully";
		}else {
			return "All books are already issued No book available";
		}
		
	}
	
	@PutMapping("/returnbook/{student-id}/{book-id}")
	public Student returnBook(@PathVariable("student-id") int studentId , @PathVariable("book-id") int bookId){
		List<Book> bookList = null;
		Student s = studentRepo.findById(studentId).get();
		Book b =  bookRepo.findById(bookId).get();
		int noOfBooks = b.getNoOfBooks();
		b.setNoOfBooks(noOfBooks+1);
		bookList = s.getBook();
		bookList.remove(b);
		s.setBook(bookList);
		return studentRepo.save(s);
	}
	
	
	@DeleteMapping("/deletestudent/{delete}")
	public String delete(@PathVariable("delete") int id) {
		Student s = studentRepo.findById(id).get();
		if(s.getBook() != null) {
			List<Book> bookList = s.getBook();
			return "can not delete student because books are alloted to him and the number of books alloted are : " + bookList.size();
		}else {
			studentRepo.deleteById(id);
			return "student deleted successfully";
		}
		
	}
}
