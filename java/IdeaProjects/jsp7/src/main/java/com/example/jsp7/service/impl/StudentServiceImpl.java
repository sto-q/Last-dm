package com.example.jsp7.service.impl;

import com.example.jsp7.dao.StudentDao;
import com.example.jsp7.dao.impl.StudentDaoImpl;
import com.example.jsp7.pojo.Student;
import com.example.jsp7.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao=new StudentDaoImpl();
    @Override
    public List<Student> searchStudents() {
        return studentDao.searchStudents();
    }

    @Override
    public int updateStudent(String id, String name, String sex, String age) {
        return studentDao.updateStudent(id, name, sex, age);
    }
}
