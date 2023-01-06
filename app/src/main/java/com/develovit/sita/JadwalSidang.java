package com.develovit.sita;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class JadwalSidang extends AppCompatActivity {

    CircleImageView image;
    TextView judul,nama,dospem;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jadwal_sidang);

        judul = findViewById(R.id.judul);
        nama = findViewById(R.id.nama);
        dospem = findViewById(R.id.dospem);
        image = findViewById(R.id.profile_image);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();

        judul.setText(bundle.getString("judul"));
        nama.setText(bundle.getString("nama"));
        dospem.setText(bundle.getString("dospem"));


        if (bundle.getString("nama").equals("Silvia")){

        }else {
            image.setImageDrawable(getResources().getDrawable(R.drawable.profil2));
        }
    }
}