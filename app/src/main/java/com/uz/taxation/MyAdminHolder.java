package com.uz.taxation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdminHolder extends RecyclerView.ViewHolder {
    ImageView imageadmin;
    TextView mTitle,mDesc;
    public MyAdminHolder(@NonNull View itemView) {
        super(itemView);

        this.imageadmin = itemView.findViewById(R.id.imageadmin);
        this.mTitle = itemView.findViewById(R.id.title);
        this.mDesc = itemView.findViewById(R.id.tvdesc);
    }
}
