package com.example.douyinapp.utils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class MyIntercept implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl build = request.url()
                .newBuilder()//公共参数
                .build();
        Request requestNew = request.newBuilder()
                .url(build)
                .build();
        return chain.proceed(requestNew);
    }
}
