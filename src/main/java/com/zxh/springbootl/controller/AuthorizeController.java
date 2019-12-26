package com.zxh.springbootl.controller;


import com.zxh.springbootl.dto.AccessTokenDTO;
import com.zxh.springbootl.dto.GithubUser;
import com.zxh.springbootl.mapper.UserMapper;
import com.zxh.springbootl.model.User;
import com.zxh.springbootl.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    UserMapper userMapper;

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
                           @RequestParam(name="state")String state,
                           HttpServletRequest request){

        AccessTokenDTO accessToken = new AccessTokenDTO();



        accessToken.setClient_id(clientId);
        accessToken.setClient_secret(clientSecret);
        accessToken.setRedirect_uri(uri);
        accessToken.setCode(code);
        accessToken.setState(state);
        String accessToken1 = githubProvider.getAccessToken(accessToken);
        GithubUser user = githubProvider.getUser(accessToken1);
        System.out.println(user.getName());
        if(user!=null){
            User user1=new User();

            user1.setToken(UUID.randomUUID().toString());
            user1.setName(user.getName());
            user1.setAccountId(String.valueOf(user.getId()));
            user1.setGmtCreate(System.currentTimeMillis());
            user1.setGmtModified(user1.getGmtCreate());
            userMapper.insertUser(user1);
            request.getSession().setAttribute("user",user);

            return "redirect:/";
        }else {

            return "redirect:/";

        }
    }


}
