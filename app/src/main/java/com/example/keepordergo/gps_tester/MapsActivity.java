package com.example.keepordergo.gps_tester;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.keepordergo.gps_tester.api_map.DirectionResults;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import webservice.generators.ServiceMap;
import webservice.services.Map;

public class MapsActivity extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mapView;
    private Location location;
    private Context context;
    private View view;
    private Boolean setMapReady = false;
    private Map.getPolygon polygonService;
    private DirectionResults results;


    public void setMapsActivity(Location location, Context context) {
        this.location = location;
        this.context = context;
        Log.d("DATA SET LAT_LNG F1", " DATA \n-LNG: " + location.getLongitude() + "\n-LAT: " + location.getLatitude());
        if (setMapReady) {
            Log.d("DATA REF LAT_LNG F1", " DATA \n-LNG: " + location.getLongitude() + "\n-LAT: " + location.getLatitude());
            refreshMap(location, "I AM STAND HERE !");
            LatLng MY = new LatLng(location.getLatitude(), location.getLongitude());
            LatLng YOUR = new LatLng(initDefaultLocation().getLatitude(), initDefaultLocation().getLongitude());
            getPolyLine(MY, YOUR);
//            setPolyLineOnMap(decodePoly(results.getRoutes().get(0).getOverviewPolyLine().points));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_maps, container, false);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //MapsInitializer.initialize(context.getApplicationContext());
        mMap = googleMap;
        if (location == null) {
            Log.d("MAP", "STATE LOCATION INITIALIZE II HRD CENTER");
            location = initDefaultLocation();
        }
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        refreshMap(location, "GET LOCATION !");

        Log.d("DATA REPLACE LAT_LNG F1", " DATA \n-LNG: " + latLng.longitude + "\n-LAT: " + latLng.latitude);
        setMapReady = true;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mapView = (MapView) view.findViewById(R.id.mGoogleMap);

        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    void refreshMap(Location location, String title) {
        if (mMap != null) {
            mMap.clear();
        }
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        Log.d("DATA REPLACE LAT_LNG F2", " DATA \n-LNG: " + latLng.longitude + "\n-LAT: " + latLng.latitude);

        mMap.addMarker(mPartnerLocation(initDefaultLocation()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(latLng).title(title));
        CameraPosition cameraPosition = CameraPosition.builder().target(latLng).zoom(16).bearing(0).tilt(45).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private Location initDefaultLocation() {
        Location location = new Location("I AM PROVIDING");
        location.setLatitude(11.5661763);
        location.setLongitude(104.8932169);
        return location;
    }

    private MarkerOptions mPartnerLocation(Location location) {
        return new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title(location.getProvider());
    }

    // Get Line to draw in map
    private void getPolyLine(LatLng F, LatLng T) {
        final String KEY = "AIzaSyDzC7ALlM25YF8fgZ2Gr-elQEQYnRePdc0";
        this.polygonService = ServiceMap.createService(Map.getPolygon.class);
        Log.d("GOOGLE_API", "-- REQUEST --");
        Call<JsonObject> call = this.polygonService.getPolyLineStr(F.latitude + "," + F.longitude, T.latitude + "," + T.longitude, KEY);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Gson gson = new Gson();
                Log.e("rtk", response.body().toString());
                results = new DirectionResults();

                try {
                    if (response.isSuccessful()) {
                        results = gson.fromJson(response.body(), new TypeToken<DirectionResults>() {

                        }.getType());
                        Log.d("GOOGLE_SERVICE", "-- GET --" + response.body());
                        setPolyLineOnMap(decodePoly(results.getRoutes().get(0).getOverviewPolyLine().getPoints()));
                    } else {

                        Log.d("GOOGLE_SERVICE", "-- GET​ NULL--");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("GOOGLE_SERVICE", "-- GET --" + t.getMessage());
            }
        });

    }

    // Convert map code to LAT_LNG LIST
    public ArrayList<LatLng> decodePoly(String encoded) {
        ArrayList<LatLng> poly = new ArrayList<LatLng>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;
        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;
            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng position = new LatLng((double) lat / 1E5, (double) lng / 1E5);
            poly.add(position);
        }
        return poly;
    }

    // Draw Line on MAP
    public void setPolyLineOnMap(ArrayList<LatLng> decodedPath) {
        mMap.addPolyline(new PolylineOptions().addAll(decodedPath).color(Color.parseColor("#C79BBF")).width(20));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
    }

    public interface mapInteraction {
        void onMapChange(Location location);
    }




}
