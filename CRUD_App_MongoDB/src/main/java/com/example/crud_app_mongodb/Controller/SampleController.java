package com.example.crud_app_mongodb.Controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {


 //swagger 2.0   @ApiOperation(value ="say hello swagger",notes ="this is note" )
    @Operation(summary = "sample controller")
    @ApiResponse(
            description = "display message"
    )
    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hi, Reshmika";
    }
}
