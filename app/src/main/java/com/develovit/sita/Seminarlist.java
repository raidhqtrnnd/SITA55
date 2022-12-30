package com.develovit.sita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.develovit.sita.Adapter.SeminarAdapter;
import com.develovit.sita.Models.Seminar;

import java.util.ArrayList;

public class Seminarlist extends AppCompatActivity implements SeminarAdapter.ItemPermintaanTAClickListener{

    private RecyclerView rvMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminarlist);

        rvMhs = findViewById(R.id.rv_Mhs);

        SeminarAdapter adapter = new SeminarAdapter(getMhs());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvMhs.setLayoutManager(layoutManager);
        rvMhs.setAdapter(adapter);

    }

    public ArrayList<Seminar> getMhs(){
        ArrayList<Seminar> listPermintaanTA = new ArrayList<>();
        listPermintaanTA.add(new Seminar(
                null,
                "Raidha Qatrunnada",
                "Hasdi Putra M.T",
                "Automtisasi Smart Home",
                1
        ));
        listPermintaanTA.add(new Seminar(
                null,
                "Mardana Dulas",
                "Husnil Kamil M.T",
                "Penerapan logika fuzzy tsakamoto untuk Mesin",
                1
        ));
        listPermintaanTA.add(new Seminar(
                null,
                "Zaim Milzam",
                "Hasdi Putra M.T",
                "Simulasi Virtual Local Area Network",
                1
        ));
        listPermintaanTA.add(new Seminar(
                null,
                "Mardana Dulas",
                "Meiza Silvana M.T",
                "Penerapan logika fuzzy tsakamoto untuk Mesin",
                1
        ));
        listPermintaanTA.add(new Seminar(
                null,
                "Novyra Rahmasari",
                "20 Oktober 2022",
                "Pengembangan Aplikasi Perpustakaan",
                1

        ));
        listPermintaanTA.add(new Seminar(
                null,
                "Mardana Dulas",
                "Wahyudi M.T",
                "Simulasi Virtual Local Area Network",
                1
        ));
        listPermintaanTA.add(new Seminar(
                null,
                "Divo Pratama",
                "Wahyudi M.T",
                "Penerapan logika fuzzy tsakamoto untuk Mesin",
                1
        ));



        return listPermintaanTA;
    }

    @Override
    public void onItemAgendaClick(Seminar permintaan) {
        Intent detailIntent = new Intent (this,DetailSeminar.class);
        detailIntent.putExtra("NAMA_MHS", permintaan.getNamaMhs());
        detailIntent.putExtra("JUDUL", permintaan.getJudul3());
        detailIntent.putExtra("DOSPENG", permintaan.getDospeng());
        startActivity(detailIntent);
    }

    public void detailsid(View view) {
        Intent detailsIntent= new Intent (this, Sidanglist.class);
        startActivity(detailsIntent);
    }


}