package com.develovit.sita.Adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.develovit.sita.R;
import com.develovit.sita.datamodel.ThesesItem;

public class MhsCardAdapter extends RecyclerView.Adapter<MhsCardAdapter.CardViewHolder> {



    private ArrayList<ThesesItem> thesesItems = new ArrayList<>();


    public void setListener(listMhsOnClickListener listener) {
        this.listener = listener;
    }

    listMhsOnClickListener listener;

    public void setTheses(ArrayList<ThesesItem> thesesItems) {
        this.thesesItems = thesesItems;
        notifyDataSetChanged();
    }

    //-----------------------------here
    public MhsCardAdapter(){
        this.listener = listener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_mhs_ta_class, parent, false);
        return new CardViewHolder(view);
    }



    /*public MhsCardAdapter(ArrayList<ListMhsTa> listAgenda, listMhsOnClickListener listener) {
        this.theses = listAgenda;
        this.listener = listener;
    }*/

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        ThesesItem agenda = thesesItems.get(position);
        holder.namaMhs.setText(agenda.getStudentName());
        holder.nim.setText(agenda.getStudentNim());
        holder.judulTa.setText((CharSequence) agenda.getTitle());
        holder.dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.listMhsClick(agenda);
            }
        });
    }

    public interface listMhsOnClickListener{
        void listMhsClick(ThesesItem listAgenda);

    }

    @Override
    public int getItemCount() {
        return thesesItems.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView namaMhs, nim, judulTa;
        public ImageView dropdown;


        //========================================================
        // PERLU REVISI DESAIN
        // ========================================================
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            namaMhs = itemView.findViewById(R.id.namaMhs);
            nim = itemView.findViewById(R.id.nim);
            judulTa = itemView.findViewById(R.id.judulTa);
            dropdown = itemView.findViewById(R.id.dropdown);

            itemView.setOnClickListener(this);
        }
        //========================================================
        @Override
        public void onClick(View view) {
            ThesesItem listAgenda = thesesItems.get(getAdapterPosition()); //getBindingAdapterPosition()
            listener.listMhsClick(listAgenda);
        }
    }

}
