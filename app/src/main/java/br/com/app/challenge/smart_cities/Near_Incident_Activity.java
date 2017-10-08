package br.com.app.challenge.smart_cities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Near_Incident_Activity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_incident);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_view);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.near_incident) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setMinZoomPreference(15);

        LatLng poa = new LatLng(-30.026090, -51.213359);
        map.moveCamera(CameraUpdateFactory.newLatLng(poa));
        map.addMarker(new MarkerOptions().position(poa).title("Poste com luzes quimadas").snippet("Solicitado").
                icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng casaMatheus = new LatLng(-30.033783, -51.222188);
        map.addMarker(new MarkerOptions().position(casaMatheus).title("Árvore Caida na Rua").snippet("Em Atendimento").
                icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng buracoNaRua = new LatLng(-30.024282, -51.214292);
        map.addMarker(new MarkerOptions().position(buracoNaRua).title("Buraco na Via").snippet("Concluido").
                icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE + BitmapDescriptorFactory.HUE_GREEN)));

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
