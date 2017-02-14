package com.example.keepordergo.gps_tester.api_map;

import com.google.gson.annotations.SerializedName;

/**
 * Created by KeeporderGO on 2/1/2017.
 */
public class OverviewPolyLine {

    @SerializedName("points")
    public String points;

    public String getPoints() {
        return points;
    }
}
