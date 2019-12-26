package com.zxh.springbootl.provider;


import com.alibaba.fastjson.JSON;
import com.zxh.springbootl.dto.AccessTokenDTO;
import com.zxh.springbootl.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
//加了compoment后使用的时候不需要实例化对象

@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO){
     MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();


            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/authorize")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string=response.body().string();
                System.out.println(string);
                return string;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;


    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token"+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string=response.body().string();
//            System.out.println(string);
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}