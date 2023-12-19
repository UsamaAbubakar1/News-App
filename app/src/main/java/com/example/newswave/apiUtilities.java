package com.example.newswave;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiUtilities {

    private static Retrofit retrofit = null;

    public static apiInterface getapiInterface() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(apiInterface.Base_URl).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(apiInterface.class);
    }
}
