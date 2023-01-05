package com.develovit.sita.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.develovit.sita.R;
import com.develovit.sita.Models.Logbook;

public class LogbookAdapter extends RecyclerView.Adapter<LogbookAdapter.CardViewHolder> {

    private List<Logbook> ListLogbook = new ArrayList<>();


    public LogbookAdapter(List<Logbook> listLogbook) {
        ListLogbook = listLogbook;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_logbook_class, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Logbook log = ListLogbook.get(position);
        holder.tglRevisi.setText(log.getTglLog());
        holder.ketRevisi.setText(log.getKetLog());
        holder.statuslog.setText(log.getStatuslog());
    }


    @Override
    public int getItemCount() {
        return ListLogbook.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tglRevisi,ketRevisi,statuslog;

        public CardViewHolder(@NonNull View view) {
            super(view);
            tglRevisi = view.findViewById(R.id.tglRevisi);
            ketRevisi = view.findViewById(R.id.ketRevisi);
            statuslog = view.findViewById(R.id.statuslog);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
