package com.develovit.sita.datamodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SidangListResponse {

    @SerializedName("seminars")
    private List<SeminarsItem> seminars;

    @SerializedName("count")
    private int count;

    @SerializedName("status")
    private String status;

    public List<SeminarsItem> getSeminars(){
        return seminars;
    }

    public int getCount(){
        return count;
    }

    public String getStatus(){
        return status;
    }
}