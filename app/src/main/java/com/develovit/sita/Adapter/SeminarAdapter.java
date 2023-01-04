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
import com.develovit.sita.datamodel.SeminarListResponse;
import com.develovit.sita.datamodel.SeminarsItem;

import java.util.List;

public class SeminarAdapter extends RecyclerView.Adapter<SeminarAdapter.SeminarListViewHolder>{

    private List<SeminarsItem> itemList;

    public SeminarAdapter(List<SeminarsItem> itemList) {
        this.itemList = itemList;
    }

    public void setItemList(List<SeminarsItem> itemList) {
        this.itemList = itemList;
    }

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

    @NonNull
    @Override
    public SeminarListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list2, parent, false);
        return new SeminarListViewHolder(view);
    }

//    @Override
//    public void onBindViewHolder(@NonNull SeminarListViewHolder holder, int position) {
//        Seminar seminar = listPermintaanTA.get(position);
//        holder.gambar.setImageResource(R.drawable.profil9);
//        holder.namaMhs.setText(seminar.getNamaMhs());
//        holder.dospeng.setText(seminar.getDospeng());
//        holder.judul3.setText(seminar.getJudul3());
//    }

        @Override
    public void onBindViewHolder(@NonNull SeminarListViewHolder holder, int position) {
        SeminarListResponse seminar = itemList.get(position);
        holder.gambar.setImageResource(R.drawable.profil9);
        holder.name.setText(seminar.getCount());
        holder.department_id.setText(seminar.getCount());
        holder.title.setText(seminar.getCount());
    }

//    @Override
//    public int getItemCount() {
//
//        return listPermintaanTA.size();
//    }

        @Override
    public int getItemCount() {
         return itemList.size();
    }




    public interface ItemPermintaanTAClickListener{
        void onItemAgendaClick (Seminar permintaan);
    }
    public class SeminarListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView gambar;
        public TextView name, department_id, title;


        public SeminarListViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.gambar);
            name =itemView.findViewById(R.id.namaMhs);
            department_id =itemView.findViewById(R.id.dospeng);
            title =itemView.findViewById(R.id.judul3);

            itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            Seminar permintaanta =listPermintaanTA.get(getAdapterPosition());
//            listener.onItemAgendaClick(permintaanta);
//        }

//        @Override
//        public void onClick(View view) {
//            Seminar permintaant =SeminarListResponse.get(getAdapterPosition());
//            itemList.onI(permintaant);
//        }
    }
}
