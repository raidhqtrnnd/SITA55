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

public class DetailSidang extends AppCompatActivity {
    private static final String CHANNEL_ID = "test1";
    private NotificationManagerCompat notificationManagerMhsTA;
    private Button buttonShow;

    String namaMhs1, jadwal3, judul3, nimMhs, file;
    TextView textNamaMhsDetail1,textfile, textDospengDetail1, textJudulDetail1, textJudulabstrak, textJadwal ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sidang);


        Intent detailIntent = getIntent();
        if (detailIntent != null) {

            namaMhs1 = detailIntent.getStringExtra("NAMA_MHS1");
            textNamaMhsDetail1 = findViewById(R.id.nama11);
            textNamaMhsDetail1.setText(namaMhs1);

            nimMhs = detailIntent.getStringExtra("NIMMHS");
            textDospengDetail1 = findViewById(R.id.nimMhs11);
            textDospengDetail1.setText(nimMhs);

            judul3 = detailIntent.getStringExtra("JUDUL");
            textJudulDetail1 = findViewById(R.id.judul11);
            textJudulDetail1.setText(judul3);

            judul3 = detailIntent.getStringExtra("JUDUL");
            textJudulabstrak = findViewById(R.id.abstrak);
            textJudulabstrak.setText(judul3);

            jadwal3 = detailIntent.getStringExtra("JADWAL");
            textJadwal = findViewById(R.id.jadwal4);
            textJadwal.setText(jadwal3);

            file = detailIntent.getStringExtra("FILE");
            textfile = findViewById(R.id.file1);
            textfile.setText(file);



        }


//        notificationManagerMhsTA = NotificationManagerCompat.from(this);
//        createNotificationChannel();
//
//        buttonShow = findViewById(R.id.setuju);
//        buttonShow.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent resultIntent = new Intent(DetailSidang.this, Sidanglist.class);
//                TaskStackBuilder stackBuilder = TaskStackBuilder.create(DetailSidang.this);
//                stackBuilder.addNextIntentWithParentStack(resultIntent);
//                PendingIntent resultPendingIntent =
//                        stackBuilder.getPendingIntent(0,
//                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
//
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(DetailSidang.this, CHANNEL_ID)
//                        .setSmallIcon(R.drawable.backbtn)
//                        .setContentTitle("Info Sidang")
//                        .setStyle(new NotificationCompat.BigTextStyle()
//                                .bigText("Penambahan Sidang disetujui"))
//                        .setContentIntent(resultPendingIntent)
//                        .addAction(R.drawable.backbtn, "Lihat", resultPendingIntent)
//                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//                notificationManagerMhsTA.notify(112, builder.build());
//            }
//        });
//
//        notificationManagerMhsTA = NotificationManagerCompat.from(this);
//        createNotificationChannel();
//
}



//    public void dospeng(View view) {
//        Intent dospenglist= new Intent (this, Dopsemlist.class);
//        startActivity(dospenglist);
//    }

//    private void createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CharSequence name = "Notifikasi";
//            String description = "Notifikasi Sidang TA Bertambah";
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
//            channel.setDescription(description);
//            notificationManagerMhsTA.createNotificationChannel(channel);
//        }
//    }
}