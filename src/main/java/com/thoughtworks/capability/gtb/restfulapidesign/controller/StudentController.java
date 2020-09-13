package com.thoughtworks.capability.gtb.restfulapidesign.controller;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentAlreadyExistsException;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(@Valid Student student){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/genders/{gender}")
    public List<Student> getStudentsByGender(@PathVariable String gender) {
        return studentService.getAllStudentsByGender(gender);
    }
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) Integer id){
        return studentService.getStudentById(id);
    }
    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody Student student) throws StudentAlreadyExistsException {
        studentService.addStudent(student);
    }
    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable("id") @Min(1) Integer id){
        studentService.deleteStudentById(id);
    }
    @PatchMapping("/students/{id}")
    public Student updateStudentById(@PathVariable("id") @Min(1) Integer id, @RequestBody Student student) {
        studentService.updateStudentById(id, student);
        return studentService.getStudentById(id);
    }

}
