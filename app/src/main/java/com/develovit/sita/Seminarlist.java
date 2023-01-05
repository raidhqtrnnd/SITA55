package com.develovit.sita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.develovit.sita.Adapter.SeminarAdapter;
//import com.develovit.sita.Models.Seminar;
import com.develovit.sita.Adapter.SidangAdapter;
import com.develovit.sita.datamodel.LogoutResponse;
import com.develovit.sita.datamodel.SeminarListResponse;
import com.develovit.sita.datamodel.Student;
import com.develovit.sita.datamodel.SeminarsItem;
import com.develovit.sita.retrofit.StoryClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Seminarlist extends AppCompatActivity implements SeminarAdapter.ItemPermintaanTAClickListener, SidangAdapter.ItemPermintaanSidangClickListener {
    private RecyclerView rvMhs;
    String token, gettoken;
    SeminarsItem tes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminarlist);

        rvMhs = findViewById(R.id.rv_Mhs);

        SeminarAdapter adapter = new SeminarAdapter();
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvMhs.setLayoutManager(layoutManager);
        rvMhs.setAdapter(adapter);

        SharedPreferences sharedPreferences = getSharedPreferences("Pref", MODE_PRIVATE);
        gettoken = sharedPreferences.getString("TOKEN", "");
        token = "Bearer " + gettoken;

        Config config = new Config();
        Call<SeminarListResponse> call = config.configRetrofit().getPermintaanSeminar(token);
        call.enqueue(new Callback<SeminarListResponse>() {
            @Override
            public void onResponse(Call<SeminarListResponse> call, Response<SeminarListResponse> response) {
                Log.d("permintaan-Debug", response.toString());
                SeminarListResponse getPermintaanSidangResponse = response.body();
                if (getPermintaanSidangResponse != null) {
                    List<SeminarsItem> listThesis = getPermintaanSidangResponse.getSeminars();
                    Log.d("permintaan-Debug", String.valueOf(listThesis.size()));
                    adapter.setItemThesis(listThesis);
                }
            }

            @Override
            public void onFailure(Call<SeminarListResponse> call, Throwable t) {
                Toast.makeText(Seminarlist.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemAgendaClick(SeminarsItem permintaant) {
        Intent detailSidang = new Intent(this, DetailSeminar.class);
        detailSidang.putExtra("NAMA_MHS4", permintaant.getThesis().getStudent().getName());
        detailSidang.putExtra("NIMMHS4", permintaant.getThesis().getStudent().getNim());
        detailSidang.putExtra("JUDUL4", permintaant.getThesis().getTitle());
        detailSidang.putExtra("Id Thesis", permintaant.getThesisId());
        detailSidang.putExtra("JADWAL", permintaant.getRegisteredAt());
        detailSidang.putExtra("FILE1", permintaant.getFileReport());
        startActivity(detailSidang);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}

//        SeminarAdapter adapter = new SeminarAdapter(getMhs());
//        adapter.setListener(this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);


//        SeminarAdapter adapter = new SeminarAdapter(getMhs());
//        adapter.setItemList();
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//
//        rvMhs.setLayoutManager(layoutManager);
//        rvMhs.setAdapter(adapter);

        //Minta data ke server
//        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(API_BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(new OkHttpClient.Builder().build())
//                .build();
//
//        StoryClient client = retrofit.create(StoryClient.class);

//        Call<Student> call = client.getStudent();
//        call.enqueue(new Callback<Student>() {
//            @Override
//            public void onResponse(Call<Student> call, Response<Student> response) {
//                Student student = response.body();
//                if(student != null){
//                    List<Student> studentList = student;
//                }
//            }


//            public void onResponse(Call<Student> call, Response<Student> response) {
//                Log.d("PesertaDebug", response.toString());
//
//                Student pesertaResponse = response.body();
//                if(pesertaResponse!= null){
//                    List<Student> peserta = pesertaResponse.get();
//                    adapter.setItemList(peserta);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<PesertaResponse> call, Throwable t) {
//
//            }
//        });
//    }


//    public ArrayList<Seminar> getMhs(){
//        ArrayList<Seminar> listPermintaanTA = new ArrayList<>();
//        listPermintaanTA.add(new Seminar(
//                null,
//                "Raidha Qatrunnada",
//                "Hasdi Putra M.T",
//                "Automtisasi Smart Home",
//                1
//        ));
//        listPermintaanTA.add(new Seminar(
//                null,
//                "Mardana Dulas",
//                "Husnil Kamil M.T",
//                "Penerapan logika fuzzy tsakamoto untuk Mesin",
//                1
//        ));
//        listPermintaanTA.add(new Seminar(
//                null,
//                "Zaim Milzam",
//                "Hasdi Putra M.T",
//                "Simulasi Virtual Local Area Network",
//                1
//        ));
//        listPermintaanTA.add(new Seminar(
//                null,
//                "Mardana Dulas",
//                "Meiza Silvana M.T",
//                "Penerapan logika fuzzy tsakamoto untuk Mesin",
//                1
//        ));
//        listPermintaanTA.add(new Seminar(
//                null,
//                "Novyra Rahmasari",
//                "20 Oktober 2022",
//                "Pengembangan Aplikasi Perpustakaan",
//                1
//
//        ));
//        listPermintaanTA.add(new Seminar(
//                null,
//                "Mardana Dulas",
//                "Wahyudi M.T",
//                "Simulasi Virtual Local Area Network",
//                1
//        ));
//        listPermintaanTA.add(new Seminar(
//                null,
//                "Divo Pratama",
//                "Wahyudi M.T",
//                "Penerapan logika fuzzy tsakamoto untuk Mesin",
//                1
//        ));
//
//
//
//        return listPermintaanTA;
//    }

//    @Override
//    public void onItemAgendaClick(Seminar permintaan) {
//        Intent detailIntent = new Intent (this,DetailSeminar.class);
//        detailIntent.putExtra("NAMA_MHS", permintaan.getNamaMhs());
//        detailIntent.putExtra("JUDUL", permintaan.getJudul3());
//        detailIntent.putExtra("DOSPENG", permintaan.getDospeng());
//        startActivity(detailIntent);
//    }

//    public void detailsid(View view) {
//        Intent detailsIntent= new Intent (this, Seminarlist.class);
//        startActivity(detailsIntent);
//    }

//
//    }
//}