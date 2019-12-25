package com.zxh.springbootl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
public class Hello {



    @RequestMapping("/")
    public String hello2(){


        return "index";
    }
}
