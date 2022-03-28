package com.jay.java.recyclerviewretrofitmvvm.network;

import com.jay.java.recyclerviewretrofitmvvm.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/users?page=2")
    Call<UserResponse> getUserData();
}
