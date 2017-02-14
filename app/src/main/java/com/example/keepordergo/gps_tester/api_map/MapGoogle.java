package com.example.keepordergo.gps_tester.api_map;

import com.google.android.gms.maps.model.Polyline;
import com.google.gson.annotations.SerializedName;

import java.sql.Types;
import java.util.List;

/**
 * Created by KeeporderGO on 2/1/2017.
 */

public class MapGoogle {

    @SerializedName("geocoded_waypoints")
    private List<Geocoded_waypoints> geocoded_waypoints;
    @SerializedName("routes")
    private List<Routes> routes;
    @SerializedName("status")
    private String status;

    public List<Geocoded_waypoints> getGeocoded_waypoints() {
        return geocoded_waypoints;
    }

    public void setGeocoded_waypoints(List<Geocoded_waypoints> geocoded_waypoints) {
        this.geocoded_waypoints = geocoded_waypoints;
    }

    public List<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Geocoded_waypoints {
        @SerializedName("geocoder_status")
        private String geocoder_status;
        @SerializedName("place_id")
        private String place_id;
        @SerializedName("types")
        private List<Types> types;

        public String getGeocoder_status() {
            return geocoder_status;
        }

        public void setGeocoder_status(String geocoder_status) {
            this.geocoder_status = geocoder_status;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public List<Types> getTypes() {
            return types;
        }

        public void setTypes(List<Types> types) {
            this.types = types;
        }
    }

    public static class Northeast {
        @SerializedName("lat")
        private double lat;
        @SerializedName("lng")
        private double lng;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }
    }

    public static class Southwest {
        @SerializedName("lat")
        private double lat;
        @SerializedName("lng")
        private double lng;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }
    }

    public static class Bounds {
        @SerializedName("northeast")
        private Northeast northeast;
        @SerializedName("southwest")
        private Southwest southwest;

        public Northeast getNortheast() {
            return northeast;
        }

        public void setNortheast(Northeast northeast) {
            this.northeast = northeast;
        }

        public Southwest getSouthwest() {
            return southwest;
        }

        public void setSouthwest(Southwest southwest) {
            this.southwest = southwest;
        }
    }

    public static class Distance {
        @SerializedName("text")
        private String text;
        @SerializedName("value")
        private int value;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static class Duration {
        @SerializedName("text")
        private String text;
        @SerializedName("value")
        private int value;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static class End_location {
        @SerializedName("lat")
        private double lat;
        @SerializedName("lng")
        private double lng;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }
    }

    public static class Start_location {
        @SerializedName("lat")
        private double lat;
        @SerializedName("lng")
        private double lng;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }
    }

//    public static class Distance {
//        @SerializedName("text")
//        private String text;
//        @SerializedName("value")
//        private int value;
//
//        public String getText() {
//            return text;
//        }
//
//        public void setText(String text) {
//            this.text = text;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//    }

//    public static class Duration {
//        @SerializedName("text")
//        private String text;
//        @SerializedName("value")
//        private int value;
//
//        public String getText() {
//            return text;
//        }
//
//        public void setText(String text) {
//            this.text = text;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//    }

//    public static class End_location {
//        @SerializedName("lat")
//        private double lat;
//        @SerializedName("lng")
//        private double lng;
//
//        public double getLat() {
//            return lat;
//        }
//
//        public void setLat(double lat) {
//            this.lat = lat;
//        }
//
//        public double getLng() {
//            return lng;
//        }
//
//        public void setLng(double lng) {
//            this.lng = lng;
//        }
//    }
//
//    public static class Polyline {
//        @SerializedName("points")
//        private String points;
//
//        public String getPoints() {
//            return points;
//        }
//
//        public void setPoints(String points) {
//            this.points = points;
//        }
//    }

//    public static class Start_location {
//        @SerializedName("lat")
//        private double lat;
//        @SerializedName("lng")
//        private double lng;
//
//        public double getLat() {
//            return lat;
//        }
//
//        public void setLat(double lat) {
//            this.lat = lat;
//        }
//
//        public double getLng() {
//            return lng;
//        }
//
//        public void setLng(double lng) {
//            this.lng = lng;
//        }
//    }

    public static class Steps {
        @SerializedName("distance")
        private Distance distance;
        @SerializedName("duration")
        private Duration duration;
        @SerializedName("end_location")
        private End_location end_location;
        @SerializedName("html_instructions")
        private String html_instructions;
        @SerializedName("polyline")
        private Polyline polyline;
        @SerializedName("start_location")
        private Start_location start_location;
        @SerializedName("travel_mode")
        private String travel_mode;

        public Distance getDistance() {
            return distance;
        }

        public void setDistance(Distance distance) {
            this.distance = distance;
        }

        public Duration getDuration() {
            return duration;
        }

        public void setDuration(Duration duration) {
            this.duration = duration;
        }

        public End_location getEnd_location() {
            return end_location;
        }

        public void setEnd_location(End_location end_location) {
            this.end_location = end_location;
        }

        public String getHtml_instructions() {
            return html_instructions;
        }

        public void setHtml_instructions(String html_instructions) {
            this.html_instructions = html_instructions;
        }

        public Polyline getPolyline() {
            return polyline;
        }

        public void setPolyline(Polyline polyline) {
            this.polyline = polyline;
        }

        public Start_location getStart_location() {
            return start_location;
        }

        public void setStart_location(Start_location start_location) {
            this.start_location = start_location;
        }

        public String getTravel_mode() {
            return travel_mode;
        }

        public void setTravel_mode(String travel_mode) {
            this.travel_mode = travel_mode;
        }
    }

    public static class Traffic_speed_entry {
    }

    public static class Via_waypoint {
    }

    public static class Legs {
        @SerializedName("distance")
        private Distance distance;
        @SerializedName("duration")
        private Duration duration;
        @SerializedName("end_address")
        private String end_address;
        @SerializedName("end_location")
        private End_location end_location;
        @SerializedName("start_address")
        private String start_address;
        @SerializedName("start_location")
        private Start_location start_location;
        @SerializedName("steps")
        private List<Steps> steps;
        @SerializedName("traffic_speed_entry")
        private List<Traffic_speed_entry> traffic_speed_entry;
        @SerializedName("via_waypoint")
        private List<Via_waypoint> via_waypoint;

        public Distance getDistance() {
            return distance;
        }

        public void setDistance(Distance distance) {
            this.distance = distance;
        }

        public Duration getDuration() {
            return duration;
        }

        public void setDuration(Duration duration) {
            this.duration = duration;
        }

        public String getEnd_address() {
            return end_address;
        }

        public void setEnd_address(String end_address) {
            this.end_address = end_address;
        }

        public End_location getEnd_location() {
            return end_location;
        }

        public void setEnd_location(End_location end_location) {
            this.end_location = end_location;
        }

        public String getStart_address() {
            return start_address;
        }

        public void setStart_address(String start_address) {
            this.start_address = start_address;
        }

        public Start_location getStart_location() {
            return start_location;
        }

        public void setStart_location(Start_location start_location) {
            this.start_location = start_location;
        }

        public List<Steps> getSteps() {
            return steps;
        }

        public void setSteps(List<Steps> steps) {
            this.steps = steps;
        }

        public List<Traffic_speed_entry> getTraffic_speed_entry() {
            return traffic_speed_entry;
        }

        public void setTraffic_speed_entry(List<Traffic_speed_entry> traffic_speed_entry) {
            this.traffic_speed_entry = traffic_speed_entry;
        }

        public List<Via_waypoint> getVia_waypoint() {
            return via_waypoint;
        }

        public void setVia_waypoint(List<Via_waypoint> via_waypoint) {
            this.via_waypoint = via_waypoint;
        }
    }

    public static class Overview_polyline {
        @SerializedName("points")
        private String points;

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }
    }

    public static class Warnings {
    }

    public static class Waypoint_order {
    }

    public static class Routes {
        @SerializedName("bounds")
        private Bounds bounds;
        @SerializedName("copyrights")
        private String copyrights;
        @SerializedName("legs")
        private List<Legs> legs;
        @SerializedName("overview_polyline")
        private Overview_polyline overview_polyline;
        @SerializedName("summary")
        private String summary;
        @SerializedName("warnings")
        private List<Warnings> warnings;
        @SerializedName("waypoint_order")
        private List<Waypoint_order> waypoint_order;

        public Bounds getBounds() {
            return bounds;
        }

        public void setBounds(Bounds bounds) {
            this.bounds = bounds;
        }

        public String getCopyrights() {
            return copyrights;
        }

        public void setCopyrights(String copyrights) {
            this.copyrights = copyrights;
        }

        public List<Legs> getLegs() {
            return legs;
        }

        public void setLegs(List<Legs> legs) {
            this.legs = legs;
        }

        public Overview_polyline getOverview_polyline() {
            return overview_polyline;
        }

        public void setOverview_polyline(Overview_polyline overview_polyline) {
            this.overview_polyline = overview_polyline;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<Warnings> getWarnings() {
            return warnings;
        }

        public void setWarnings(List<Warnings> warnings) {
            this.warnings = warnings;
        }

        public List<Waypoint_order> getWaypoint_order() {
            return waypoint_order;
        }

        public void setWaypoint_order(List<Waypoint_order> waypoint_order) {
            this.waypoint_order = waypoint_order;
        }
    }
}
