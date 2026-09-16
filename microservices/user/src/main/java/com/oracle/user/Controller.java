package com.oracle.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Controller {
    @GetMapping("/user")
    public String getm1(@RequestParam(required = false) String name){
        if(name==null) return "Name Not Specified";
        return "User Returned";
    }
}
