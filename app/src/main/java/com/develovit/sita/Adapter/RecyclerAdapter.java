package com.develovit.sita;

/**
 * Created by qwerty on 29/05/2018.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
private ArrayList<com.develovit.sita.DataRecyclerView> listdata;
private Activity activity;
private Context context;

public RecyclerAdapter(Activity activity, ArrayList<com.develovit.sita.DataRecyclerView> listdata) {
        this.listdata = listdata;
        this.activity = activity;
        }



    @Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list2, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
        }

@RequiresApi(api = Build.VERSION_CODES.N)
@Override
public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        //holder.mImage.setImageResource(listdata.get(position).getThubnail());


     int id = listdata.get(position).getId();


     holder.judul.setText(listdata.get(position).getJudul());
     holder.nama.setText(listdata.get(position).getNama());
    holder.dospem.setText(listdata.get(position).getDospem());

    Glide.with(activity).load(listdata.get(position).getImage()).into(holder.image);

     holder.lihat.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent i = new Intent(activity,JadwalSidang.class);
             i.putExtra("judul",listdata.get(position).getJudul());
             i.putExtra("nama",listdata.get(position).getNama());
             i.putExtra("dospem",listdata.get(position).getDospem());
             activity.startActivity(i);
         }
     });





        }

//    private void proses(final String id){
//        String HttpURL = Data.SERVER+"mapwalet2/superadmin/hapus_akun.php";
//        final ProgressDialog progressDialog = new ProgressDialog(activity);
//        progressDialog.setMessage("Loading... ");
//        progressDialog.show();
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpURL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        //do stuffs with response of post
//
//
//
//                        try {
//                            if (!response.equals("Gagal")) {
//                                progressDialog.dismiss();
//                            } else {
//                                progressDialog.dismiss();
//                                Toast.makeText(activity,"Gagal menghapus akun", Toast.LENGTH_SHORT).show();
//
//                            }
//                        }catch (Exception e){
////                            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        //do stuffs with response erroe
//                        progressDialog.dismiss();
//                        Toast.makeText(activity,error.toString(), Toast.LENGTH_LONG).show();
//
//                    }
//                })
//        {
//            @Override
//            protected Map<String, String> getParams(){
//                Map<String, String> params = new HashMap<String, String>();
//
//
//
////                tvnama = mBottomSheetDialog.findViewById(R.id.nama);
////                tvtelepon = mBottomSheetDialog.findViewById(R.id.telepon);
////                tvtgl_panen = mBottomSheetDialog.findViewById(R.id.tgl_panen);
////                tvkomposisi = mBottomSheetDialog.findViewById(R.id.komposisi);
////                tvharga = mBottomSheetDialog.findViewById(R.id.harga);
////                tvharpapasar = mBottomSheetDialog.findViewById(R.id.psrharga);
////
////              String  name = tvnama.getText().toString().trim();
////                String  telepon = tvtelepon.getText().toString().trim();
////                String hrgapasar = tvharpapasar.getText().toString().trim();
////                String  harga = tvharga.getText().toString().trim();
////                String tgl_panen = tvtgl_panen.getText().toString().trim();
////                String komposisi = tvkomposisi.getText().toString().trim();
//
////                String asal = sp_asal.getSelectedItem().toString();
////                String tujuan = sp_tujuan.getSelectedItem().toString();
//
//                params.put("id_client",id);
//
//
//                return params;
//            }
//
//        };
//
//        RequestQueue requestQueue = Volley.newRequestQueue(activity);
//        requestQueue.add(stringRequest);
//    }


    @Override
public int getItemCount() {
        return listdata.size();
        }

public static class ViewHolder extends RecyclerView.ViewHolder {
//    public RelativeLayout cv;
    public TextView word,desc;
    LinearLayout all;
    Button lihat;
    TextView nama,dospem,judul;
    CircleImageView image;

    public ViewHolder(View v) {
        super(v);
        nama=v.findViewById(R.id.nama);
        dospem= v.findViewById(R.id.dospem);
        judul= v.findViewById(R.id.judul);
        lihat= v.findViewById(R.id.lihat);
        image= v.findViewById(R.id.profile_image);



    }
}

}