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
@RequestMapping("/students")
@Validated
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public List<Student> getAllStudents(@Valid Student student){
        return studentService.getAllStudents();
    }

    @GetMapping("/genders/{gender}")
    public List<Student> getStudentsByGender(@PathVariable String gender) {
        return studentService.getAllStudentsByGender(gender);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) Integer id){
        return studentService.getStudentById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody Student student) throws StudentAlreadyExistsException {
        studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable("id") @Min(1) Integer id){
        studentService.deleteStudentById(id);
    }

    @PatchMapping("/{id}")
    public Student updateStudentById(@PathVariable("id") @Min(1) Integer id, @RequestBody Student student) {
        studentService.updateStudentById(id, student);
        return studentService.getStudentById(id);
    }
}
