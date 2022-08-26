package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.Model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    public static final String template = "Hello , %s!";
    private final AtomicLong counter = new AtomicLong();

    /** UC1- Created Simple Spring App that return message to the user.
     *
     * @param name
     * @return test Using Curl
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world")String name){
        return new Greeting(counter.incrementAndGet(),
        String.format(template, name));
    }
}
