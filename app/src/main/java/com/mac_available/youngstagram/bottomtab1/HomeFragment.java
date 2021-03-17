package com.mac_available.youngstagram.bottomtab1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.mac_available.youngstagram.MainActivity;
import com.mac_available.youngstagram.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<HomeItemVo> items;
    HomeRecyclerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = view.findViewById(R.id.toolbar_home_fragment);
        ((MainActivity)getContext()).setSupportActionBar(toolbar);
        ((MainActivity)getContext()).getSupportActionBar().setDisplayShowTitleEnabled(true);

        recyclerView = view.findViewById(R.id.recycler_home_fragment);
        items = new ArrayList<>();
        loadItems();
        adapter = new HomeRecyclerAdapter(getContext(), items);
        recyclerView.setAdapter(adapter);

    }
    public void loadItems(){
        items.add(new HomeItemVo(R.drawable.instaprofile01, "chuuu", R.drawable.instaprofile01));
        items.add(new HomeItemVo(R.drawable.instaprofile02, "flowergirl", R.drawable.instaprofile02));
        items.add(new HomeItemVo(R.drawable.instaprofile02, "flowergirl", R.drawable.instaprofile03));
        items.add(new HomeItemVo(R.drawable.instaprofile04, "jongsuk", R.drawable.instaprofile04));
        items.add(new HomeItemVo(R.drawable.instaprofile04, "jongsuk", R.drawable.instaprofile05));
        items.add(new HomeItemVo(R.drawable.instaprofile06, "miyao", R.drawable.instaprofile06));
        items.add(new HomeItemVo(R.drawable.instaprofile01, "chuuu", R.drawable.instaprofile07));
        items.add(new HomeItemVo(R.drawable.instaprofile06, "miyao", R.drawable.instaprofile08));
        items.add(new HomeItemVo(R.drawable.instaprofile06, "miyao", R.drawable.instaprofile09));
        items.add(new HomeItemVo(R.drawable.instaprofile04, "jongsuk", R.drawable.instaprofile10));
        items.add(new HomeItemVo(R.drawable.instaprofile04, "jongsuk", R.drawable.instaprofile11));
    }
}
