package com.example.mytravelapp.controller;

import android.util.Base64;
import android.util.Log;
import com.example.mytravelapp.utilities.Constants;
import com.example.mytravelapp.utilities.Location;
import com.example.mytravelapp.utilities.LocationList;
import com.example.mytravelapp.utilities.OAuthData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.UUID;

public class RESTClient {
    private static final String TAG = RESTClient.class.getSimpleName();
    private final String DEVICE_ID = "device_" + UUID.randomUUID().toString();
    private static RESTClient sInstance;
    private final TrafficInterface trafficInterface;
    private OAuthData oAuth = new OAuthData(DEVICE_ID, "Bearer", 3600, "abc", "abc");

    private RESTClient() {
        // Create and initialize retrofit client here
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(Constants.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        trafficInterface = retrofit.create(TrafficInterface.class);
        createAccessToken();
    }
    public static RESTClient getInstance() {
        if (sInstance == null) {
            sInstance = new RESTClient();
        }
        return sInstance;
    }

    private void createAccessToken() {
        byte[] data = (Constants.API_KEY_VASTTRAFIK + ":" + Constants.API_SECRET_VASTTRAFIK).getBytes();
        String base64token = Base64.encodeToString(data, Base64.NO_WRAP);
        final Call<OAuthData> oAuthDataCall = trafficInterface.getToken("Basic " + base64token, Constants.CLIENT_CREDENTIALS, DEVICE_ID);
        oAuthDataCall.enqueue(new Callback<OAuthData>() {
            @Override
            public void onResponse(Call<OAuthData> call, Response<OAuthData> response) {
                if (response.isSuccessful()) {
                    oAuth = response.body();
                    Log.d(TAG, "onResponse: Access Token = " + oAuth.getAccessToken());
                }
            }

            @Override
            public void onFailure(Call<OAuthData> call, Throwable t) {
                Log.d(TAG, "OAuth failed.");
            }
        });
    }

    private String getAuthToken() {
        return "Bearer " + oAuth.getAccessToken();
    }

    public String getAccessToken(){
        return oAuth.getAccessToken();
    }

    public void getLocations(String name) {
        final Call<Location> locationCall = trafficInterface.getLocationsFromName(getAuthToken(), name);
        locationCall.enqueue(new Callback<Location>() {
            @Override
            public void onResponse(Call<Location> call, Response<Location> response) {
                if (response.isSuccessful()) {
                    LocationList locationList = response.body().getLocationList();
                    Log.i(TAG, "onResponse: " + locationList);
                }
            }

            @Override
            public void onFailure(Call<Location> call, Throwable t) {
                Log.d(TAG, "location.name failed.");
            }
        });
    }
}
