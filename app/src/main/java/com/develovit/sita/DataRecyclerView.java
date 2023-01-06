package com.develovit.sita;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class DataRecyclerView {

    private int id;
    private String judul;
    private String nama;
    private String dospem;
    private Drawable image;

    public DataRecyclerView(String judul, String nama, String dospem, Drawable image) {
        this.judul = judul;
        this.nama = nama;
        this.dospem = dospem;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDospem() {
        return dospem;
    }

    public void setDospem(String dospem) {
        this.dospem = dospem;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
