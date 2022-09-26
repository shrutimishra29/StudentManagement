package com.college.Management.services;


import com.college.Management.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(String id);

    Student updateStudent(Student student);

    Student getStudentBydate(String date);
    void deleteStudentById(String id);
//
//    void getAlldates();
}

