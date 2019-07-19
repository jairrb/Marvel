package com.manamob.marvel.data.network;

import com.facebook.stetho.BuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    public static final String URL_BASE = "https://gateway.marvel.com:443/v1/public/";
    public static final String PUBLIC_KEY = "26069a7b86db66d3813813d23a06b997";
    public static final String PRIVATE_KEY = "6465564cda9c3dafa03e81eecc9c918e40c2e08a";

    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){

        if(retrofit == null){

            // configurações da conexão
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.readTimeout(30   , TimeUnit.SECONDS);
            httpClient.connectTimeout(30, TimeUnit.SECONDS);
            httpClient.writeTimeout(30  , TimeUnit.SECONDS);

            // Se for Debug habilitamos os logs
            /*if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(httpLoggingInterceptor);
                httpClient.addNetworkInterceptor(new StethoInterceptor());
            }
            */

            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }

        return retrofit;
    }

    public static API getApiService(){
        return getRetrofit().create(API.class);
    }
}