package com.example.moviedatenew.utils;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviedatenew.MainActivity;
import com.example.moviedatenew.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInPage extends AppCompatActivity implements View.OnClickListener {
    private static int SPLASH_TIME_OUT = 4000;

    public TextView editTextemail, editTextpassword;
    Intent intent ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);

        editTextemail = findViewById(R.id.editTextemail);
        editTextpassword = findViewById(R.id.editTextpassword);
        findViewById(R.id.buttonsignup).setOnClickListener(this);
        findViewById(R.id.buttonregister).setOnClickListener(this);

    }

    private void userLogin() {

        String email = editTextemail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextemail.setError("Email is required");
            editTextemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextemail.setError("Enter a valid email");
            editTextemail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextpassword.setError("Password required");
            editTextpassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextpassword.setError("Password should be atleast 6 character long");
            editTextpassword.requestFocus();
            return;
        }
        final LoginRequest loginRequest = new LoginRequest();
        loginRequest.email = email;
        loginRequest.password = password;
        Call<LoginResponse> call = RetrofitClient
                .getInstance().getApi().userLogin(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if (loginResponse != null) {
                    Toast.makeText(SignInPage.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SignInPage.this, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(SignInPage.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonsignup:
                userLogin();
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonregister:
                intent=new Intent(this, SignUp.class);
                startActivity(intent);
                break;
        }
    }
}
