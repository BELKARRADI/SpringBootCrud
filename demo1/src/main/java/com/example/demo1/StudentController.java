package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo1.entity.Student;
import com.example.demo1.repository.StudentRepository;
import java.util.List; 

import org.springframework.*;
@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(required = true) String id) {
        Student s = studentRepository.findById(Integer.parseInt(id));
        if (s != null) {
            studentRepository.delete(s);
        }
    }

    @GetMapping("/all")
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping(value = "/count")
    public long countStudent() {
        return studentRepository.count();
    }

    @GetMapping(value = "/byYear")
    public List<Student> findByYear() {
        // Remplacez ce retour par la logique appropriée
        return (List<Student>) studentRepository.findNbrStudentByYear();
        
    }
}
