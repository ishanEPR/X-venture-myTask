package com.example.crud_app_mongodb.Controller;

import com.example.crud_app_mongodb.Model.User;
import com.example.crud_app_mongodb.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    //save user
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        log.info("Inside addUser method in UserController");
        User userDetails=userService.addUser(user);
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }


    //get all details
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsersDetails()
    {
        log.info("Inside getUsersDetails method in UserController");
        List<User> userList=userService.getUsersDetails();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    //get user details a specific user
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id)
    {
        log.info("Inside getUserById method in UserController");
        return userService.getUserById(id);

    }

    //edit user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> editUser(@PathVariable String id,@RequestBody User user)
    {

        log.info("Inside editUser method in UserController");
        return userService.editUser(id,user);
    }

   // delete user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id)
    {
        log.info("Inside deleteUser method in UserController");
       return  userService.deleteUser(id);

    }
}
