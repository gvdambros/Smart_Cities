package br.com.app.challenge.smart_cities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Date;

public class Register_Incident_Activity extends AppCompatActivity implements OnMapReadyCallback
{
    GoogleMap map;

    String[] tiposDeIncidentes = {"Elétrico", "Ambiental", "Lixo Urbano", "Saneamento", "Transporte"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_incidente);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Register_Incident_Activity.this, android.R.layout.simple_list_item_1, tiposDeIncidentes);
        AutoCompleteTextView actvTipoIncidente = (AutoCompleteTextView) findViewById(R.id.actvTipoIncidente);
        actvTipoIncidente.setAdapter(arrayAdapter);

        final Button button = (Button)findViewById(R.id.rbCriarIncidente);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
            Date dia_do_incidente = new Date();
            //Incidente incidente = new Incidente(Tipo_De_Incidente.ELETRICO, dia_do_incidente, "Fios caidos");
                //  Constants.mock_usuario_comum.addIncidentes(incidente);
            }
        });
        final ImageButton ibutton = (ImageButton) findViewById(R.id.ibCamera);
        ibutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent k = new Intent(Register_Incident_Activity.this,Photograph_Incident_Activity.class);
                startActivity(k);
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
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
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng poa = new LatLng(-30.026090, -51.213359);
        map.setMinZoomPreference(15);
        map.addMarker(new MarkerOptions().position(poa).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLng(poa));
    }

}



