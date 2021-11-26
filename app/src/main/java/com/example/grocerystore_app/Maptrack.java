package com.example.grocerystore_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Maptrack extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng> arraylist = new ArrayList<LatLng>();
    LatLng sydney = new LatLng(-34, 151);
    LatLng sikkim = new LatLng(27.2925, 88.3594);
    LatLng delhi = new LatLng(28.384764, 77.3037229);
    LatLng patna = new LatLng(25.6207, 85.1729);
    LatLng calicut = new LatLng(28.384764, 77.3037229);
    LatLng silcher = new LatLng(24.7574, 92.7854);
    LatLng warangle = new LatLng(17.9808, 79.5328);
    LatLng durgapur = new LatLng(23.5483, 87.2914);
    LatLng srinagar = new LatLng(34.1250, 74.8397);
    LatLng trichy = new LatLng(10.763, 78.818);
    LatLng rourkela = new LatLng(22.2492, 82.9161);
    LatLng agartala = new LatLng(23.9667, 91.4167);
    LatLng allahabad = new LatLng(25.4918, 81.8658);
    LatLng seattle = new LatLng(47.6062095, -122.3320708);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maptrack);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.g_map);
        mapFragment.getMapAsync(this);
        arraylist.add(sydney);
        arraylist.add(sikkim);
        arraylist.add(delhi);
        arraylist.add(patna);
        arraylist.add(calicut);
        arraylist.add(silcher);
        arraylist.add(warangle);
        arraylist.add(durgapur);
        arraylist.add(srinagar);
        arraylist.add(trichy);
        arraylist.add(rourkela);
        arraylist.add(agartala);
        arraylist.add(allahabad);
        arraylist.add(seattle);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        for (int i = 0; i < arraylist.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(arraylist.get(i)).title("green basket"));
            // below line is use to add custom marker on our map.


            mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arraylist.get(i)));

        }
    }
}