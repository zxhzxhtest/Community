package com.zxh.springbootl.controller;


import com.zxh.springbootl.dto.AccessTokenDTO;
import com.zxh.springbootl.dto.GithubUser;
import com.zxh.springbootl.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    public String uri;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name="state")String state){

        AccessTokenDTO accessToken = new AccessTokenDTO();



        accessToken.setClient_id(clientId);
        accessToken.setClient_secret(clientSecret);
        accessToken.setRedirect_uri(uri);
        accessToken.setCode(code);
        accessToken.setState(state);
        String accessToken1 = githubProvider.getAccessToken(accessToken);
        GithubUser user = githubProvider.getUser(accessToken1);
        System.out.println(user.getName());

        return "index";


    }


}
