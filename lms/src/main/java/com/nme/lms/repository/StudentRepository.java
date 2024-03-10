package com.nme.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nme.lms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
