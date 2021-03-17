package com.mac_available.youngstagram.bottomtab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.mac_available.youngstagram.MainActivity;
import com.mac_available.youngstagram.R;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    Toolbar toolbar;
    CardView searchBar;
    RecyclerView recyclerKeywords;
    RecyclerView recyclerImages;
    KeywordsAdapter keywordsAdapter;
    ArrayList<Integer> imgItems;
    ImageAdapter imageAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = view.findViewById(R.id.toolbar_search_fragment);
        ((MainActivity)getContext()).setSupportActionBar(toolbar);
        ((MainActivity)getContext()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        searchBar = view.findViewById(R.id.search_box);
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SearchActivity.class));
            }
        });

        recyclerKeywords = view.findViewById(R.id.recycler_search_fragment_keyword);
        String[] keywords = getContext().getResources().getStringArray(R.array.search_fragment_keyword);
        keywordsAdapter = new KeywordsAdapter(keywords, getContext());
        recyclerKeywords.setAdapter(keywordsAdapter);

        recyclerImages = view.findViewById(R.id.recycler_search_fragment_image);
        imgItems = new ArrayList<>();
        loadImg();
        imageAdapter = new ImageAdapter(getContext(), imgItems);
        recyclerImages.setAdapter(imageAdapter);


    }

    public void loadImg(){
        imgItems.add(R.drawable.instaprofile01);
        imgItems.add(R.drawable.instaprofile02);
        imgItems.add(R.drawable.instaprofile03);
        imgItems.add(R.drawable.instaprofile04);
        imgItems.add(R.drawable.instaprofile05);
        imgItems.add(R.drawable.instaprofile06);
        imgItems.add(R.drawable.instaprofile07);
        imgItems.add(R.drawable.instaprofile08);
        imgItems.add(R.drawable.instaprofile09);
        imgItems.add(R.drawable.instaprofile10);
        imgItems.add(R.drawable.instaprofile11);
    }

}
