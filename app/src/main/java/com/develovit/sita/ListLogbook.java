package com.develovit.sita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import com.develovit.sita.Adapter.LogbookAdapter;
import com.develovit.sita.Models.Logbook;

public class ListLogbook extends AppCompatActivity {

    private RecyclerView rvLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_logbook);

        rvLog = findViewById(R.id.rvLog);

        LogbookAdapter logbook = new LogbookAdapter(getLogbook());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvLog.setLayoutManager(layoutManager);
        rvLog.setAdapter(logbook);



    }
    public ArrayList<Logbook> getLogbook(){
        ArrayList<Logbook> listlogbook = new ArrayList<Logbook>();
        listlogbook.add(new Logbook(
                "1 januari 2022",
                "update laporan",
                1
        ));
        return listlogbook;
    }
}