package com.example.jsp7.dao.impl;

import com.example.jsp7.Jdbc.JdbcUtil;
import com.example.jsp7.dao.StudentDao;
import com.example.jsp7.handler.MultiResultHandler;
import com.example.jsp7.pojo.Student;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> searchStudents() {
        String sql="SELECT Id,`NAME`,sex,age, FROM student";
        return JdbcUtil.query(sql,new MultiResultHandler<>(Student.class));
    }

    @Override
    public int updateStudent(String id, String name, String sex, String age) {
        String sql="UPDATE student SET name=?,sex=?,age=?,WHERE id=?";
        return JdbcUtil.upData(sql,name,sex,age,id);
    }
}
