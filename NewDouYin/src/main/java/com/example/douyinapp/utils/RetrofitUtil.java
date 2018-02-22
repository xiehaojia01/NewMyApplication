package com.example.douyinapp.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by ZhangPengFei.
 * Email: 1271396448@qq.com
 * data: 2018/1/12
 */

public class RetrofitUtil {
    public static Retrofit instance;
    private Retrofit retrofit;

/*   *
     * 封装好的拼接常用域名的方法
     *
     * @param baseurl*/

    public static Retrofit getInstance(String baseurl){
        if(instance==null){
            synchronized (RetrofitUtil.class){
                if(instance==null){

                  /*    自定义OkHttp请求
                      封装拦截器*/

                    OkHttpClient httpClient = new OkHttpClient.Builder()
                            .addInterceptor(new MyIntercept())
                            .build();
                    instance = new Retrofit.Builder()
                            .baseUrl(baseurl)
                            .client(httpClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return instance;
    }
}
