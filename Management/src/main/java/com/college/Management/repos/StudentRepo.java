package com.college.Management.repos;

import com.college.Management.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends CrudRepository<Student, String> {

//    @Query("from Stduent where addmissiondate=:date")
//    List<Student> findAllStudentsByAddmissiondate(@Param("addmissiondate")String date);
}

