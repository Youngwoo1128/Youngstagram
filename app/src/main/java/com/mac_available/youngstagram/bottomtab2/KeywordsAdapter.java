package com.mac_available.youngstagram.bottomtab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mac_available.youngstagram.R;

public class KeywordsAdapter extends RecyclerView.Adapter {

    String[] keywords;
    Context context;

    public KeywordsAdapter(String[] keywords, Context context) {
        this.keywords = keywords;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(context).inflate(R.layout.recycler_item_keyword, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((VH)holder).tvKeyword.setText(keywords[position]);
    }

    @Override
    public int getItemCount() {
        return keywords.length;
    }

    class VH extends RecyclerView.ViewHolder {
        TextView tvKeyword;
        public VH(@NonNull View itemView) {
            super(itemView);
            tvKeyword = itemView.findViewById(R.id.tv_keyword);
        }
    }
}
