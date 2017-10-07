package br.com.app.challenge.smart_cities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Date;

import br.com.app.challenge.br.com.app.challenge.model.Incidente;
import br.com.app.challenge.br.com.app.challenge.model.Tipo_De_Incidente;
import br.com.app.challenge.br.com.app.challenge.model.Usuario_Comum;
import br.com.app.challenge.utils.Constants;

public class MainActivity extends AppCompatActivity {

    Usuario_Comum mock_usuario_comum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mock_usuario_comum = new Usuario_Comum("Gustavo", "1234", "João Pessoa");
        Incidente mock_incidente_ambiental = new Incidente(Tipo_De_Incidente.AMBIENTAL, new Date(), "A casa caiu.");
        Incidente mock_incidente_eletrico = new Incidente(Tipo_De_Incidente.ELETRICO, new Date(), "A casa caiu.");
        mock_usuario_comum.addIncidentes(mock_incidente_ambiental);
        mock_usuario_comum.addIncidentes(mock_incidente_eletrico);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,
                mock_usuario_comum.getIncidentesToStringArray());
        ListView myReportsList = (ListView) findViewById(R.id.myReportsList);
        myReportsList.setAdapter(adapter);






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
