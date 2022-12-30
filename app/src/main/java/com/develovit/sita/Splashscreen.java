package com.develovit.sita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splashscreen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
                if (!sharedPref.getString("TOKEN", "").isEmpty()) {
                    Intent Intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(Intent);
                }else{
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                }
            }
        }, 3000L); //3000 L = 3 detik
    }
}