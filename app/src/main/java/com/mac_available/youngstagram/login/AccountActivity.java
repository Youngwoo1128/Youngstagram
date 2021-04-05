package com.mac_available.youngstagram.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.accounts.Account;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
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

public class AccountActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText etId, etName;
    Boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        toolbar = findViewById(R.id.toolbar_account_activity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        etId = findViewById(R.id.edit_text_account_activity_id);
        etName = findViewById(R.id.edit_text_account_activity_name);
        etId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isChecked = false;
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) super.onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public void clickSave(View v) {
        String inputId = etId.getText().toString();
        String inputName = etName.getText().toString();
        if (isChecked == false) {
            Toast.makeText(this, "아이디 중복을 확인해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        if (inputId == null || inputId.equals("")) {
            Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        } else if (inputName == null || inputName.equals("")) {
            Toast.makeText(this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("잠시만 기다려 주십시오");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        UserVO userVO = new UserVO(inputId, inputName, null, null, null);
        RetrofitHelper.getRetrofitInstanceGson().create(RetrofitService.class).saveUserData(userVO).enqueue(new Callback<UserVO>() {
            @Override
            public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                SharedPreferences sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);
                sharedPreferences.edit().putString("userId", inputId).commit();
                G.myProfile = userVO;
                startActivity(new Intent(AccountActivity.this, MainActivity.class));
                progressDialog.dismiss();
                finish();
            }

            @Override
            public void onFailure(Call<UserVO> call, Throwable t) {

            }
        });
    }

    public void clickCheckId(View view) {
        String inputId = etId.getText().toString();
        RetrofitHelper.getRetrofitInstanceScalars().create(RetrofitService.class).checkUserId(inputId).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.equals("RESULT_OK")) {
                    new AlertDialog.Builder(AccountActivity.this).setMessage("사용하실 수 있는 아이디 입니다.\n사용하시겠습니까?").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            isChecked = true;
                        }
                    }).setNegativeButton("아니오", null).create().show();
                } else {
                    Toast.makeText(AccountActivity.this, "이미 존재하는 아이디입니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}