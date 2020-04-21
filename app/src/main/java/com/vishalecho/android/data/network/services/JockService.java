package com.vishalecho.android.data.network.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JockService {
    private static final String URL = "https://api.icndb.com/jokes/";
    private JockApi mJockApi;
    private static JockService mInstance;

    public static JockService getInstance() {
        if (mInstance == null) {
            mInstance = new JockService();
        }
        return mInstance;
    }

    private JockService() {
        Retrofit mRetrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(URL).build();
        mJockApi = mRetrofit.create(JockApi.class);
    }

    public JockApi getJockApi() {
        return mJockApi;
    }
}
