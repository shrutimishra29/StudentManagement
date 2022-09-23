package com.college.Management.repos;

import com.college.Management.entities.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends CrudRepository<Users, String> {

    @Query("from Users where username=:Username")
    List<Users> findAllUsersByUsername(@Param("Username")String username);

    @Query("from Users where username=:username and password=:password")
    List<Users> findAllUsersByUsernameAndByPassword(@Param("username") String username,@Param("password") String password);

}
