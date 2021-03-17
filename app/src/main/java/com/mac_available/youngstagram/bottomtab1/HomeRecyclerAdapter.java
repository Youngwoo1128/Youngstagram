package com.mac_available.youngstagram.bottomtab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mac_available.youngstagram.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.VH> {

    Context context;
    ArrayList<HomeItemVo> items;

    public HomeRecyclerAdapter(Context context, ArrayList<HomeItemVo> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(context).inflate(R.layout.recycler_item_home_fragment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(context).load(items.get(position).profileImgSrc).into(holder.civProfile);
        Glide.with(context).load(items.get(position).uploadImgSrc).into(holder.ivImage);
        holder.tvId.setText(items.get(position).id);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{
        CircleImageView civProfile;
        TextView tvId;
        ImageView ivImage;
        ImageView icFavorite, icMessage, icSend;
        public VH(@NonNull View itemView) {
            super(itemView);
            civProfile = itemView.findViewById(R.id.civ_profile_home_fragment);
            tvId = itemView.findViewById(R.id.tv_id_home_fragment);
            ivImage = itemView.findViewById(R.id.iv_image_home_fragment);
            icFavorite = itemView.findViewById(R.id.ic_favorite_home_fragment);
            icMessage = itemView.findViewById(R.id.ic_message_home_fragment);
            icSend = itemView.findViewById(R.id.ic_send_home_fragment);
        }
    }

}
