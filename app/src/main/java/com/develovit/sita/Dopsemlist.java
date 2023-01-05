//package com.develovit.sita;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.NotificationCompat;
//import androidx.core.app.NotificationManagerCompat;
//import androidx.core.app.TaskStackBuilder;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Intent;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import com.develovit.sita.Adapter.DospemAdapter;
//import com.develovit.sita.Models.DospemView;
//
//import java.util.ArrayList;
//
//public class Dopsemlist extends AppCompatActivity implements DospemAdapter.ItemPermintaanTAClickListener{
//    private static final String CHANNEL_ID = "test";
//    private NotificationManagerCompat notificationManagerMhsTA;
//    private Button buttonShow;
//    private RecyclerView rvMh;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dopsem);
//
//        rvMh = findViewById(R.id.rv_Mhs3);
//
//        DospemAdapter adapter = new DospemAdapter(getMhs());
//        adapter.setListener(this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//
//        rvMh.setLayoutManager(layoutManager);
//        rvMh.setAdapter(adapter);
//
////        notificationManagerMhsTA = NotificationManagerCompat.from(this);
////        createNotificationChannel();
////
////        buttonShow = findViewById(R.id.tambah);
////        buttonShow.setOnClickListener(new View.OnClickListener() {
////
////            @Override
////            public void onClick(View v) {
////                Intent resultIntent = new Intent(Dopsemlist.this, Sidanglist.class);
////                TaskStackBuilder stackBuilder = TaskStackBuilder.create(Dopsemlist.this);
////                stackBuilder.addNextIntentWithParentStack(resultIntent);
////                PendingIntent resultPendingIntent =
////                        stackBuilder.getPendingIntent(0,
////                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
////
////                NotificationCompat.Builder builder = new NotificationCompat.Builder(Dopsemlist.this, CHANNEL_ID)
////                        .setSmallIcon(R.drawable.backbtn)
////                        .setContentTitle("Info Penambahan Dosen")
////                        .setStyle(new NotificationCompat.BigTextStyle()
////                                .bigText("Penambahan Dosen Berhasil"))
////                        .setContentIntent(resultPendingIntent)
////                        .addAction(R.drawable.backbtn, "Lihat", resultPendingIntent)
////                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
////
////                notificationManagerMhsTA.notify(113, builder.build());
////            }
////        });
//
////        notificationManagerMhsTA = NotificationManagerCompat.from(this);
////        createNotificationChannel();
//
//    }
//
//    public ArrayList<DospemView> getMhs(){
//        ArrayList<DospemView> listPermintaanTA = new ArrayList<>();
//        listPermintaanTA.add(new DospemView(
//                null,
//                "089372919863",
//                "01297398266",
//                "Husnil Kamil M.T",
//                1
//        ));
//        listPermintaanTA.add(new DospemView(
//                null,
//                "089372919863",
//                "01297398266",
//                "Husnil Kamil M.T",
//                1
//        ));
//        listPermintaanTA.add(new DospemView(
//                null,
//                "089372919863",
//                "01297398266",
//                "Husnil Kamil M.T",
//                1
//        ));
//        listPermintaanTA.add(new DospemView(
//                null,
//                "089372919863",
//                "01297398266",
//                "Husnil Kamil M.T",
//                1
//        ));
//        listPermintaanTA.add(new DospemView(
//                null,
//                "089372919863",
//                "01297398266",
//                "Husnil Kamil M.T",
//                1
//
//        ));
//        listPermintaanTA.add(new DospemView(
//                null,
//                "089372919863",
//                "01297398266",
//                "Husnil Kamil M.T",
//                1
//        ));
//        listPermintaanTA.add(new DospemView(
//                null,
//                "089372919863",
//                "01297398266",
//                "Husnil Kamil M.T",
//                1
//        ));
//
//
//
//        return listPermintaanTA;
//    }
//
////    @Override
////    public void onItemAgendaClick(DospemView permintaan) {
////        Intent detailIntent = new Intent (this,DetailSeminar.class);
////        detailIntent.putExtra("NAMA_MHS2", permintaan.getNama2());
////        detailIntent.putExtra("JUDUL2", permintaan.getJudul2());
////        detailIntent.putExtra("DOSPENG2", permintaan.getDospem2());
////        startActivity(detailIntent);
////    }
//
////    private void createNotificationChannel() {
////        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
////            CharSequence name = "Notifikasi";
////            String description = "Notifikasi Sidang TA Bertambah";
////            int importance = NotificationManager.IMPORTANCE_DEFAULT;
////            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
////            channel.setDescription(description);
////            notificationManagerMhsTA.createNotificationChannel(channel);
////        }
////    }
//
//}