package com.example.mytravelapp.utilities;

import com.google.gson.annotations.SerializedName;

public class StopLocation {
    @SerializedName("id")
    String tripId;
    @SerializedName("lon")
    String longitude;
    @SerializedName("lat")
    String latitude;
    @SerializedName("idx ")
    String index;
    @SerializedName("weight")
    String weight;
    @SerializedName("name")
    String stationName;
    @SerializedName("track")
    String track;

    public StopLocation(String id, String lon, String lat, String idx, String weight, String name, String track) {
        this.tripId = id;
        this.longitude = lon;
        this.latitude = lat;
        this.index = idx;
        this.weight = weight;
        this.stationName = name;
        this.track = track;
    }

    public String getTripId() {
        return tripId;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getIndex() {
        return index;
    }

    public String getWeight() {
        return weight;
    }

    public String getStationName() {
        return stationName;
    }

    public String getTrack() {
        return track;
    }
}
