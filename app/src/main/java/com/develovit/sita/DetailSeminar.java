package com.develovit.sita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.TaskStackBuilder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailSeminar extends AppCompatActivity {
    private static final String CHANNEL_ID = "test";
    private NotificationManagerCompat notificationManagerMhsTA;
    private Button buttonShow;

    String namaMhs, dospeng, judul;
    TextView textNamaMhsDetail, textDospengDetail, textJudulDetail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar);

        Intent detailIntent = getIntent();
        if (detailIntent != null) {
            namaMhs = detailIntent.getStringExtra("NAMA_MHS");
            textNamaMhsDetail = findViewById(R.id.nama);
            textNamaMhsDetail.setText(namaMhs);
            dospeng = detailIntent.getStringExtra("DOSPENG");
            textDospengDetail = findViewById(R.id.dospem);
            textDospengDetail.setText(dospeng);
            judul = detailIntent.getStringExtra("JUDUL");
            textJudulDetail = findViewById(R.id.judul);
            textJudulDetail.setText(judul);
        }


        notificationManagerMhsTA = NotificationManagerCompat.from(this);
        createNotificationChannel();

        buttonShow = findViewById(R.id.notifseminar);
        buttonShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(DetailSeminar.this, Seminarlist.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(DetailSeminar.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(DetailSeminar.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.backbtn)
                        .setContentTitle("Info Persetujuan Seminar TA")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("Penambahan Seminar TA disetujui"))
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.backbtn, "Lihat", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationManagerMhsTA.notify(111, builder.build());
            }
        });

        notificationManagerMhsTA = NotificationManagerCompat.from(this);
        createNotificationChannel();

 }

    public void onButtonKirimClick(View view) {
        Intent i = new Intent(this, Dopsemlist.class);
        startActivity(i);
    }

    public void dospeng(View view) {
        Intent detailsIntent= new Intent (this, Dopsemlist.class);
        startActivity(detailsIntent);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notifikasi";
            String description = "Notifikasi Seminar TA Bertambah";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManagerMhsTA.createNotificationChannel(channel);
        }
    }



}