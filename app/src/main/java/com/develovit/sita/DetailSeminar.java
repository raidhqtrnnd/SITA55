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

    String namaMhs4, nimMhs4, judul4, jadwal5, file1;
    TextView textNamaMhsDetail4,textfile1, jadwaltext, textDospengDetail4, textJudulDetail4,  textJudulabstrak;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar);

        Intent detailIntent = getIntent();
        if (detailIntent != null) {
            namaMhs4 = detailIntent.getStringExtra("NAMA_MHS4");
            textNamaMhsDetail4 = findViewById(R.id.nama4);
            textNamaMhsDetail4.setText(namaMhs4);

            nimMhs4 = detailIntent.getStringExtra("NIMMHS4");
            textDospengDetail4 = findViewById(R.id.nimMhs4);
            textDospengDetail4.setText(nimMhs4);

            judul4 = detailIntent.getStringExtra("JUDUL4");
            textJudulDetail4 = findViewById(R.id.judul4);
            textJudulDetail4.setText(judul4);

            judul4 = detailIntent.getStringExtra("JUDUL4");
            textJudulabstrak = findViewById(R.id.abstrak4);
            textJudulabstrak.setText(judul4);

            jadwal5= detailIntent.getStringExtra("JADWAL");
            jadwaltext = findViewById(R.id.jadwal5);
            jadwaltext.setText(jadwal5);

            file1 = detailIntent.getStringExtra("FILE1");
            textfile1 = findViewById(R.id.file2);
            textfile1.setText(file1);
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
                        .setSmallIcon(R.drawable.ic_baseline_auto_awesome_24)
                        .setContentTitle("Info Penambahan Dospeng")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("Penambahan Dosen Penguji sukses"))
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.backbtn, "Lihat", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationManagerMhsTA.notify(111, builder.build());
            }
        });

        notificationManagerMhsTA = NotificationManagerCompat.from(this);
        createNotificationChannel();

 }

//    public void onButtonKirimClick(View view) {
//        Intent i = new Intent(this, Dopsemlist.class);
//        startActivity(i);
//    }
//
//    public void dospeng(View view) {
//        Intent detailsIntent= new Intent (this, Dopsemlist.class);
//        startActivity(detailsIntent);
//    }

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