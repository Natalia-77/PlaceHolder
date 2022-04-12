package com.example.placeholder.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceHolderNetwork {

    private static PlaceHolderNetwork mInstance;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private Retrofit mRetrofit;

    private PlaceHolderNetwork(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

    }
    public static PlaceHolderNetwork getInstance() {
        if (mInstance == null) {
            mInstance = new PlaceHolderNetwork();
        }
        return mInstance;
    }

    public PlaceHolderApi getJSONApi() {
        return mRetrofit.create(PlaceHolderApi.class);
    }
}
