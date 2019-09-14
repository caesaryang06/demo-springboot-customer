package com.example.demospringbootcustomer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CAESAR
 * @Classname IndexController
 * @Description TODO
 * @Date 2019-09-14 14:44
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "ok";
    }


    @GetMapping("/jsp")
    public String helloJsp(){

        return "index";
    }

}
