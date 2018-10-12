/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: OkHttpHelper.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.utils.http;

import okhttp3.*;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * OkHTTP基本方法实现类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
public class OkHttpHelper {
    private final Map<String, List<Cookie>> cookiesMap = new HashMap<>();
    private CookieJar cookieJar = new CookieJar() {
        @Override
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            //移除相同的url的Cookie
            String host = httpUrl.host();
            List<Cookie> cookiesList = cookiesMap.get(host);
            if (cookiesList != null) {
                cookiesMap.remove(host);
            }
            //再重新添加
            cookiesMap.put(host, list);
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            List<Cookie> cookiesList = cookiesMap.get(httpUrl.host());
            //注：这里不能返回null，否则会报NULLException的错误。
            //原因：当Request 连接到网络的时候，OkHttp会调用loadForRequest()
            return cookiesList != null ? cookiesList : new ArrayList<>();
        }
    };

    public OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)
                .build();
    }

    public Request createRequest(String url, Method method, @Nullable RequestBody requestBody) {
        Request request = null;
        switch (method) {
            case GET:
                request = new Request.Builder()
                        .url(url)
                        .build();
                break;
            case POST:
                request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();
                break;
            default:
                request = new Request.Builder()
                        .url(url)
                        .build();
                break;
        }
        return request;
    }

    public Response getResponseAsync(OkHttpClient client, Request request)
            throws IOException {
        return client.newCall(request).execute();
    }

}
