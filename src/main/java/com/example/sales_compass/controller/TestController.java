package com.example.sales_compass.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.sales_compass.model.User;
import com.example.sales_compass.repo.UserRepo;
import com.example.sales_compass.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserService userService;
    //  @Autowired
    // private UserRepo userRepo;

    @GetMapping("/endpoint1")
    public String endPoint1() {
        // User user = userRepo.findById(6L)                 
        //         .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        //     System.out.println("//////////////////////////////"+user.toString());
        // userService.createUser();
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

    @PostMapping("/create-visit")
    public String createVisit() {
        return "createVisit";
    }

    @GetMapping("/get-visits")
    public String getVisits() {
        return "getVisits";
    }
    
    
}
