package com.develovit.sita;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import com.develovit.sita.datamodel.LoginResponse;
import com.develovit.sita.retrofit.StoryClient;

import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    EditText edittextusername, editpassword;
    Button login_btn;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        login_btn = findViewById(R.id.buttonLogin);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekLogin();
            }
        });
    }
    //login
    //198201182008121002

    public void cekLogin() {
        edittextusername = findViewById(R.id.editUsername);
        editpassword = findViewById(R.id.editPassword);
        login_btn = findViewById(R.id.buttonLogin);

        String username = edittextusername.getText().toString();
        String password = editpassword.getText().toString();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient.Builder().build())
                        .build();

                StoryClient client = retrofit.create(StoryClient.class);

                Call<LoginResponse> call = client.login(username, password);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        if (response.isSuccessful()) {
                            LoginResponse loginResponse = response.body();
                            if (loginResponse != null && Objects.equals(loginResponse.getStatus(), "success")) {
                                Toast.makeText(Login.this, "Berhasil Login", Toast.LENGTH_SHORT).show();

                                String token = loginResponse.getAuthorisation().getToken();

                                SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putString("TOKEN", token);

                                editor.apply();


                                Intent Intent = new Intent(Login.this, Home.class);
                                startActivity(Intent);
                            }
                        } else {
                            Log.e("LoginActivity", response.message());
                            Toast.makeText(Login.this, "Username/password anda salah", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(Login.this, "Gagal login", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}

