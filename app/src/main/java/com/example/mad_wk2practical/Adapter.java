package com.example.mad_wk2practical;

import android.content.Context;

import androidx.annotation.NonNull;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    ArrayList<User> users;
    Context context;
    ImageView uProfilePic;

    public Adapter(Context context, ArrayList<User> userList) {
        this.context = context;
        this.users = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == 0) {
            view = inflater.inflate(R.layout.user_row, parent, false);
        } else {
            view = inflater.inflate(R.layout.user_row2, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        User u = users.get(position);
        holder.name.setText(u.name);
        holder.desc.setText(u.description);
        uProfilePic = holder.userProfilePic.findViewById(R.id.userProfilePic);

        uProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Profile");
                builder.setMessage(u.name);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int id){
                        Intent i = new Intent(context, MainActivity.class);
                        i.putExtra("Name", u.name);
                        i.putExtra("Description", u.description);
                        i.putExtra("Followed", u.followed);

                        context.startActivity(i);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialog, int id){
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public int getItemViewType(int position) {
        String name = users.get(position).getUserName();
        int endDigit = Integer.parseInt(name.substring(name.length() - 1));

        if (endDigit == 7) {
            return 1;
        } else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView userProfilePic;

        public TextView name, desc;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.desc);
            userProfilePic = itemView.findViewById(R.id.userProfilePic);
        }
    }

}