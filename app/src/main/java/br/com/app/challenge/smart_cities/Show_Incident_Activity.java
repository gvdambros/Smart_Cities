package br.com.app.challenge.smart_cities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;

import br.com.app.challenge.model.Incidente;
import br.com.app.challenge.model.Tipo_De_Incidente;
import br.com.app.challenge.utils.Constants;

public class Show_Incident_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_incident);
        TextView nome = (TextView) findViewById(R.id.user_name);
        nome.setText(Constants._user_name);
        RatingBar nivel = (RatingBar) findViewById(R.id.user_level);
        nivel.setRating(Constants._user_rate);
        TextView status = (TextView) findViewById(R.id.status_text);
        Incidente mock_incident = new Incidente(Tipo_De_Incidente.AMBIENTAL, new Date(), "a casa caiu");
        status.setText(mock_incident.toString());

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
