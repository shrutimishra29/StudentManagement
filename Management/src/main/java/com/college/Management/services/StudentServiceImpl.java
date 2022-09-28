package com.college.Management.services;


import com.college.Management.entities.Student;
import com.college.Management.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepository;

    public StudentServiceImpl(StudentRepo studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentBydate(String date) {
        return null;
    }

    @Override
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);

    }

    public List<Student> getStudentByEmail(String email){
        List<Student> students = studentRepository.findAll();
        List<Student> student1 = new ArrayList<>();
        for (Student student:
            students ) {
            if(student.getEmail() == email){
                student1.add(student);
            }
        }
        return student1;
     }
    //    @Override
//    public void getAlldates() {
//        List<Student> students = (List<Student>) studentRepository.findAll();
//        List<String> dateOfJoining = null;
//        for (Student student: students) {
//            dateOfJoining.add(student.getAddmissiondate());
//        }
//        System.out.println(dateOfJoining);
//    }
    public StudentServiceImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void searchBy(String search){
        switch(search){
            case "id":
            {

            }

            case "firstname":
            {

            }

            case "lastname": {

            }

            case "course":{

            }

            case "date":{

            }

        }


    }



}
