package com.lgt.nimbus.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lgt.nimbus.R;

public class LoginActivity extends AppCompatActivity {
    TextView tvRegisterUser;
    Button iv_user_login;
    EditText etUserName,etUserPassword;
    String Uname,Upass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // init
        tvRegisterUser = findViewById(R.id.tvRegisterUser);
        iv_user_login = findViewById(R.id.iv_user_login);
        etUserName = findViewById(R.id.etUserName);
        etUserPassword = findViewById(R.id.etUserPassword);

        tvRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRegistration();
            }
        });

        iv_user_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });
    }

    private void checkLogin() {
        Uname = etUserName.getText().toString();
        Upass = etUserPassword.getText().toString();

        if (!Uname.isEmpty()){
            if (!Upass.isEmpty()){
                userLogin();
            }else{
                etUserPassword.setError("Please Enter Password!");
                etUserPassword.requestFocus();
            }
        }else{
            etUserName.setError("Please Enter Name!");
            etUserName.requestFocus();
        }
    }

    private void userLogin() {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        finishAffinity();
    }

    private void startRegistration() {
        startActivity(new Intent(LoginActivity.this,ActivityRegistration.class));
        finishAffinity();
    }
}