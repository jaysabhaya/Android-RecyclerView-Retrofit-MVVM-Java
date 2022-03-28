package com.jay.java.recyclerviewretrofitmvvm.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.jay.java.recyclerviewretrofitmvvm.R;
import com.jay.java.recyclerviewretrofitmvvm.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvUser;
    UserAdapter userAdapter;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initObserver();
        viewModel.onGetUserDataApi();
    }

    private void initView() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        rvUser = findViewById(R.id.rv_user);
    }

    private void initObserver() {
        viewModel.mutUserResponse.observe(this, user -> {
            if (user != null) {
                userAdapter = new UserAdapter(MainActivity.this, user);
                rvUser.setAdapter(userAdapter);
            }
        });

        viewModel.mutResponseError.observe(this, message -> {
            if (message != null) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

}