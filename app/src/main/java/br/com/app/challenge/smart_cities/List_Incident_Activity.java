package br.com.app.challenge.smart_cities;

import android.content.Intent;
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

import java.util.Date;

import br.com.app.challenge.model.Incidente;
import br.com.app.challenge.model.Status_Do_Incidente;
import br.com.app.challenge.model.Tipo_De_Incidente;
import br.com.app.challenge.model.Usuario_Comum;
import br.com.app.challenge.utils.LazyAdapter;

public class List_Incident_Activity extends AppCompatActivity {

    Usuario_Comum mock_usuario_comum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_incident);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mock_usuario_comum = new Usuario_Comum("Gustavo", "1234", "João Pessoa");
        Incidente mock_incidente_ambiental = new Incidente(Tipo_De_Incidente.RUAS_E_CALCADAS, new Date(), "Buraco na rua", "A casa caiu.", mock_usuario_comum.getNome());
        Incidente mock_incidente_eletrico = new Incidente(Tipo_De_Incidente.ELETRICO, new Date(), "Falta de luz na rua", "A casa caiu.", mock_usuario_comum.getNome());
        mock_usuario_comum.addIncidentes(mock_incidente_ambiental);
        mock_usuario_comum.addIncidentes(mock_incidente_eletrico);

        Integer[] imgid_r;
        Integer[] imgid_l;
        String[] itemname;

        imgid_r = new Integer[mock_usuario_comum.getMeus_incidentes().size()];
        imgid_l = new Integer[mock_usuario_comum.getMeus_incidentes().size()];
        itemname = new String[mock_usuario_comum.getMeus_incidentes().size()];

        for(int i = 0; i < mock_usuario_comum.getMeus_incidentes().size(); i++){
            imgid_r[i] = mock_usuario_comum.getMeus_incidentes().get(i).getStatus().toIconID();
            imgid_l[i] = mock_usuario_comum.getMeus_incidentes().get(i).getTipo().toIconID();
            itemname[i] = mock_usuario_comum.getMeus_incidentes().get(i).getTipo().toString();
        }

        LazyAdapter adapter = new LazyAdapter(this, itemname, imgid_l, imgid_r);
        ListView myReportsList = (ListView) findViewById(R.id.myReportsList);
        myReportsList.setAdapter(adapter);

        myReportsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(List_Incident_Activity.this, Show_Incident_Activity.class);
                mock_usuario_comum.getMeus_incidentes().get(position).setStatus(Status_Do_Incidente.CONLUIDO);
                intent.putExtra("Incident", mock_usuario_comum.getMeus_incidentes().get(position));
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
            Intent intent = new Intent(List_Incident_Activity.this, Near_Incident_Activity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
