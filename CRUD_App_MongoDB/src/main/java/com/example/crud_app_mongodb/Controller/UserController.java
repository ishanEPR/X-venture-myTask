package com.example.crud_app_mongodb.Controller;

import com.example.crud_app_mongodb.Model.User;
import com.example.crud_app_mongodb.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "This is the add user data in to database")
    @ApiResponse(responseCode = "200",
            description = "User Data added successfully",
            content = @Content(mediaType = "application/json")
    )

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        log.info("Inside addUser method in UserController");
        User userDetails=userService.addUser(user);
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }




    //get all details
    @Operation(summary = "This is the fetch all data from database")
    @ApiResponse(
            responseCode = "200",
            description = "fetch all data from database",
            content = {@Content(mediaType = "application/json")}

    )
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsersDetails()
    {
        log.info("Inside getUsersDetails method in UserController");
        List<User> userList=userService.getUsersDetails();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }




    //get user details a specific user

    @Operation(summary = "get user details a specific user from database")
   @ApiResponses(value = {
           @ApiResponse(
                   responseCode = "200",
                   description = "user found",
                   content = {@Content(mediaType = "application/json")}
           ),
           @ApiResponse(
                   responseCode = "404",
                   description = "user not found",
                   content = @Content
           )
   })
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id)
    {
        log.info("Inside getUserById method in UserController");
        return userService.getUserById(id);

    }




    //edit user
    @Operation(summary = "This is update user endpoint")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "updated successfully",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "updated unsuccessfully",
                    content = @Content
            )
    })
    @PutMapping("/users/{id}")
    public ResponseEntity<User> editUser(@PathVariable String id,@RequestBody User user)
    {

        log.info("Inside editUser method in UserController");
        return userService.editUser(id,user);
    }




   // delete user
    @Operation(summary = "This is delete method")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "user deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "user deleted unsuccessfully"
            )
    })
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id)
    {
        log.info("Inside deleteUser method in UserController");
       return  userService.deleteUser(id);

    }
}
