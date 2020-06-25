package com.example.mytravelapp.utilities;

import com.google.gson.annotations.SerializedName;

public class CoordLocation {
    @SerializedName("lon")
    String longitude;
    @SerializedName("lat")
    String latitude;
    @SerializedName("idx ")
    String index;
    @SerializedName("name")
    String name;
    @SerializedName("type")
    String locationType;

    public CoordLocation(String lon, String lat, String index, String name, String type) {
        this.latitude = lat;
        this.longitude = lon;
        this.index = index;
        this.name = name;
        this.locationType = type;
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

    public String getName() {
        return name;
    }

    public String getLocationType() {
        return locationType;
    }
}
