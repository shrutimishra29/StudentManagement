package com.college.Management.services;

import com.college.Management.entities.Users;
import com.college.Management.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDbService {

    @Autowired
    UserRepo userrepo;

    public void create(Users user) {
        userrepo.save(user);
    }

    public boolean validate(String username, String password)  {
        List<Users> list = userrepo.findAllUsersByUsername(username);
        for(int i=0 ; i<list.size(); i++) {
            //	System.out.println(list.get(i).getPassword());
            if(list.get(i).getPassword().equals(password)) {
                return true;
            }
        }

        return false;

    }

}
