package com.yuan.foodtrace.auth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author A_Yuan
 */
@RestController
@CrossOrigin("http://localhost:9528")
public class Test1 {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test(String str) {
        return str;
    }
}
