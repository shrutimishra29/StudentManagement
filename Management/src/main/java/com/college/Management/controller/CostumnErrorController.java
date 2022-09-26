package com.college.Management.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class CostumnErrorController implements ErrorController{

    @RequestMapping("/error")
    public String error(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if (HttpStatus.NOT_FOUND.value() == statusCode) {
                return "error-404";
            }

        }
        return "error";
    }


    public String getErrorPath(){
        return null;
    }

}

