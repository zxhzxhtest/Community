package com.zxh.springbootl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
public class Hello {


    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name){

        if(name.equals("aaa")){
            System.out.println("成功");
            return "success";
        }

        else{
            return "false";
        }

    }

    @RequestMapping("/helll")
    public String hello2(@RequestParam("name") String name, Model model){

        model.addAttribute("name",name);
        return "success";
    }
}
