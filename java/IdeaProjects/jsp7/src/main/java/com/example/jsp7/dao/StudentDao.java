package com.example.jsp7.dao;

import com.example.jsp7.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> searchStudents();
    public int updateStudent(String id, String name, String sex, String age);
}
