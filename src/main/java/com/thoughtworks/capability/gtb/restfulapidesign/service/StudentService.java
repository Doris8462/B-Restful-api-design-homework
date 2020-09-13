package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private Map<String, Student> studentMap = new HashMap<>();

    public StudentService() {
        studentMap.put( "沈乐棋" ,new Student(1, "沈乐棋","男",""));
        studentMap.put( "徐慧慧" ,new Student(2, "徐慧慧","女",""));
        studentMap.put( "陈思聪" ,new Student(3, "陈思聪","男",""));
        studentMap.put( "王江林" ,new Student(4, "王江林","男",""));
        studentMap.put( "王登宇" ,new Student(5, "王登宇","男",""));
        studentMap.put( "江雨舟" ,new Student(6, "江雨舟","男",""));
        studentMap.put( "廖燊" ,new Student(7, "廖燊","男",""));
        studentMap.put( "胡晓" ,new Student(8, "胡晓","女",""));
        studentMap.put( "但杰" ,new Student(9, "但杰","男",""));
    }
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public Student getStudentById(Integer id) {
        return studentMap.get(id);
    }

    public void addStudent(Student student) {
        if(studentMap.containsKey(student.getName())) {
            throw new StudentAlreadyExistsException("用户已存在");
        }
        else {
            student.setId(studentMap.size());
            studentMap.put(student.getName(), student);
        }
    }
}
