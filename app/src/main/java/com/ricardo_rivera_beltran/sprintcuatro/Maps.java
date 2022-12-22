package com.ricardo_rivera_beltran.sprintcuatro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.osmdroid.views.MapView;

public class Maps extends AppCompatActivity {

    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }
}