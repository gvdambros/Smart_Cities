package br.com.app.challenge.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.app.challenge.model.Incident;

public class ShowMyIncidentActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_incident);
        TextView description = (TextView) findViewById(R.id.incident_description);

        Incident mock_incident = (Incident) getIntent().getSerializableExtra("Incident");
        description.setText(mock_incident.getDescription());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_view);
        mapFragment.getMapAsync(this);

        ImageView foto = (ImageView) findViewById(R.id.user_photo_view);
        foto.setImageDrawable( resize( getDrawable(R.drawable.user_photo) ) );

        ImageView incidentPhoto = (ImageView) findViewById(R.id.incident_photo_view);
        incidentPhoto.setImageDrawable( resize( getDrawable(mock_incident.getPhoto()) ) );

        TextView user_name_view = (TextView) findViewById(R.id.incident_type);
        user_name_view.setText(mock_incident.getType().toString());

        TextView user_mail_view = (TextView) findViewById(R.id.incident_author);
        user_mail_view.setText("Incident criado por " + mock_incident.getAutor());

    }

    private Drawable resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 50, 50, false);
        return new BitmapDrawable(getResources(), bitmapResized);
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
            // talvez seja pai do show
            Intent intent = new Intent(Show_Incident_Activity.this, Near_Incident_Activity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
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
