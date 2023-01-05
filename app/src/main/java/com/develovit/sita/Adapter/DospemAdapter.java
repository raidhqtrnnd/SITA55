//package com.develovit.sita.Adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.develovit.sita.Models.DospemView;
//import com.develovit.sita.R;
//
//import java.util.ArrayList;
//
//public class DospemAdapter extends RecyclerView.Adapter<DospemAdapter.MahasiswaViewHolder>{
//
//    ArrayList<DospemView> listPermintaanTA = new ArrayList<>();
//
//
//    ItemPermintaanTAClickListener listener;
//
//    public DospemAdapter(ArrayList<DospemView> listPermintaanTA) {
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
//                .inflate(R.layout.list3, parent, false);
//        return new MahasiswaViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
//        DospemView dopsem = listPermintaanTA.get(position);
//        holder.gambar2.setImageResource(R.drawable.profil1);
//        holder.nama2.setText(dopsem.getNama2());
//        holder.dospem2.setText(dopsem.getDospem2());
//        holder.judul2.setText(dopsem.getJudul2());
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return listPermintaanTA.size();
//    }
//
//    public interface ItemPermintaanTAClickListener{
//        void onItemAgendaClick (DospemView permintaan);
//    }
//    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//        public ImageView gambar2;
//        public TextView nama2, dospem2, judul2;
//
//
//        public MahasiswaViewHolder(@NonNull View itemView) {
//            super(itemView);
//            gambar2 = itemView.findViewById(R.id.gambar2);
//            nama2 =itemView.findViewById(R.id.nama2);
//            dospem2 =itemView.findViewById(R.id.dospem2);
//            judul2 =itemView.findViewById(R.id.judul2);
//
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View view) {
//            DospemView permintaanta =listPermintaanTA.get(getAdapterPosition());
//            listener.onItemAgendaClick(permintaanta);
//        }
//    }
//}
