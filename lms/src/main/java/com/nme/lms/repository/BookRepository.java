package com.nme.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nme.lms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
