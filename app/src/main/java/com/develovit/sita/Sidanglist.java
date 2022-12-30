package com.develovit.sita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.develovit.sita.Adapter.SidangAdapter;
import com.develovit.sita.Models.Sidang;

import java.util.ArrayList;

public class Sidanglist extends AppCompatActivity implements SidangAdapter.ItemPermintaanTAClickListener{

    private RecyclerView rvMhss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidanglist);

        rvMhss = findViewById(R.id.rv_Mhs2);

        SidangAdapter adapter = new SidangAdapter(getMhs());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvMhss.setLayoutManager(layoutManager);
        rvMhss.setAdapter(adapter);

    }

    public ArrayList<Sidang> getMhs(){
        ArrayList<Sidang> listPermintaanTA = new ArrayList<>();
        listPermintaanTA.add(new Sidang(
                null,
                "Sakura Uchiha",
                "Hasdi Putra M.T",
                "Automtisasi Smart Home",
                1
        ));
        listPermintaanTA.add(new Sidang(
                null,
                "Aisyah Putri Ayah",
                "Husnil Kamil M.T",
                "Penerapan logika fuzzy tsakamoto untuk Mesin",
                1
        ));
        listPermintaanTA.add(new Sidang(
                null,
                "Zaim Milzam",
                "Hasdi Putra M.T",
                "Simulasi Virtual Local Area Network",
                1
        ));
        listPermintaanTA.add(new Sidang(
                null,
                "Mardana Dulas",
                "Meiza Silvana M.T",
                "Penerapan logika fuzzy tsakamoto untuk Mesin",
                1
        ));
        listPermintaanTA.add(new Sidang(
                null,
                "Novyra Rahmasari",
                "20 Oktober 2022",
                "Pengembangan Aplikasi Perpustakaan",
                1

        ));
        listPermintaanTA.add(new Sidang(
                null,
                "Mardana Dulas",
                "Wahyudi M.T",
                "Simulasi Virtual Local Area Network",
                1
        ));
        listPermintaanTA.add(new Sidang(
                null,
                "Divo Pratama",
                "Wahyudi M.T",
                "Penerapan logika fuzzy tsakamoto untuk Mesin",
                1
        ));



        return listPermintaanTA;
    }

    @Override
    public void onItemAgendaClick(Sidang permintaan) {
        Intent detailIntent = new Intent (this,DetailSidang.class);
        detailIntent.putExtra("NAMA_MHS1", permintaan.getNamaMhs1());
        detailIntent.putExtra("JUDUL1", permintaan.getJudul1());
        detailIntent.putExtra("DOSPENG1", permintaan.getDospeng1());
        startActivity(detailIntent);
    }


}