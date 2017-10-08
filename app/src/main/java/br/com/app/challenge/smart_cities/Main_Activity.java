
package br.com.app.challenge.smart_cities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.Date;

import br.com.app.challenge.model.Incidente;
import br.com.app.challenge.model.Status_Do_Incidente;
import br.com.app.challenge.model.Tipo_De_Incidente;
import br.com.app.challenge.model.Usuario_Comum;

/**
 * Created by gvdambros on 10/8/17.
 */

public class Main_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button list_incident_button = (Button) findViewById(R.id.list_incident_button);
        list_incident_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Activity.this, List_Incident_Activity.class);
                startActivity(intent);
            }
        });

        Button new_incident_button = (Button) findViewById(R.id.new_incident_button);
        new_incident_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Activity.this, ActivityTipoIncidente.class);
                startActivity(intent);
            }
        });

        Button near_incident_button = (Button) findViewById(R.id.near_incident_button);
        near_incident_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Activity.this, Near_Incident_Activity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.near_incident) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}