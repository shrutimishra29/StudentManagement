package com.college.Management.controller;

import com.college.Management.entities.Student;
import com.college.Management.repos.StudentRepo;
import com.college.Management.services.StudentServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Controller

public class StudentController {


   @Autowired
   private StudentRepo studentRepo;

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
        m.addAttribute("student",student);
        return "registered";
    }

//    @RequestMapping("/tttt")
//    public String trail(){
//        return "trial";
//    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable String id,
                                @ModelAttribute("student") Student student,
                                Model model) {

        // get student from database by id
        Student existingStudent = impl.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstname(student.getFirstname());
        existingStudent.setLastname(student.getLastname());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setAddmissiondate(student.getAddmissiondate());
        // save updated student object
        impl.updateStudent(existingStudent);
        return "redirect:/showstudents";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable String id, Model model) {
        model.addAttribute("student", impl.getStudentById(id));
        return "upstudent";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable String id) {
        impl.deleteStudentById(id);
        return "redirect:/showstudents";
    }

    @RequestMapping("graph")
    public String graph(Model m){
        List<Student> students = studentRepo.findAll();
//        List<String> months = new ArrayList<>();
        List<String> courses = new ArrayList<>();
        courses.add("Java");
        courses.add("Angular");
        courses.add("C and C++");
        courses.add(".NET");
        Map<Map,Integer> all = new HashMap<>();

        int javaCount=0;
        int angularCount=0;
        int ccount =0;
        int netCount =0;
        for(int i=0; i<students.size(); i++){
           if(students.get(i).getCourse().equals("Java")){
               javaCount++;
           }
            if(students.get(i).getCourse().equals("Angular")){
                angularCount++;
            }

            if(students.get(i).getCourse().equals("C and C++")){
                ccount++;
            }

            if(students.get(i).getCourse().equals(".NET")){
                netCount++;
            }
        }
//        int numbers[] = new int[4];
        List<Integer> numbers = new ArrayList<>();
        numbers.add(javaCount);
        numbers.add(angularCount);
        numbers.add(ccount);
        numbers.add(netCount);
        System.out.println("Java :" + javaCount + " Angular "+ angularCount + " .NET :" +netCount+ " C and C++ :" + ccount);
//        m.addAttribute(courses);
//        m.addAttribute(numbers);
        List<String> courseList= courses.stream().collect(Collectors.toList());
       // List<Integer> ageList = m.getAllEmployee().stream().map(x-> x.getAge()).collect(Collectors.toList());
        List<Integer> numList = numbers.stream().collect(Collectors.toList());
        m.addAttribute("courses", courseList);
        m.addAttribute("count", numList);
        return "graph";
    }
}
