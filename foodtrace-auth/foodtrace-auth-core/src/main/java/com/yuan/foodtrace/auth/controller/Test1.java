package com.yuan.foodtrace.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author A_Yuan
 */
@RestController
public class Test1 {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test() {
        return "Something";
    }
}
