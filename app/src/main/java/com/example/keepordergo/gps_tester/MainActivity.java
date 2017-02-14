package com.example.keepordergo.gps_tester;

import android.Manifest;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements LocationListener, MapsActivity.mapInteraction{

    private static Boolean initLatLng = false;
    MapsActivity mapsActivity;
    private LocationManager locationManager;
    private Button button_refresh;
    private TextView textView_map;
    private TextView textView_time;
    private static double distant = 0.0;
    private Location locationY;
    private Location locationX;
    public String notification = " WAITING SERVICE";
    protected GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        button_refresh = (Button) findViewById(R.id.button_refresh);
        textView_map = (TextView) findViewById(R.id.textView_Map);
        textView_time = (TextView) findViewById(R.id.textView_time);
        button_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });

        // INITIALIZE MAP LOCATION
        locationX = new Location("MY LOCATION HERE !");
        locationX.setLatitude(11.575766);
        locationX.setLongitude(104.889167);

        initLatLng = false;
        if(!initLatLng){
            Log.d("MAP", "STATE LOCATION INITIALIZE HRD CENTER");
            locationY = locationX;
            notification = "INITIALIZE HRD CENTER";
        }

        // Make a request
        onRequest();

        // CALL FRAGMENT
        mapsActivity = new MapsActivity();
        mapsActivity.setMapsActivity(locationY, this);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mContent, mapsActivity).commit();
    }

    public void updateTime(int run) {
        textView_time.setText(
                " RUN : " + run +
                        "\n DATE : " + Calendar.getInstance().getTime());
        if (run >= 0 && run % 10 == 0) {
//            onRefresh();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("MAP", "STATE LOCATION CHANGE");
        this.locationY = location;
        initLatLng = true;
        notification = "CHANGED";
        setDistant(location, locationX);
        onRefresh();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("MAP", "STATE STATUS CHANGE");
        notification = " STATUS " + status;
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("MAP", "STATE PROVIDER ENABLE");
        notification = "GPS ENABLE";
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("MAP", "STATE PROVIDER DISABLE");
        notification = "GPS DISABLE";
    }


    public void onRequest(){
        if(Build.VERSION.SDK_INT >= 23){
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                }, 10);
            }
        }else {
            turnGPSOn();
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 0, this);
    }
    public void onRefresh() {
        textView_map.setText("LOCATION REF" + notification + " DIST :" + getDistant()+
                "\n- LAT : " + locationY.getLatitude() +
                "\n- LAN : " + locationY.getLongitude());
        mapsActivity.setMapsActivity(locationY, this);
    }

    @Override
    public void onMapChange(Location location) {

    }

    private void setDistant(Location l1, Location l2){
        distant = l1.distanceTo(l2);
    }

    private double getDistant(){
        return this.distant;
    }

    private void turnGPSOn() {
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
        boolean statusOfGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(Build.VERSION.SDK_INT < 23 && !statusOfGPS){
            startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 201);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
        boolean statusOfGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(requestCode == 201){
            if(!statusOfGPS){
                if(!statusOfGPS){
                    startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 201);
                }
            }
        }
    }

    public Location getLocationY() {
        return locationY;
    }

    public void setLocationY(Location locationY) {
        this.locationY = locationY;
    }

    public Location getLocationX() {

        return locationX;
    }

    public void setLocationX(Location locationX) {
        this.locationX = locationX;
    }


}
