package com.develovit.sita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.develovit.sita.datamodel.DetailMhsTaResponse;
import com.develovit.sita.datamodel.ListLogbookResponse;
import com.develovit.sita.datamodel.LogbooksItem;
import com.develovit.sita.retrofit.StoryClient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailMahasiswaTA extends AppCompatActivity {

    Button logbookBtn;
    Intent intent;
    TextView namaMhsTa, abstrak, dosenPemeriksa, judulTa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa_ta);
        intent = getIntent();
        if (intent != null) {
            String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder().build())
                    .build();
            StoryClient client = retrofit.create(StoryClient.class);

            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Pref", Context.MODE_PRIVATE);
            String gettoken = sharedPreferences.getString("TOKEN", "");
            String token = "Bearer " + gettoken;
            Toast.makeText(DetailMahasiswaTA.this,"List" + token, Toast.LENGTH_SHORT).show();
            Log.e("token",token);

            int idMhs = intent.getIntExtra("id", 0);

            Call<DetailMhsTaResponse> call = client.detailTa("Bearer " + token,idMhs);
            call.enqueue(new Callback<DetailMhsTaResponse>() {
                @Override
                public void onResponse(Call<DetailMhsTaResponse> call, Response<DetailMhsTaResponse> response) {
                    Log.e("success", response.toString());
                    DetailMhsTaResponse detailMhsTaResponse = response.body();

                    namaMhsTa = findViewById(R.id.namaMhsTa);
                    abstrak = findViewById(R.id.abstrakDetailTa);
                    dosenPemeriksa = findViewById(R.id.dosenPemeriksa);
                    judulTa = findViewById(R.id.judulTA);

                    String nama = detailMhsTaResponse.getStudent().getName();
                    String abs = detailMhsTaResponse.getJsonMemberAbstract();
                    String judul = detailMhsTaResponse.getTitle();

                    namaMhsTa.setText(nama);
                    abstrak.setText(abs);
                    judulTa.setText(judul);
                }

                @Override
                public void onFailure(Call<DetailMhsTaResponse> call, Throwable t) {

                }

            });

            logbookBtn = findViewById(R.id.logbookBtn);
            logbookBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int idMhsTa = idMhs;
                    Intent intent1 = new Intent(DetailMahasiswaTA.this,ListLogbook.class);
                    intent1.putExtra("id",idMhsTa);
                    startActivity(intent1);
                }
            });


        }
    }
}