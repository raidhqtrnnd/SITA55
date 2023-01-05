package com.develovit.sita.Models;

public class ListMhsTa {
    String namaMhs;
    String nim;
    String judulTa;

    public ListMhsTa(){}

    public ListMhsTa(String namaMhs, String judulTa, String pembimbing) {
        this.namaMhs = namaMhs;
        this.nim = nim;
        this.judulTa = judulTa;
    }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public String getJudulTa() {
        return nim;
    }

    public void setJudulTa(String judulTa) {
        this.nim = nim;
    }

    public String getjudul() {
        return judulTa;
    }

    public void setjudul(String pembimbing) {
        this.judulTa = judulTa;
    }
}
