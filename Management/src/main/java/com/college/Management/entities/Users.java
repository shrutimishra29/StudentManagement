package com.college.Management.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Creating an Entity class
@Entity
public class Users {
    //@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
//
//	@GenericGenerator(name="emp_id",strategy =  "com.barath.springdata.idgenerators.entities.CostumRandomIdGenerator")
//	@GeneratedValue(generator = "emp_id")
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    private String username;
    private String email;
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Users(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public Users() {
        super();
        // TODO Auto-generated constructor stub
    }
}

