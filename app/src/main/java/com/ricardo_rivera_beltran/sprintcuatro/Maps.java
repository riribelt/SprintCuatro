package com.ricardo_rivera_beltran.sprintcuatro;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import org.osmdroid.util.GeoPoint;
//import android.content.res.Configuration;
import org.osmdroid.config.Configuration;
import org.osmdroid.views.MapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;

public class Maps extends AppCompatActivity {

    private MapView mapView;
    private MapController mapController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapView = (MapView) findViewById(R.id.miMapa);

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        //Toast.makeText(this, "Sale un error con el método getInstance()", Toast.LENGTH_LONG).show();

        mapView.setTileSource(TileSourceFactory.MAPNIK);

        mapView.setBuiltInZoomControls(true);
        mapController = (MapController) mapView.getController();

        GeoPoint florida = new GeoPoint(3.3284723, -76.2418945);

        mapController.setCenter(florida);
        mapController.setZoom(6);
        mapView.setMultiTouchControls(true);
    }
}