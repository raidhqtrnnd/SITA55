package com.develovit.sita.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.develovit.sita.R;
//import com.develovit.sita.Models.Seminar;
import com.develovit.sita.datamodel.SeminarsItem;

import java.util.ArrayList;
import java.util.List;

public class SeminarAdapter extends RecyclerView.Adapter<SeminarAdapter.SeminarListViewHolder>{

    private List<SeminarsItem> itemThesis = new ArrayList<>();
    SidangAdapter.ItemPermintaanSidangClickListener listener;

    public void setItemThesis(List<SeminarsItem> itemThesis) {
        this.itemThesis = itemThesis;
        notifyDataSetChanged();
    }

    public void setListener(SidangAdapter.ItemPermintaanSidangClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public SeminarListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list4, parent, false);
        return new SeminarListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeminarListViewHolder holder, int position) {
        SeminarsItem permintaanSeminar = itemThesis.get(position);
//       holder.imageMhs.setImageResource((R.drawable.profil9));
        String str1= permintaanSeminar.getThesis().getStudent().getName();
        String str2 = str1.toLowerCase();
        holder.namaMhs4.setText(SidangAdapter.StringFormatter.capitalizeWord(str2));
        holder.nimMhs4.setText(permintaanSeminar.getThesis().getStudent().getNim());
        holder.title4.setText(permintaanSeminar.getThesis().getTitle());

    }


    @Override
    public int getItemCount() {
        return itemThesis.size();
    }

    public interface ItemPermintaanTAClickListener {
        void onItemAgendaClick(SeminarsItem permintaant);
    }


    public class SeminarListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageMhs;
        public TextView namaMhs4, nimMhs4, title4;

        public SeminarListViewHolder(@NonNull View itemView) {
            super(itemView);
//            imageMhs = itemView.findViewById(R.id.gambar1);
            title4 = itemView.findViewById(R.id.judul4);
            namaMhs4 = itemView.findViewById(R.id.namaMhs4);
            nimMhs4 = itemView.findViewById(R.id.nimMhs4);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            SeminarsItem permintaant = itemThesis.get(getAdapterPosition());
            listener.onItemAgendaClick(permintaant);
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





//    private List<Student> itemList;
//
//    public SeminarAdapter(List<Student> itemList) {
//        this.itemList = itemList;
//    }
//
//    public void setItemList(List<Student> itemList) {
//        this.itemList = itemList;
//    }

//    ArrayList<Seminar> listPermintaanTA = new ArrayList<>();
//
//
//    ItemPermintaanTAClickListener listener;
//
//    public SeminarAdapter(ArrayList<Seminar> listPermintaanTA) {
//        this.listPermintaanTA = listPermintaanTA;

//    public void setListener(ItemPermintaanTAClickListener listener) {
//        this.listener = listener;
//    }



//    @NonNull
//    @Override
//    public SeminarListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list2, parent, false);
//        return new SeminarListViewHolder(view);
//    }

//    @NonNull
//    @Override
//    public SeminarListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list2, parent, false);
//        return new SeminarListViewHolder(view);
//    }

//    @Override
//    public void onBindViewHolder(@NonNull SeminarListViewHolder holder, int position) {
//        Seminar seminar = listPermintaanTA.get(position);
//        holder.gambar.setImageResource(R.drawable.profil9);
//        holder.namaMhs.setText(seminar.getNamaMhs());
//        holder.dospeng.setText(seminar.getDospeng());
//        holder.judul3.setText(seminar.getJudul3());
//    }

//        @Override
//    public void onBindViewHolder(@NonNull SeminarListViewHolder holder, int position) {
//        Student student = itemList.get(position);
//        holder.gambar.setImageResource(R.drawable.profil9);
//        holder.name.setText(student.getName());
//        holder.nim.setText(student.getDepartmentId());
//        holder.title.setText(student.getYear());
//    }

//    @Override
//    public int getItemCount() {
//
//        return listPermintaanTA.size();
//    }

//        @Override
//    public int getItemCount() {
//         return itemList.size();
//    }
//
//
//
//
//    public interface ItemPermintaanTAClickListener{
//        void onItemAgendaClick (Student permintaan);
//    }
//
//    public class SeminarListViewHolder extends RecyclerView.ViewHolder{
//
//        public ImageView gambar;
//        public TextView name, nim, title;
//
//
//        public SeminarListViewHolder(@NonNull View itemView) {
//            super(itemView);
//            gambar = itemView.findViewById(R.id.gambar);
//            name =itemView.findViewById(R.id.namaMhs);
//            nim =itemView.findViewById(R.id.nimMhs);
//            title =itemView.findViewById(R.id.judul3);
//
////            itemView.setOnClickListener(this);
//        }

//        @Override
//        public void onClick(View view) {
//            Seminar permintaanta =listPermintaanTA.get(getAdapterPosition());
//            listener.onItemAgendaClick(permintaanta);
//        }

//        @Override
//        public void onClick(View view) {
//            Student permintaanta =SeminarListResponse.get(getAdapterPosition());
//            itemList.onItemAgendaClick(permintaanta);
//        }
//    }
}
