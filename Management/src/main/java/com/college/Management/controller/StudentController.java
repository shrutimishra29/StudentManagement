package com.college.Management.controller;

import com.college.Management.entities.Student;
import com.college.Management.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
   StudentServiceImpl impl;

    @RequestMapping("/newstudent")
    public String newStudent(){
        return "newstudent";
    }

    @RequestMapping("/showstudents")
    public String showStudents(Model m){
        List<Student> students = impl.getAllStudents();
        m.addAttribute("hello", "ruru");
        m.addAttribute("students",students);
        return "allstudents";
    }

    @RequestMapping(path = "/registered", method = RequestMethod.POST)
    public String registered(HttpServletRequest request, Model m) {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String date = request.getParameter("addmissiondate");
        System.out.println(firstname + lastname + course + date + email);
        Student student = new Student(firstname, lastname, email, course, date, phone);
        impl.saveStudent(student);
        return "registered";
    }
}
