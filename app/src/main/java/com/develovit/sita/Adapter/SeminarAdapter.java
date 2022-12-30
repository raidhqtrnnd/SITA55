package com.develovit.sita.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.develovit.sita.R;
import com.develovit.sita.Models.Seminar;

import java.util.ArrayList;

public class SeminarAdapter extends RecyclerView.Adapter<SeminarAdapter.MahasiswaViewHolder>{

    ArrayList<Seminar> listPermintaanTA = new ArrayList<>();


    ItemPermintaanTAClickListener listener;

    public SeminarAdapter(ArrayList<Seminar> listPermintaanTA) {
        this.listPermintaanTA = listPermintaanTA;
    }

    public void setListener(ItemPermintaanTAClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list2, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        Seminar seminar = listPermintaanTA.get(position);
        holder.gambar.setImageResource(R.drawable.profil9);
        holder.namaMhs.setText(seminar.getNamaMhs());
        holder.dospeng.setText(seminar.getDospeng());
        holder.judul3.setText(seminar.getJudul3());
    }

    @Override
    public int getItemCount() {

        return listPermintaanTA.size();
    }

    public interface ItemPermintaanTAClickListener{
        void onItemAgendaClick (Seminar permintaan);
    }
    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView gambar;
        public TextView namaMhs, dospeng, judul3;


        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.gambar);
            namaMhs =itemView.findViewById(R.id.namaMhs);
            dospeng =itemView.findViewById(R.id.dospeng);
            judul3 =itemView.findViewById(R.id.judul3);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Seminar permintaanta =listPermintaanTA.get(getAdapterPosition());
            listener.onItemAgendaClick(permintaanta);
        }
    }
}
