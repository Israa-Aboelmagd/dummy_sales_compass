package com.example.sales_compass.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.sales_compass.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserService userService;
    @GetMapping("/endpoint1")
    public String endPoint1() {
        userService.createUser();
        return "endPoint1";
    }
    @GetMapping("/endpoint2")
    public String endPoint2() {
        return "endPoint2";
    }
    @GetMapping("/endpoint3")
    public String endPoint3() {
        return "endPoint3";
    }
    @GetMapping("/endpoint4")
    public String endPoint4() {
        return "endPoint4";
    }
    @GetMapping("/endpoint5")
    public String endPoint5() {
        return "endPoint5";
    }
    @GetMapping("/endpoint6")
    public String endPoint6() {
        return "endPoint6";
    }
    
}
