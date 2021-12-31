package edu.udacity.java.nano.chatroom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController("/")
public class ChatController {

    @GetMapping("")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/index")
    public ModelAndView index(String username, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("chat");
        mv.addObject("username", username);

        return mv;
    }
}
