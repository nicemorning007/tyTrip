/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueRouter.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.v1.router;

import cn.nicemorning.ty_trip.config.third.pojo.RuyueDataPojo;
import cn.nicemorning.ty_trip.config.third.pojo.RuyueLoginPojo;
import com.google.gson.Gson;
import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 如约数据请求类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
public class RuyueRouter {
    //    private OkHttpHelper helper = new OkHttpHelper();
//
//    public void loginCookie() {
//        OkHttpClient client = helper.createClient();
//        Request request = helper.createRequest("http://ryxing.gzruyue.org.cn/login.html");
//        Call loginCall = client.newCall(request);
//        try {
//            Response loginResponse = loginCall.execute();
//            System.out.println(loginResponse.body().string());
//            Headers headers = loginResponse.headers();
//            HttpUrl loginUrl = request.url();
//            List<Cookie> cookies = Cookie.parseAll(loginUrl, headers);
//            if (cookies != null) {
//                client.cookieJar().saveFromResponse(loginUrl, cookies);
//            }
//            for (Cookie cookie : cookies) {
//                System.out.println("#########cookie:" + cookie.name() + ":" + cookie.value());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//初始化Cookie管理器
    private Gson gson = new Gson();
    CookieJar cookieJar = new CookieJar() {
        //Cookie缓存区
        private Map<String, List<Cookie>> cookiesMap = new HashMap<>();

        @Override
        public void saveFromResponse(HttpUrl arg0, List<Cookie> arg1) {
            // TODO Auto-generated method stub
            //移除相同的url的Cookie
            String host = arg0.host();
            List<Cookie> cookiesList = cookiesMap.get(host);
            if (cookiesList != null) {
                cookiesMap.remove(host);
            }
            //再重新天添加
            cookiesMap.put(host, arg1);
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl arg0) {
            // TODO Auto-generated method stub
            List<Cookie> cookiesList = cookiesMap.get(arg0.host());
            //注：这里不能返回null，否则会报NULLException的错误。
            //原因：当Request 连接到网络的时候，OkHttp会调用loadForRequest()
            return cookiesList != null ? cookiesList : new ArrayList<>();
        }
    };
    //创建OkHttpClient
    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .cookieJar(cookieJar)
            .build();
    //创建Request请求
    Request loginRequest = new Request.Builder()
            .url("http://ryxing.gzruyue.org.cn/login.html")
            .get()
            .build();

    public void loginCookie() {
        //上传
        Call loginCall = client.newCall(loginRequest);

        try {
            //非异步执行
            Response loginResponse = loginCall.execute();
            //测试是否登陆成功
            System.out.println(loginResponse.body().string());
            //获取返回数据的头部
            Headers headers = loginResponse.headers();
            HttpUrl loginUrl = loginRequest.url();
            //获取头部的Cookie,注意：可以通过Cooke.parseAll()来获取
            List<Cookie> cookies = Cookie.parseAll(loginUrl, headers);
            //防止header没有Cookie的情况
            if (cookies != null) {
                //存储到Cookie管理器中
                client.cookieJar().saveFromResponse(loginUrl, cookies);//这样就将Cookie存储到缓存中了
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //获取需要提交的CookieStr
        StringBuilder cookieStr = new StringBuilder();
        //从缓存中获取Cookie
        List<Cookie> cookies = client.cookieJar().loadForRequest(loginRequest.url());
        //将Cookie数据弄成一行
        for(Cookie cookie : cookies){
            cookieStr.append(cookie.name()).append("=").append(cookie.value()+";");
        }
        System.out.println(cookieStr.toString());
        //设置提交的请求
        Request attentionRequest = new Request.Builder()
                .url("http://www.gzruyue.org.cn:8094/api/user/GetIntegralByUser?userId=15602667422")
//                .header("Cookie", cookieStr.toString())
                .get()
                .build();
        Call attentionCall = client.newCall(attentionRequest);
        try {
            //连接网络
            Response attentionResponse = attentionCall.execute();
            if (attentionResponse.isSuccessful()){
                //获取返回的数据
                String data = attentionResponse.body().string();
                //测试
                System.out.println(data);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        RequestBody requestBody = new FormBody.Builder()
                .add("type", "2")
                .build();
        Request loginRequest = new Request.Builder()
                .url("http://www.gzruyue.org.cn:8090/api/Token/Apply")
                .post(requestBody)
                .build();
        Call caall = client.newCall(loginRequest);
        RuyueDataPojo ruyueDataPojo = new RuyueDataPojo();
        try {
            //连接网络
            Response attentionResponse = caall.execute();
            if (attentionResponse.isSuccessful()){
                //获取返回的数据
                String data = attentionResponse.body().string();
                //测试
                System.out.println(data);
                RuyueLoginPojo ruyueLoginPojo = gson.fromJson(data, RuyueLoginPojo.class);
                ruyueDataPojo = ruyueLoginPojo.getData();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String publicKey = ruyueDataPojo.getKey().split("-")[0] +
                ruyueDataPojo.getKey().split("-")[1];
//        String.valueOf(ruyueDataPojo.getTokenId())
        Request login2Request = new Request.Builder()
                .url("http://www.gzruyue.org.cn:8090/api/User/LoginByPwd?token=301678518&data=92ad65c06ff9d569174997d98ae55ac48eee7c8f90e5bd79c67726b4e64d703f5df587773199de04c6d29f4a472a826a08e8b62e6c490e652074bda5793a1413")
//                .post(requestBody)
                .build();
        Call caaall = client.newCall(login2Request);
        try {
            //连接网络
            Response attention2Response = caaall.execute();
            if (attention2Response.isSuccessful()){
                //获取返回的数据
                String data = attention2Response.body().string();
                //测试
                System.out.println(data);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        loginCookie();
//        cookieJar.loadForRequest();
    }
}
