package com.luks64.filters.controllers;

import com.luks64.filters.models.Agent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController{
    @GetMapping("/agent")
    public Agent getName(){
        Agent agent = new Agent();
        agent.setId(234);
        agent.setFirstName("Agent");
        agent.setLastName("Smith");

        return agent;
    }
}