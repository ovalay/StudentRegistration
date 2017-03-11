package com.sloant.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tim Sloan
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model) {
        return "welcome";
    }
}
