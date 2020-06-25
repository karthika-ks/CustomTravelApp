package com.example.mytravelapp.utilities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocationList {
    @SerializedName("errorText")
    String errorText;
    @SerializedName("error")
    String error;
    @SerializedName("serverdate")
    String serverDate;
    @SerializedName("servertime")
    String serverTime;
    @SerializedName("StopLocation")
    List<StopLocation> stopLocations;
    @SerializedName("CoordLocation")
    List<CoordLocation> coordLocations;

    public LocationList(String errorText, String error, String serverDate, String serverTime, List<StopLocation> stopLocation, List<CoordLocation> coordLocation) {
        this.errorText = errorText;
        this.error = error;
        this.serverDate = serverDate;
        this.serverTime = serverTime;
        this.stopLocations = stopLocation;
        this.coordLocations = coordLocation;
    }

    public String getErrorText() {
        return errorText;
    }

    public String getError() {
        return error;
    }

    public String getServerDate() {
        return serverDate;
    }

    public String getServerTime() {
        return serverTime;
    }

    public List<StopLocation> getStopLocations() {
        return stopLocations;
    }

    public List<CoordLocation> getCoordLocations() {
        return coordLocations;
    }
}
