package com.develovit.sita.retrofit;

import com.develovit.sita.datamodel.LoginResponse;
import com.develovit.sita.datamodel.LogoutResponse;
import com.develovit.sita.datamodel.ProfilResponse;
import com.develovit.sita.datamodel.SeminarListResponse;
import com.develovit.sita.datamodel.SidangListResponse;
import com.develovit.sita.datamodel.Student;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface StoryClient {

    @FormUrlEncoded
    @POST("/api/login")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);


    @GET("/api/admin/thesis/seminar-submissions")
    Call<SeminarListResponse> getPermintaanSeminar(
            @Header("Authorization") String token
    );

    @GET("api/admin/thesis/trial-submissions")
    Call<SidangListResponse> getPermintaanSidang(
            @Header("Authorization") String token
    );


//    @GET("api/theses/{id}/trials")
//    Call<DetailSidangResponse> getDetailSidang(
//            @Header("Authorization") String token,
//            @Path("id") int groupId
//    );


    @POST("/api/logout")
    Call<LogoutResponse> logout(@Header("Authorization") String token);


}
