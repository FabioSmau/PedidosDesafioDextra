package com.desafio.dextra.remote;

import com.desafio.dextra.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static Retrofit instance;

    public static synchronized Retrofit getInstance() {
        if (instance == null) {
            createRetrofit();
        }
        return instance;
    }

    private static void createRetrofit() {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BuildConfig.URL_WEBSERVICE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());


        if (BuildConfig.DEBUG) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();

           builder.client(client);
        }

        instance = builder.build();
    }

}
