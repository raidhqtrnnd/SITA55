package com.develovit.sita.datamodel;


import com.google.gson.annotations.SerializedName;

public class LoginResponse{

    @SerializedName("authorisation")
    private com.develovit.sita.datamodel.Authorisation authorisation;

    @SerializedName("user")
    private User user;

    @SerializedName("status")
    private String status;

    public com.develovit.sita.datamodel.Authorisation getAuthorisation(){
        return authorisation;
    }



    public String getStatus(){
        return status;
    }
}
