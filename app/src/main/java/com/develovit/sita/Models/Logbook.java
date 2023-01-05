package com.develovit.sita.Models;

public class Logbook {

    String tglLog;
    String ketLog;
    int statuslog;

    public Logbook(String tglLog, String ketLog, int statuslog) {
        this.tglLog = tglLog;
        this.ketLog = ketLog;
        this.statuslog = statuslog;
    }

    public Logbook() {}

    public String getTglLog() {
        return tglLog;
    }

    public void setTglLog(String tglLog) {
        this.tglLog = tglLog;
    }

    public String getKetLog() {
        return ketLog;
    }

    public void setKetLog(String ketLog) {
        this.ketLog = ketLog;
    }

    public int getStatuslog() {
        return statuslog;
    }

    public void setStatuslog(int statuslog) {
        this.statuslog = statuslog;
    }
}
