package com.develovit.sita.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.develovit.sita.R;
import com.develovit.sita.Sidanglist;
import com.develovit.sita.datamodel.PermintaanSidang;
import com.develovit.sita.datamodel.SeminarsItem;

import java.util.ArrayList;
import java.util.List;

public class SidangAdapter extends RecyclerView.Adapter<SidangAdapter.MahasiswaViewHolder>{

    private List<SeminarsItem> itemThesis = new ArrayList<>();
    ItemPermintaanSidangClickListener listener;

    public void setItemThesis(List<SeminarsItem> itemThesis) {
        this.itemThesis = itemThesis;
        notifyDataSetChanged();
    }

    public void setListener(ItemPermintaanSidangClickListener listener) {
        this.listener = listener;
    }

    public interface ItemPermintaanSidangClickListener {
        void onItemAgendaClick(SeminarsItem permintaan);
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list2, parent, false);
        return new MahasiswaViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return itemThesis.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        SeminarsItem permintaanSidang = itemThesis.get(position);
//       holder.imageMhs.setImageResource((R.drawable.profil9));
        String str1= permintaanSidang.getThesis().getStudent().getName();
        String str2 = str1.toLowerCase();
        holder.namaMhs1.setText(SidangAdapter.StringFormatter.capitalizeWord(str2));
        holder.nimMhs.setText(permintaanSidang.getThesis().getStudent().getNim());
        holder.title.setText(permintaanSidang.getThesis().getTitle());
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageMhs;
        public TextView namaMhs1, nimMhs, title;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
//            imageMhs = itemView.findViewById(R.id.gambar1);
            title = itemView.findViewById(R.id.judul3);
            namaMhs1 = itemView.findViewById(R.id.namaMhs);
            nimMhs = itemView.findViewById(R.id.nimMhs);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            SeminarsItem permintaan = itemThesis.get(getAdapterPosition());
            listener.onItemAgendaClick(permintaan);
        }
    }

    public static class StringFormatter {
        public static String capitalizeWord(String str){
            String words[]=str.split("\\s");
            String capitalizeWord="";
            for(String w:words){
                String first=w.substring(0,1);
                String afterfirst=w.substring(1);
                capitalizeWord+=first.toUpperCase()+afterfirst+" ";
            }
            return capitalizeWord.trim();
        }
    }



//    ArrayList<Sidang> listPermintaanTA = new ArrayList<>();
//
//
//    ItemPermintaanTAClickListener listener;
//
//    public SidangAdapter(ArrayList<Sidang> listPermintaanTA) {
//        this.listPermintaanTA = listPermintaanTA;
//    }
//
//    public void setListener(ItemPermintaanTAClickListener listener) {
//        this.listener = listener;
//    }
//
//    @NonNull
//    @Override
//    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list6, parent, false);
//        return new MahasiswaViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
//        Sidang sidang = listPermintaanTA.get(position);
//        holder.gambar1.setImageResource(R.drawable.profil1);
//        holder.namaMhs1.setText(sidang.getNamaMhs1());
//        holder.dospeng1.setText(sidang.getDospeng1());
//        holder.judul1.setText(sidang.getJudul1());
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return listPermintaanTA.size();
//    }
//
//    public interface ItemPermintaanSidangClickListener{
//
//        void onItemAgendaClick(SeminarsItem permintaan);
//    }
//
//
//
//    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//        public ImageView gambar1;
//        public TextView namaMhs1, dospeng1, judul1;
//
//
//        public MahasiswaViewHolder(@NonNull View itemView) {
//            super(itemView);
//            gambar1 = itemView.findViewById(R.id.gambar1);
//            namaMhs1 =itemView.findViewById(R.id.namaMhs1);
//            dospeng1 =itemView.findViewById(R.id.dospeng1);
//            judul1 =itemView.findViewById(R.id.judul1);
//
//            itemView.setOnClickListener(this);
//        }

//        @Override
//        public void onClick(View view) {
//            SeminarsItem permintaan =listPermintaanTA.get(getAdapterPosition());
//            listener.onItemAgendaClick(permintaan);
//        }
  }

