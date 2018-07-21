package com.example.guitorio.roompersistancelibrary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class UserDisplayAdapter extends RecyclerView.Adapter<UserDisplayAdapter.UserDisplayViewHolder>{

    private Context context;
    public List<User> newUserModels;

    public UserDisplayAdapter(Context context, List<User> newUserModels) {
        this.context = context;
        this.newUserModels = newUserModels;
    }

    @NonNull
    @Override
    public UserDisplayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_users_display,parent,false);

        return new UserDisplayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserDisplayViewHolder holder, int position) {

        final User user = newUserModels.get(position);

        holder.tvUserId.setText(Integer.toString(user.getId()));
        holder.tvUserName.setText(user.getName());
        holder.tvUserEmail.setText(user.getEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, user.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return newUserModels.size();
    }

    public class UserDisplayViewHolder extends RecyclerView.ViewHolder{

        public TextView tvUserId,tvUserName,tvUserEmail;

        public UserDisplayViewHolder(View itemView) {
            super(itemView);

            tvUserId = itemView.findViewById(R.id.tvUserId);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvUserEmail = itemView.findViewById(R.id.tvUserEmail);
        }
    }

}
