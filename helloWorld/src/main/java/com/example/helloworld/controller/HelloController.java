package com.example.helloworld.controller;

import com.example.helloworld.model.HelloModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloWorld")
public class HelloController {

    @PostMapping("/task1")
    public Integer addTwoNumbers(@RequestBody HelloModel helloModel){

        return helloModel.getNum1()+helloModel.getNum2();
    }
}
