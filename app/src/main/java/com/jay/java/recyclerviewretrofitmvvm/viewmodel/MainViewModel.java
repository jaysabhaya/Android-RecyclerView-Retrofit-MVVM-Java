package com.jay.java.recyclerviewretrofitmvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jay.java.recyclerviewretrofitmvvm.model.UserResponse;
import com.jay.java.recyclerviewretrofitmvvm.network.ApiService;
import com.jay.java.recyclerviewretrofitmvvm.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    public MutableLiveData<UserResponse> mutUserResponse = new MutableLiveData<>();
    public MutableLiveData<String> mutResponseError = new MutableLiveData<>();

    public void onGetUserDataApi() {
        ApiService apiServices = RetrofitInstance.getRetrofit().create(ApiService.class);
        Call<UserResponse> call = apiServices.getUserData();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                if (userResponse != null){
                    mutUserResponse.postValue(userResponse);
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                mutResponseError.postValue(t.getLocalizedMessage());
            }
        });

    }

}