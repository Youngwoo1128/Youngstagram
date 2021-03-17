package com.mac_available.youngstagram.bottomtab2;

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

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.VH> {

    Context context;
    ArrayList<Integer> imgItems;

    public ImageAdapter(Context context, ArrayList<Integer> imgItems) {
        this.context = context;
        this.imgItems = imgItems;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(context).inflate(R.layout.layout_item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(context).load(imgItems.get(position)).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return imgItems.size();
    }

    class VH extends RecyclerView.ViewHolder{
        ImageView ivImage;
        public VH(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image_recycler);
        }
    }
}
