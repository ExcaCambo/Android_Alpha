package com.example.keepordergo.gps_tester.api_map;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KeeporderGO on 2/1/2017.
 */
public class DirectionResults {
    @SerializedName("routes")
    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }
}

