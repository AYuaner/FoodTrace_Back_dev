package com.yuan.foodtrace.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author A_Yuan
 */
@RestController
public class Test {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Something";
    }
}
