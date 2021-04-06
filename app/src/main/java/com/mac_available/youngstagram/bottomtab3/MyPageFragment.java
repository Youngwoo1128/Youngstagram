package com.mac_available.youngstagram.bottomtab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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

public class MyPageFragment extends Fragment {

    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<Integer> items;
    MyPageGridRecyclerAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = view.findViewById(R.id.toolbar_my_page);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        recyclerView = view.findViewById(R.id.recycler_my_page_image);
        items = new ArrayList<>();
        addItems();
        adapter = new MyPageGridRecyclerAdapter(getContext(), items);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.option_menu_my_page, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void addItems(){
        items.add(R.drawable.instaprofile01);
        items.add(R.drawable.instaprofile02);
        items.add(R.drawable.instaprofile03);
        items.add(R.drawable.instaprofile04);
        items.add(R.drawable.instaprofile05);
        items.add(R.drawable.instaprofile06);
        items.add(R.drawable.instaprofile07);
        items.add(R.drawable.instaprofile08);
        items.add(R.drawable.instaprofile09);
        items.add(R.drawable.instaprofile10);
    }
}
