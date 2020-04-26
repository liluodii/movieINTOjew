package com.example.moviedatenew.utils;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviedatenew.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    public EditText registeremail,registerpwd;
    Button signup,rsignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        registeremail = findViewById(R.id.registerEmail);
        registerpwd = findViewById(R.id.registerPassword);
        signup = findViewById(R.id.signup);
        rsignin = findViewById(R.id.rsignin);
        findViewById(R.id.signup).setOnClickListener(this);
        findViewById(R.id.rsignin).setOnClickListener(this);
    }

        private void usersignup() {

            String email = registeremail.getText().toString().trim();
            String password = registerpwd.getText().toString().trim();

            if (email.isEmpty()) {
                registeremail.setError("Email is required");
                registeremail.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                registeremail.setError("Enter a valid email");
                registeremail.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                registerpwd.setError("Password required");
                registerpwd.requestFocus();
                return;
            }

            if (password.length() < 6) {
                registerpwd.setError("Password should be atleast 6 character long");
                registerpwd.requestFocus();
                return;
            }


            final RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.email = email;
            registerRequest.password = password;
            Call<RegisterResponse> call = RetrofitClient
                    .getInstance().getApi().usersignup(registerRequest);
            call.enqueue(new Callback<RegisterResponse>() {
                @Override
                public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                    RegisterResponse registerResponse = response.body();

                    if (registerResponse != null) {
                        Toast.makeText(SignUp.this, registerResponse.getMessage(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(SignUp.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<RegisterResponse> call, Throwable t) {
                    Toast.makeText(SignUp.this, t.getMessage(), Toast.LENGTH_LONG).show();

                }
            });

        }
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.signup:
                    usersignup();
                    break;
           case R.id.rsignin:
                startActivity(new Intent(this, SignInPage.class));
                break;
            }
        }

    }
