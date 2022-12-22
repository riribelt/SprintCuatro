package com.ricardo_rivera_beltran.sprintcuatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

public class Maps extends AppCompatActivity {

    private MapView myOpenMapView;
    private MapController myMapController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //map = (MapView) findViewById(R.id.openmapview);
        GeoPoint florida = new GeoPoint(3.3284723, -76.2418945);

        myOpenMapView = (MapView)findViewById(R.id.openmapview);
        myOpenMapView.setBuiltInZoomControls(true);
        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(florida);
        myMapController.setZoom(6);

        myOpenMapView.setMultiTouchControls(true);

        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences())
    }
}