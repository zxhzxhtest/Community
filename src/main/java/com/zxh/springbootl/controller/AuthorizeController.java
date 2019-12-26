package com.zxh.springbootl.controller;


import com.zxh.springbootl.dto.AccessTokenDTO;
import com.zxh.springbootl.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name="state")String state){

        AccessTokenDTO accessToken = new AccessTokenDTO();



        accessToken.setClient_id("Iv1.a5edaa4c7ed4590b");
        accessToken.setClient_secret("b528411d8a371de0abb47434b150b18e70bb471a");
        accessToken.setRedirect_uri("http://localhost:8887/callback");
        accessToken.setCode(code);
        accessToken.setState(state);
        githubProvider.getAccessToken(accessToken);

        return "index";


    }


}
