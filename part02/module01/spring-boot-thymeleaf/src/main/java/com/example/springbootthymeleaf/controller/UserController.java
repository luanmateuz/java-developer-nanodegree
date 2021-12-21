package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/demo")
    public String demo(Model model) {
        model.addAttribute("message", "Hello Thymeleaf");
        double grade = 90.5;
        model.addAttribute("grade", grade);
        model.addAttribute("GPA", convertGPA(grade));
        return "demo";
    }

    private String convertGPA(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade < 90 && grade >= 80) {
            return "B";
        } else if (grade < 80 && grade >= 70) {
            return "C";
        } else if (grade < 70 && grade >= 60) {
            return "B";
        } else {
            return "F";
        }
    }

    @RequestMapping("/demo2")
    public String demo2(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Tom", 30));
        userList.add(new User(2, "Jerry", 29));
        userList.add(new User(3, "Nancy", 27));
        model.addAttribute("list", userList);

        return "demo2";
    }

    @RequestMapping("/demo3")
    public String demo3(HttpServletRequest request, Model model) {
        request.setAttribute("request", "resquest data");
        request.getSession()
                .setAttribute("session", "session data");
        request.getSession()
                .getServletContext()
                .setAttribute("application", "application data");

        return "demo2";
    }
}
