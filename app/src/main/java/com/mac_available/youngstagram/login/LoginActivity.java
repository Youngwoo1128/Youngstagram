package com.mac_available.youngstagram.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class LoginActivity extends AppCompatActivity {
    EditText etId;
    String inputId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etId = findViewById(R.id.edit_text_login_activity_id);
    }

    public void clickAddAccount(View view) {
        startActivity(new Intent(this, AccountActivity.class));
        finish();
    }

    public void clickLogIn(View view) {
        inputId = etId.getText().toString();

        if (inputId == null || inputId.equals("")){
            Toast.makeText(this, "아이디를 확인해주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        RetrofitHelper.getRetrofitInstanceScalars().create(RetrofitService.class).loadUserData("userId").enqueue(new Callback<UserVO>() {
            @Override
            public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                G.myProfile = response.body();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<UserVO> call, Throwable t) {

            }
        });
    }

    public void clickGogo(View view) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}