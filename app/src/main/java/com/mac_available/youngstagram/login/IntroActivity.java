package com.mac_available.youngstagram.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.mac_available.youngstagram.G;
import com.mac_available.youngstagram.MainActivity;
import com.mac_available.youngstagram.R;
import com.mac_available.youngstagram.library.RetrofitHelper;
import com.mac_available.youngstagram.library.RetrofitService;
import com.mac_available.youngstagram.valueobject.UserVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IntroActivity extends AppCompatActivity {

    Intent intent;
    String userId;
    TextView tvLogo;
    Animation logoAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        logoAnim = AnimationUtils.loadAnimation(this, R.anim.logo_anim);
        tvLogo = findViewById(R.id.logo_intro_activity);
        tvLogo.startAnimation(logoAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);

                userId = sharedPreferences.getString("userId", null);
                if (userId == null) {
                    intent = new Intent(IntroActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    startApp();
                }
            }
        }, 1000);
    }


    //SharedPreferences 에 저장된 유저 ID에 따라 DB에 저장된 유저의 정보들을 가져오는 작업
    public void startApp() {
        Retrofit retrofit = RetrofitHelper.getRetrofitInstanceGson();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<UserVO> call = retrofitService.loadUserData(userId);
        call.enqueue(new Callback<UserVO>() {
            @Override
            public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                G.myProfile = response.body();
                intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<UserVO> call, Throwable t) {
                Toast.makeText(IntroActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                startApp();
            }
        });
    }
}