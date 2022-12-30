package com.develovit.sita.Models;

public class DospemView {

    String gambar2;
    String nama2;
    String dospem2;
    String judul2;
    int status;

    public DospemView(){ }

    public String getJudul2() {
        return judul2;
    }

    public void setJudul2(String judul2) {
        this.judul2 = judul2;
    }

    public DospemView(String gambar2, String namaMhs2, String dospem2, String judul2, int status) {
        this.gambar2 = gambar2;
        this.nama2 = nama2;
        this.dospem2 = dospem2;
        this.judul2 = judul2;
        this.status = status;
    }

    public String getGambar2() {
        return gambar2;
    }

    public void setGambar2(String gambar1) {
        this.gambar2 = gambar2;
    }

    public String getNama2() {
        return nama2;
    }

    public void setNama2(String nama2) {
        this.nama2 = nama2;
    }

    public String getDospem2() {
        return dospem2;
    }

    public void setDospem2(String dospem2) {
        this.dospem2 = dospem2;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
