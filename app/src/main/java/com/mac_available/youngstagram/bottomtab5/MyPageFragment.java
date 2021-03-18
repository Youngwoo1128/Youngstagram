package com.mac_available.youngstagram.bottomtab5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.mac_available.youngstagram.R;

import static android.app.Activity.RESULT_OK;

public class MyPageFragment extends Fragment {
    ImageView imageView;
    Uri imageUri;

    TextView myFollower, numberMyFollower, myFollowing, numberMyFollowing;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myFollower = view.findViewById(R.id.myFollower);
        numberMyFollower = view.findViewById(R.id.number_myFollower);
        myFollowing = view.findViewById(R.id.myFollowing);
        numberMyFollowing = view.findViewById(R.id.number_myFollowing);

        myFollower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyFollower.class);
                startActivity(intent);
            }
        });

        numberMyFollower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyFollower.class);
                startActivity(intent);
            }
        });

        myFollowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyFollowing.class);
                startActivity(intent);
            }
        });

        numberMyFollowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyFollowing.class);
                startActivity(intent);
            }
        });

        imageView = view.findViewById(R.id.my_photo);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 10);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10 && resultCode == RESULT_OK){
            imageUri = data.getData();
            Glide.with(this).load(imageUri).into(imageView);
        }
    }
}
