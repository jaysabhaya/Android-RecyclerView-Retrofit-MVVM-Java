package com.jay.java.recyclerviewretrofitmvvm.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jay.java.recyclerviewretrofitmvvm.R;
import com.jay.java.recyclerviewretrofitmvvm.model.UserResponse;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    UserResponse userResponse;
    Context context;

    public UserAdapter(Context context, UserResponse userResponse) {
        this.context = context;
        this.userResponse = userResponse;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(userResponse.getListData().get(position).getFirstName());
        holder.tvEmail.setText(userResponse.getListData().get(position).getEmail());
        Glide.with(context).load(userResponse.getListData().get(position).getAvatar()).into(holder.ivProfile);

    }

    @Override
    public int getItemCount() {
        if (this.userResponse != null) {
            return this.userResponse.getListData().size();
        }
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvEmail;
        ImageView ivProfile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvName = itemView.findViewById(R.id.tv_name);
            ivProfile = itemView.findViewById(R.id.iv_profile);
        }
    }

}