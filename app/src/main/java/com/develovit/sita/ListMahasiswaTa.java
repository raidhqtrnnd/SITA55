package com.develovit.sita;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.develovit.sita.Adapter.MhsCardAdapter;
import com.develovit.sita.datamodel.ListTaMhsResponse;
import com.develovit.sita.datamodel.ThesesItem;
import com.develovit.sita.retrofit.StoryClient;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListMahasiswaTa extends AppCompatActivity
        implements MhsCardAdapter.listMhsOnClickListener{

    private RecyclerView rview;
    private MhsCardAdapter mhsCardAdapter;
    String getToken, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa_ta);

        //Config config = new Config();
        /*SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token",token).apply();*/

        rview = findViewById(R.id.rView);
        rview.setLayoutManager(new LinearLayoutManager(this));
        //rview.setAdapter(mhsCardAdapter);

        mhsCardAdapter = new MhsCardAdapter();
        mhsCardAdapter.setListener(this);
        rview.setAdapter(mhsCardAdapter);

        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
        StoryClient client = retrofit.create(StoryClient.class);

        SharedPreferences sharedPreferences = getSharedPreferences("com.develovit.sita.SHARED_KEY", Context.MODE_PRIVATE);
        getToken = sharedPreferences.getString("TOKEN","");
        token = "Bearer " + getToken;
        Log.e("token",token);

        Call<ListTaMhsResponse> call = client.getTaMhs(token);
        call.enqueue(new Callback<ListTaMhsResponse>() {
            @Override
            public void onResponse(Call<ListTaMhsResponse> call, Response<ListTaMhsResponse> response) {
                ListTaMhsResponse taMhsResponse = response.body();
                Log.e("suc", response.toString());
                if (taMhsResponse!=null){
                    List<ThesesItem> theses = taMhsResponse.getTheses();
                    mhsCardAdapter.setTheses((List<ThesesItem>)theses);
                }
            }

            @Override
            public void onFailure(Call<ListTaMhsResponse> call, Throwable t) {
                Log.e("fail",t.getLocalizedMessage());
            }
        });

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);

    }

    /*public ArrayList<ListMhsTa> getListMhstTA() {
        ArrayList<ListMhsTa> listMhsTA = new ArrayList<>();
        listMhsTA.add(new ListMhsTa(
                "Raidha Qatrunnada",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Muhammad Zaim Milzam",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Raditya Romero",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Thomas Akram",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Raidha Qatrunnada",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Muhammad Zaim Milzam",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Raditya Romero",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Thomas Akram",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Raidha Qatrunnada",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Muhammad Zaim Milzam",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Raditya Romero",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Thomas Akram",
                "SPK....",
                "Ricky Akbar"
        ));
        return listMhsTA;
    }*/


    @Override
    public void listMhsClick(ThesesItem listAgenda) {
        Intent intent = new Intent(ListMahasiswaTa.this, DetailMahasiswaTA.class);
        intent.putExtra("nama",listAgenda.getStudentName());
        startActivity(intent);
    }
}
