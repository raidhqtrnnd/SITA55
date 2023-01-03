package com.develovit.sita;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.TaskStackBuilder;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.develovit.sita.datamodel.LoginResponse;
import com.develovit.sita.datamodel.LogoutResponse;
import com.develovit.sita.retrofit.StoryClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Calendar;
import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends AppCompatActivity {
    private Button btntrig, btnLogout;
    SharedPreferences sharedPref;


    //
//    @SuppressLint("UnspecifiedImmutableFlag")
//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btntrig = findViewById(R.id.token2);
        btnLogout = findViewById(R.id.btn_logout);

        sharedPref = getSharedPreferences("Pref", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");

        btnLogout.setOnClickListener(v -> {
            logout();
        });


        btntrig.setOnClickListener(view -> {
            FirebaseMessaging.getInstance().getToken()
                    .addOnCompleteListener(new OnCompleteListener<String>() {
                        @Override
                        public void onComplete(@NonNull Task<String> task) {
                            if (!task.isSuccessful()) {
                                Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                                return;
                            }

                            // Get new FCM registration token
                            String token = task.getResult();

                            // Log and toast
                            Log.d(TAG, token);
                            Toast.makeText(Home.this, token, Toast.LENGTH_SHORT).show();
                        }
                    });


//
//        notificationManagerMhsTA = NotificationManagerCompat.from(this);
//        createNotificationChannel();
//
//        btntrig = findViewById(R.id.seminarnotif);
//        btntrig.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent resultIntent = new Intent(Home.this, Seminarlist.class);
//                TaskStackBuilder stackBuilder = TaskStackBuilder.create(Home.this);
//                stackBuilder.addNextIntentWithParentStack(resultIntent);
//                PendingIntent resultPendingIntent =
//                        stackBuilder.getPendingIntent(0,
//                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
//
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(Home.this, CHANNEL_ID)
//                        .setSmallIcon(R.drawable.backbtn)
//                        .setContentTitle("Info Penambahan Seminar")
//                        .setStyle(new NotificationCompat.BigTextStyle()
//                                .bigText("Raidha mengajukan permintaan seminar"))
//                        .setContentIntent(resultPendingIntent)
//                        .addAction(R.drawable.backbtn, "Lihat", resultPendingIntent)
//                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//                notificationManagerMhsTA.notify(115, builder.build());
//            }
        });
    }
//
//        notificationManagerMhsTA = NotificationManagerCompat.from(this);
//        createNotificationChannel();


    public void sidang0(View view) {
        Intent sidang0 = new Intent(this, Sidanglist.class);
        startActivity(sidang0);
    }

    public void seminar0(View view) {
        Intent seminar0 = new Intent(this, Seminarlist.class);
        startActivity(seminar0);
    }

    public void Mhs0(View view) {
        Intent Mhs0 = new Intent(this, MainActivity.class);
        startActivity(Mhs0);
    }

    public void ta0(View view) {
        Intent ta0 = new Intent(this, JadwalSidang.class);
        startActivity(ta0);
    }
//
//    private void createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CharSequence name = "Notifikasi";
//            String description = "Notifikasi Seminar TA Bertambah";
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
//            channel.setDescription(description);
//            notificationManagerMhsTA.createNotificationChannel(channel);
//        }
//    }
//


    private void logout() {

        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        StoryClient client = retrofit.create(StoryClient.class);

        Call<LogoutResponse> call = client.logout("Bearer" +sharedPref.getString("TOKEN", ""));

        call.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(Home.this, "Logout Berhasil", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.clear();
                    editor.apply();

                    Intent intent = new Intent(Home.this, Login.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finishAffinity();
                } else {
                    Toast.makeText(Home.this, "Logout gagal", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                Toast.makeText(Home.this, "Gagal Logout", Toast.LENGTH_SHORT).show();

            }
        });
    }

}

