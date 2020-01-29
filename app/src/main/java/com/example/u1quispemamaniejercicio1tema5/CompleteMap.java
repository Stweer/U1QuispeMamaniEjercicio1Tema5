package com.example.u1quispemamaniejercicio1tema5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;

import java.util.ArrayList;
import java.util.List;

public class CompleteMap extends FragmentActivity implements GoogleMap.OnMapLoadedCallback, GoogleMap.OnCameraIdleListener, GoogleMap.OnInfoWindowClickListener {

    GoogleMap map;
    LatLng latLngP,latLng2P,latLng3P;
    LatLng latLngC,latLng2C,latLng3C;
    LatLng latLngA,latLng2A,latLng3A;
    LatLng latLngR,latLng2R,latLng3R;
    Button btn1,btn2,btn3,btn4;

    Polygon polygonR=null,polygonC=null,polygonA=null,polygonP=null;

    List<LatLng> latLngListP = new ArrayList<>();
    List<Marker> markerListP = new ArrayList<>();

    List<LatLng> latLngListC = new ArrayList<>();
    List<Marker> markerListC = new ArrayList<>();


    List<LatLng> latLngListA = new ArrayList<>();
    List<Marker> markerListA = new ArrayList<>();

    List<LatLng> latLngListR = new ArrayList<>();
    List<Marker> markerListR = new ArrayList<>();

    ArrayList<Marker> markers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_map);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
    }
}
