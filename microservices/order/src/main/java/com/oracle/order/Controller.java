package com.oracle.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final UserFeign ufo;

    public Controller(UserFeign ufo) {
        this.ufo = ufo;
    }

    @GetMapping("/order")
    public String getOrder(@RequestParam(required = false) String name){
        String data= ufo.getm1(name);
        return "Order is Running"+ data;
    }
}
