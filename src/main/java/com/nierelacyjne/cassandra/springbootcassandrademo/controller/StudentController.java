package com.nierelacyjne.cassandra.springbootcassandrademo.controller;

import com.nierelacyjne.cassandra.springbootcassandrademo.model.Student;
import com.nierelacyjne.cassandra.springbootcassandrademo.repo.ResourceNotFoundException;
import com.nierelacyjne.cassandra.springbootcassandrademo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    //create
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return student;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Integer studentid, @RequestBody Student studentDeatils) {

        Student student = studentRepository.findById(studentid).orElseThrow(
                () -> new ResourceNotFoundException("Student not found.." + studentid)
        );
        student.setName(studentDeatils.getName());
        final Student updateStudent = studentRepository.save(student);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") Integer studentid, @RequestBody Student studentDeatils) {

        Student student = studentRepository.findById(studentid).orElseThrow(
                () -> new ResourceNotFoundException("Student not found.." + studentid)
        );
        studentRepository.delete(student);
        return ResponseEntity.ok().build();
    }

}
