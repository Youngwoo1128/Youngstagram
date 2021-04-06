package com.mac_available.youngstagram.bottomtab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mac_available.youngstagram.R;

import java.util.ArrayList;

public class MyPageGridRecyclerAdapter extends RecyclerView.Adapter<MyPageGridRecyclerAdapter.VH> {

    Context context;
    ArrayList<Integer> items;

    public MyPageGridRecyclerAdapter(Context context, ArrayList<Integer> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(context).inflate(R.layout.layout_item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(context).load(items.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder {
        ImageView imageView;
        public VH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_image_recycler);
        }
    }
}
