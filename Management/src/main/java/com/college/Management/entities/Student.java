package com.college.Management.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table
public class Student {

        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demo_sql")
    @GenericGenerator(name = "demo_sql", strategy = "com.college.Management.entities.StringPrefixedSequenceGenerator", parameters = {

            @Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "Student_"),
            @Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d"),
    })
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String course;
    private String addmissiondate;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddmissiondate() {
        return addmissiondate;
    }

    public void setAddmissiondate(String addmissiondate) {
        this.addmissiondate = addmissiondate;
    }

    public Student(String firstname, String lastname, String email, String course, String addmissiondate,
                   String phone) {
        super();
        // this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.course = course;
        this.addmissiondate = addmissiondate;
        this.phone = phone;
    }

    public Student() {
        super();
    }

}

