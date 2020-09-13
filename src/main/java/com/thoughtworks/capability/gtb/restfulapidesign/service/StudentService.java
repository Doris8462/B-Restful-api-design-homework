package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private static Map<Integer, Student> studentMap = new HashMap<>();

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
    public static List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public Student getStudentById(Integer id) {
        return studentMap.get(id);
    }

    public void addStudent(Student student) {
        if(studentMap.containsKey(student.getId())) {
            throw new StudentAlreadyExistsException("用户已存在");
        }
        else {
            student.setId(studentMap.size());
            studentMap.put(student.getId(), student);
        }
    }

    public void deleteStudentById(Integer id) {
        if(studentMap.get(id)==null) {
            throw new StudentAlreadyExistsException("用户不存在");
        }
        else studentMap.remove(id);
    }

    public void updateStudentById(Integer id,Student updateStudent) {
        if(studentMap.get(id)==null) {
            throw new StudentAlreadyExistsException("用户不存在");
        }
        else {
            Student student=studentMap.get(id);
            student.setName(updateStudent.getName()!=null?updateStudent.getName():student.getName());
            student.setGender(updateStudent.getGender()!=null?updateStudent.getGender():student.getGender());
            student.setNote(updateStudent.getNote()!=null?updateStudent.getNote():student.getNote());
        }
    }

    public List<Student> getAllStudentsByGender(String gender)  {
        List<Student> students=new ArrayList<Student>();
        studentMap.forEach((index,student) -> {
            if(gender.equals(student.getGender()))
                students.add(student);
        });
        return students;
    }
}
