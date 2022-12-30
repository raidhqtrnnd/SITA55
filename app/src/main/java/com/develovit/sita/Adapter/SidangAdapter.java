package com.develovit.sita.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.develovit.sita.R;
import com.develovit.sita.Models.Sidang;

import java.util.ArrayList;

public class SidangAdapter extends RecyclerView.Adapter<SidangAdapter.MahasiswaViewHolder>{

    ArrayList<Sidang> listPermintaanTA = new ArrayList<>();


    ItemPermintaanTAClickListener listener;

    public SidangAdapter(ArrayList<Sidang> listPermintaanTA) {
        this.listPermintaanTA = listPermintaanTA;
    }

    public void setListener(ItemPermintaanTAClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list6, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        Sidang sidang = listPermintaanTA.get(position);
        holder.gambar1.setImageResource(R.drawable.profil1);
        holder.namaMhs1.setText(sidang.getNamaMhs1());
        holder.dospeng1.setText(sidang.getDospeng1());
        holder.judul1.setText(sidang.getJudul1());
    }

    @Override
    public int getItemCount() {

        return listPermintaanTA.size();
    }

    public interface ItemPermintaanTAClickListener{
        void onItemAgendaClick (Sidang permintaan);
    }
    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView gambar1;
        public TextView namaMhs1, dospeng1, judul1;


        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar1 = itemView.findViewById(R.id.gambar1);
            namaMhs1 =itemView.findViewById(R.id.namaMhs1);
            dospeng1 =itemView.findViewById(R.id.dospeng1);
            judul1 =itemView.findViewById(R.id.judul1);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Sidang permintaanta =listPermintaanTA.get(getAdapterPosition());
            listener.onItemAgendaClick(permintaanta);
        }
    }
}
