package com.example.jsp7.service;

import com.example.jsp7.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> searchStudents();
    int updateStudent(String id,String name,String sex, String age);

}
