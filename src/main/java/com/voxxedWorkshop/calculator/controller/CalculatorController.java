package com.voxxedWorkshop.calculator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @RequestMapping("/sum")
    public String sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return String.valueOf(a + b);
    }
    
    @RequestMapping("/mult")
    public String multiply(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return String.valueOf(a * b);
    }
}
