package com.example.mytravelapp.controller;

import com.example.mytravelapp.utilities.Location;
import com.example.mytravelapp.utilities.LocationList;
import com.example.mytravelapp.utilities.OAuthData;
import retrofit2.Call;
import retrofit2.http.*;

public interface TrafficInterface {
    @FormUrlEncoded
    @POST("token")
    Call<OAuthData> getToken(@Header("Authorization") String base64Token, @Field("grant_type") String grantType, @Field("scope") String scope);

    @GET("bin/rest.exe/v2/location.name?format=json")
    Call<Location> getLocationsFromName(@Header("Authorization") String authToken, @Query("input") String name);
}
