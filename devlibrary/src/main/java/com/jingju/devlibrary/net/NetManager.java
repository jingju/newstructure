package com.jingju.devlibrary.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zgj on 2018/4/16.
 */

public class NetManager {
    private static final long DEFALUT_TIME_OUT = 2;


    private static volatile NetManager Instance = null;

    private OkHttpClient.Builder oKBuilder=null;
    private Retrofit rf =null;

    private NetManager() {
                //初始化一些基本配置
                oKBuilder = new OkHttpClient().newBuilder()
                .connectTimeout(DEFALUT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFALUT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFALUT_TIME_OUT, TimeUnit.SECONDS);


                //设置拦截器，单独封装成一个类
                


                //创建retrofitClient
                rf = new Retrofit.Builder()
                .baseUrl("")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static NetManager getInstance() {
        if (Instance == null) {
            synchronized (NetManager.class) {
                if (Instance == null) {
                    Instance = new NetManager();
                }
            }
        }
        return Instance;

    }


}
