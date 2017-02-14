package com.example.keepordergo.gps_tester.api_map;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KeeporderGO on 2/1/2017.
 */
public class Route {
    @SerializedName("overview_polyline")
    private OverviewPolyLine overviewPolyLine;

    private List<Legs> legs;

    public OverviewPolyLine getOverviewPolyLine() {
        return overviewPolyLine;
    }

    public List<Legs> getLegs() {
        return legs;
    }
}
