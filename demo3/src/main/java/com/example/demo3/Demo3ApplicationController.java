package com.example.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Demo3ApplicationController {
    @GetMapping("*")
    @ResponseBody
    public String home() {
        return "Moi demo 3!";
    }
}
