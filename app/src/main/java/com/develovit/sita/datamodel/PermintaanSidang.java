package com.develovit.sita.datamodel;

public class PermintaanSidang {
    String gambar;
    String nama_mhs;
    String nim_mhs;

    public PermintaanSidang(){ }

    public PermintaanSidang(String gambar, String nama_mhs, String nim_mhs) {
        this.gambar = gambar;
        this.nama_mhs = nama_mhs;
        this.nim_mhs = nim_mhs;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama_mhs() {
        return nama_mhs;
    }

    public void setNama_mhs(String nama_mhs) {
        this.nama_mhs = nama_mhs;
    }

    public String getNim_mhs() {
        return nim_mhs;
    }

    public void setNim_mhs(String nim_mhs) {
        this.nim_mhs = nim_mhs;
    }
}
