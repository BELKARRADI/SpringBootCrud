package com.example.demo1.repository;

import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo1.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student findById(int id);
	@Query("select year(s.dateNaissance) as annee, count(*) as nbr from Student s group by year(s.dateNaissance) order by year(s.dateNaissance)")
	List<Student> findNbrStudentByYear();
}