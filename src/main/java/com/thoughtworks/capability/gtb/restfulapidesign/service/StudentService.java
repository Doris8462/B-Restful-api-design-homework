package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public StudentService() {
        studentMap.put( 1 ,new Student(1, "沈乐棋","男",""));
        studentMap.put( 2 ,new Student(2, "徐慧慧","女",""));
        studentMap.put( 3 ,new Student(3, "陈思聪","男",""));
        studentMap.put( 4 ,new Student(4, "王江林","男",""));
        studentMap.put( 5 ,new Student(5, "王登宇","男",""));
        studentMap.put( 6 ,new Student(6, "江雨舟","男",""));
        studentMap.put( 7 ,new Student(7, "廖燊","男",""));
        studentMap.put( 8 ,new Student(8, "胡晓","女",""));
        studentMap.put( 9 ,new Student(9, "但杰","男",""));
    }
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }
}
