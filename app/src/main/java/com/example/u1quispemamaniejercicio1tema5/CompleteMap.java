package com.example.u1quispemamaniejercicio1tema5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.ArrayList;
import java.util.List;

public class CompleteMap extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnInfoWindowLongClickListener {
    GoogleMap mapa;
    LatLng ubicacion_rectorado ,ubicacion_rectorado_1 ,ubicacion_rectorado_2;
    LatLng ubicacion_campus, ubicacion_campus_1,ubicacion_campus_2;
    LatLng ubicacion_admision,ubicacion_admision_1,ubicacion_admision_2;
    LatLng ubicacion_posgrado,ubicacion_posgrado_1,ubicacion_posgrado_2;

    Polygon polygon_rectorado = null;
    Polygon polygon_campus = null;
    Polygon polygon_admision = null;
    Polygon polygon_posgrado = null;

    //Latitudes en Listas
    List<LatLng> latLngList = new ArrayList<>();
    List<Marker> markerList = new ArrayList<>();

    List<LatLng> latLngListCampus = new ArrayList<>();
    List<Marker> markerListCampus = new ArrayList<>();

    List<LatLng> latLngListAdmision = new ArrayList<>();
    List<Marker> markerListAdmision = new ArrayList<>();

    List<LatLng> latLngListPosgrado = new ArrayList<>();
    List<Marker> markerListPosgrado = new ArrayList<>();
    ArrayList<Marker> markers = new ArrayList<>();

    // Botones de utilizacion
    Button btncentrar, btnposgrado, btnrectorado, btnadmision, btncampus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_map);
        btncentrar = findViewById(R.id.btncentrar);
        btnposgrado = findViewById(R.id.btn1);
        btnrectorado = findViewById(R.id.btn4);
        btnadmision = findViewById(R.id.btn3);
        btncampus = findViewById(R.id.btn2);

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

        btncentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.007633, -70.239271), 14));
            }
        });

        btnrectorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.009333, -70.242931), 20));
                CameraPosition position = mapa.getCameraPosition();
                float zoom = position.zoom;
                mapa.addMarker(new MarkerOptions()
                        .position(mapa.getCameraPosition().target)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker_20))
                        .title("Rectorado"))
                        ;

            }
        });

        btnposgrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.005129, -70.235149), 18));
                mapa.addMarker(new MarkerOptions()
                        .position(mapa.getCameraPosition().target)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker_20))
                        .title("Posgrado"))
                        ;
            }
        });

        btnadmision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.013522, -70.250260), 20));
                mapa.addMarker(new MarkerOptions()
                        .position(mapa.getCameraPosition().target)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker_20))
                        .title("Admision"))
                        ;
            }
        });

        btncampus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.005694, -70.225477), 18));
                mapa.addMarker(new MarkerOptions()
                        .position(mapa.getCameraPosition().target)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker_20))
                        .title("Campus"))
                        ;

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Ubicacion de rectorado con sus putos
        mapa = googleMap;
        ubicacion_rectorado = new LatLng(-18.009265, -70.242981);
        ubicacion_rectorado_1 = new LatLng(-18.009265, -70.242854);
        ubicacion_rectorado_2 = new LatLng(-18.009402, -70.242960);

        MarkerOptions markerOptionsrectorado = new MarkerOptions().position(ubicacion_rectorado);
        MarkerOptions markerOptions1rectorado = new MarkerOptions().position(ubicacion_rectorado_1);
        MarkerOptions markerOptions2rectorado = new MarkerOptions().position(ubicacion_rectorado_2);

        Marker markerrectorado = mapa.addMarker(markerOptionsrectorado);
        Marker markerrectorado1 = mapa.addMarker(markerOptions1rectorado);
        Marker markerrectorado2 = mapa.addMarker(markerOptions2rectorado);
        latLngList.add(ubicacion_rectorado);
        latLngList.add(ubicacion_rectorado_1);
        latLngList.add(ubicacion_rectorado_2);
        markerList.add(markerrectorado);
        markerList.add(markerrectorado1);
        markerList.add(markerrectorado2);

        //Marker encerrado con ubicacion respectiva

        //Ubicacion de Campus

        ubicacion_campus = new LatLng(-18.005674, -70.225914);
        ubicacion_campus_1 = new LatLng(-18.005159, -70.225230);
        ubicacion_campus_2 = new LatLng(-18.005945, -70.225321);

        MarkerOptions markerOptionscampus = new MarkerOptions().position(ubicacion_campus);
        MarkerOptions markerOptions1campus = new MarkerOptions().position(ubicacion_campus_1);
        MarkerOptions markerOptions2campus = new MarkerOptions().position(ubicacion_campus_2);

        Marker markercampus1 = mapa.addMarker(markerOptions1campus);
        Marker markercampus2 = mapa.addMarker(markerOptions2campus);
        Marker markercampus = mapa.addMarker(markerOptionscampus);
        latLngListCampus.add(ubicacion_campus);
        latLngListCampus.add(ubicacion_campus_1);
        latLngListCampus.add(ubicacion_campus_2);
        markerListCampus.add(markercampus);
        markerListCampus.add(markercampus2);
        markerListCampus.add(markercampus1);

        //Ubicacion de Admision

        ubicacion_admision = new LatLng(-18.013515, -70.250327);
        ubicacion_admision_1= new LatLng(-18.013565, -70.250213);
        ubicacion_admision_2 = new LatLng(-18.013464, -70.250233);

        MarkerOptions markerOptionsadmision = new MarkerOptions().position(ubicacion_admision);
        MarkerOptions markerOptions1admision = new MarkerOptions().position(ubicacion_admision_1);
        MarkerOptions markerOptions2admision = new MarkerOptions().position(ubicacion_admision_2);
        Marker markeradmision1 = mapa.addMarker(markerOptionsadmision);
        Marker markeradmision2 = mapa.addMarker(markerOptions1admision);
        Marker markeradmision = mapa.addMarker(markerOptions2admision);
        latLngListAdmision.add(ubicacion_admision);
        latLngListAdmision.add(ubicacion_admision_1);
        latLngListAdmision.add(ubicacion_admision_2);
        markerListAdmision.add(markeradmision);
        markerListAdmision.add(markeradmision2);
        markerListAdmision.add(markeradmision1);

        //Ubicacion Posgrado

        ubicacion_posgrado = new LatLng(-18.005197, -70.235027);
        ubicacion_posgrado_1= new LatLng(-18.005130, -70.235448);
        ubicacion_posgrado_2 = new LatLng(-18.004923, -70.235043);

        MarkerOptions markerOptionpos = new MarkerOptions().position(ubicacion_posgrado);
        MarkerOptions markerOption1pos = new MarkerOptions().position(ubicacion_posgrado_1);
        MarkerOptions markerOption2pos = new MarkerOptions().position(ubicacion_posgrado_2);
        Marker markerpos1 = mapa.addMarker(markerOptionpos);
        Marker markerpos2 = mapa.addMarker(markerOption1pos);
        Marker markerpos = mapa.addMarker(markerOption2pos);
        latLngListPosgrado.add(ubicacion_posgrado);
        latLngListPosgrado.add(ubicacion_posgrado_1);
        latLngListPosgrado.add(ubicacion_posgrado_2);
        markerListPosgrado.add(markerpos);
        markerListPosgrado.add(markerpos2);
        markerListPosgrado.add(markerpos1);


        if (!latLngList.isEmpty()) {
            PolygonOptions polygonOptions = new PolygonOptions()
                    .addAll(latLngList).clickable(true);
            polygon_rectorado = mapa.addPolygon(polygonOptions);
            polygon_rectorado.setStrokeColor(Color.rgb(255, 0, 0));
        }

        if (!latLngListCampus.isEmpty()) {
            PolygonOptions polygonOptions = new PolygonOptions()
                    .addAll(latLngListCampus).clickable(true);
            polygon_campus = mapa.addPolygon(polygonOptions);
            polygon_campus.setStrokeColor(Color.rgb(255, 0, 0));
        }

        if (!latLngListAdmision.isEmpty()) {
            PolygonOptions polygonOptions = new PolygonOptions()
                    .addAll(latLngListAdmision).clickable(true);
            polygon_admision = mapa.addPolygon(polygonOptions);
            polygon_admision.setStrokeColor(Color.rgb(255, 0, 0));
        }

        if (!latLngListPosgrado.isEmpty()) {
            PolygonOptions polygonOptions = new PolygonOptions()
                    .addAll(latLngListPosgrado).clickable(true);
            polygon_posgrado = mapa.addPolygon(polygonOptions);
            polygon_posgrado.setStrokeColor(Color.rgb(255, 0, 0));
        }


        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.013240, -70.250091), 13));
        mapa.setOnInfoWindowLongClickListener(this);
    }

    @Override
    public void onInfoWindowLongClick(Marker markerListCampus) {

    }



    public void CENTRARTOTAL(View view){
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.007633, -70.239271), 14));

    }



    @Override public void onMapClick(LatLng puntoPulsado) {
        mapa.addMarker(new MarkerOptions().position(puntoPulsado)
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
    }
}
