package com.example.springbootexception.exceptions;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         @Nullable Object handler,
                                         Exception ex) {
        ModelAndView mv = new ModelAndView();
        if (ex instanceof ArithmeticException) {
            mv.setViewName("mathError");
        }
        if (ex instanceof NullPointerException) {
            mv.setViewName("nullPointerError");
        }

        mv.addObject("exception", ex.toString());

        return mv;
    }
}
