package com.example.mapsprac;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private EditText latitude;
    private EditText longitude;
    private Button search;
    private Double la=0.0;
    private Double lo=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


        search = (Button) findViewById(R.id.search);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                latitude = (EditText) findViewById(R.id.latitude);
                longitude = (EditText) findViewById(R.id.longitude);


                if(!(latitude.getText().toString().isEmpty() && longitude.getText().toString().isEmpty())) {
                    la = Double.parseDouble(latitude.getText().toString());
                    lo = Double.parseDouble(longitude.getText().toString());
                }
                LatLng place = new LatLng(la, lo);
                mMap.addMarker(new MarkerOptions().position(place).title("Marker in "+la+", "+lo));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
            }
        });
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
}