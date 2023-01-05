package com.develovit.sita.Models;

public class Seminar {

    String gambar;
    String namaMhs;
    String dospeng;
    String judul3;
    int status;

    public Seminar(){ }

    public String getJudul3() {
        return judul3;
    }

    public void setJudul3 (String judul3) {
        this.judul3 = judul3;
    }

    public Seminar(String gambar, String namaMhs, String dospeng, String judul3, int status) {
        this.gambar = gambar;
        this.namaMhs = namaMhs;
        this.dospeng = dospeng;
        this.judul3 = judul3;
        this.status = status;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public String getDospeng() {
        return dospeng;
    }

    public void setDospeng(String dospeng) {
        this.dospeng = dospeng;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
