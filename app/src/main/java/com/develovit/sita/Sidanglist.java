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

import com.develovit.sita.Adapter.SidangAdapter;
import com.develovit.sita.datamodel.SidangListResponse;
import com.develovit.sita.datamodel.SeminarsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sidanglist extends AppCompatActivity implements SidangAdapter.ItemPermintaanSidangClickListener{

    private RecyclerView rvMhss;
    String token, gettoken;
    SeminarsItem tes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidanglist);

        rvMhss = findViewById(R.id.rv_Mhs2);

        SidangAdapter adapter = new SidangAdapter();
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvMhss.setLayoutManager(layoutManager);
        rvMhss.setAdapter(adapter);

        SharedPreferences sharedPreferences = getSharedPreferences("Pref", MODE_PRIVATE);
        gettoken = sharedPreferences.getString("TOKEN", "");
        token = "Bearer " + gettoken;

        Config config = new Config();
        Call<SidangListResponse> call = config.configRetrofit().getPermintaanSidang(token);
        call.enqueue(new Callback<SidangListResponse>() {
            @Override
            public void onResponse(Call<SidangListResponse> call, Response<SidangListResponse> response) {
                Log.d("permintaan-Debug", response.toString());
                SidangListResponse getPermintaanSidangResponse = response.body();
                if (getPermintaanSidangResponse != null) {
                    List<SeminarsItem> listThesis = getPermintaanSidangResponse.getSeminars();
                    Log.d("permintaan-Debug", String.valueOf(listThesis.size()));
                    adapter.setItemThesis(listThesis);
                }
            }

            @Override
            public void onFailure(Call<SidangListResponse> call, Throwable t) {
                Toast.makeText(Sidanglist.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    }
//
//    public ArrayList<Sidang> getMhs(){
//        ArrayList<Sidang> listPermintaanTA = new ArrayList<>();
//        listPermintaanTA.add(new Sidang(
//                null,
//                "Sakura Uchiha",
//                "Hasdi Putra M.T",
//                "Automtisasi Smart Home",
//                1
//        ));
//        listPermintaanTA.add(new Sidang(
//                null,
//                "Aisyah Putri Ayah",
//                "Husnil Kamil M.T",
//                "Penerapan logika fuzzy tsakamoto untuk Mesin",
//                1
//        ));
//        listPermintaanTA.add(new Sidang(
//                null,
//                "Zaim Milzam",
//                "Hasdi Putra M.T",
//                "Simulasi Virtual Local Area Network",
//                1
//        ));
//        listPermintaanTA.add(new Sidang(
//                null,
//                "Mardana Dulas",
//                "Meiza Silvana M.T",
//                "Penerapan logika fuzzy tsakamoto untuk Mesin",
//                1
//        ));
//        listPermintaanTA.add(new Sidang(
//                null,
//                "Novyra Rahmasari",
//                "20 Oktober 2022",
//                "Pengembangan Aplikasi Perpustakaan",
//                1
//
//        ));
//        listPermintaanTA.add(new Sidang(
//                null,
//                "Mardana Dulas",
//                "Wahyudi M.T",
//                "Simulasi Virtual Local Area Network",
//                1
//        ));
//        listPermintaanTA.add(new Sidang(
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
//    public void onItemAgendaClick(Sidang permintaan) {
//        Intent detailIntent = new Intent (this,DetailSidang.class);
//        detailIntent.putExtra("NAMA_MHS1", permintaan.getNamaMhs1());
//        detailIntent.putExtra("JUDUL1", permintaan.getJudul1());
//        detailIntent.putExtra("DOSPENG1", permintaan.getDospeng1());
//        startActivity(detailIntent);
//    }



    @Override
    public void onItemAgendaClick(SeminarsItem permintaan) {
        Intent detailSidang = new Intent(this, DetailSidang.class);
        detailSidang.putExtra("NAMA_MHS1", permintaan.getThesis().getStudent().getName());
        detailSidang.putExtra("NIMMHS", permintaan.getThesis().getStudent().getNim());
        detailSidang.putExtra("JUDUL", permintaan.getThesis().getTitle());
        detailSidang.putExtra("Id Thesis", permintaan.getThesisId());
        detailSidang.putExtra("JADWAL", permintaan.getRegisteredAt());
        detailSidang.putExtra("FILE", permintaan.getFileReport());
        startActivity(detailSidang);
    }
}