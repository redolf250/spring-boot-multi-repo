package com.redolf.springsession.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HttpSession session;

    @GetMapping("/save-session-data")
    public String saveData(@RequestParam String data){
        session.setAttribute("data",data);
        return "Data saved!";
    }

    @GetMapping("/get-session-data")
    public String getData(@RequestParam String data){
        return (String)session.getAttribute(data);
    }
}
