package com.example.power_reviews.controller;

import com.example.power_reviews.model.fillRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backpack")
public class controller {

    @GetMapping("/fill")
    public fillRequest getBackpack(@RequestBody fillRequest request) {
        return request;
    }

}