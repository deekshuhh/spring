package com.oracle.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "USER")
public interface UserFeign {

    @GetMapping("/user")
    public String getm1(@RequestParam(required = false) String name);
}
