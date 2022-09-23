package com.college.Management.controller;

import com.college.Management.entities.Users;
import com.college.Management.services.UserDbService;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserDbService dbService;

    //Request mapping for register page
    @RequestMapping("register")
    public String register(){
        return "register";
    }

    //Reuqest mapping for login page
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(path="/loggedin")
    public String loggedIn(HttpServletRequest request) throws IllegalStateException, SystemException {
        //	String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + " " + password);
        if(dbService.validate(username, password)){
            return "success";
        }
        else {
            return "invalidlogin";
        }
    }

    @RequestMapping(path = "/processform")
    public String newUser(HttpServletRequest request) {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Users user = new Users(username,email,password);
        System.out.println(user.getUsername() + user.getEmail() + user.getPassword());
        dbService.create(user);
        return "success";
    }

}
