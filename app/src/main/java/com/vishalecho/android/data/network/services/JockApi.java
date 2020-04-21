package com.vishalecho.android.data.network.services;

import com.vishalecho.android.data.network.model.JockResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JockApi {

    @GET("random")
    Call<JockResponse> getRandomJock();
}
