package br.com.app.challenge.smart_cities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Date;

import br.com.app.challenge.model.Incident;
import br.com.app.challenge.model.IncidentType;
import br.com.app.challenge.model.CommonUser;
import br.com.app.challenge.utils.Constants;
import br.com.app.challenge.utils.LazyAdapter;

public class List_Incident_Activity extends AppCompatActivity {

    //CommonUser mock_commonUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_incident);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final CommonUser mock_commonUser = Constants.mock_usuario_comun;
        Incident mock_incident_ambiental = new Incident(IncidentType.TRANSPORTE, new Date(), "A casa caiu.", mock_commonUser.getName(), R.drawable.street_hole);
        Incident mock_incident_eletrico = new Incident(IncidentType.ELETRICO, new Date(), "A casa caiu.", mock_commonUser.getName(), R.drawable.street_blackout);
        mock_commonUser.addIncidentes(mock_incident_ambiental);
        mock_commonUser.addIncidentes(mock_incident_eletrico);

        Integer[] imgid_r;
        Integer[] imgid_l;
        String[] itemname;

        imgid_r = new Integer[mock_commonUser.getMyIncidents().size()];
        imgid_l = new Integer[mock_commonUser.getMyIncidents().size()];
        itemname = new String[mock_commonUser.getMyIncidents().size()];

        for(int i = 0; i < mock_commonUser.getMyIncidents().size(); i++){
            imgid_r[i] = mock_commonUser.getMyIncidents().get(i).getStatus().toIconID();
            imgid_l[i] = mock_commonUser.getMyIncidents().get(i).getType().toIconID();
            itemname[i] = mock_commonUser.getMyIncidents().get(i).getType().toString();
        }

        LazyAdapter adapter = new LazyAdapter(this, itemname, imgid_l, imgid_r);
        ListView myReportsList = (ListView) findViewById(R.id.myReportsList);
        myReportsList.setAdapter(adapter);

        myReportsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(List_Incident_Activity.this, Show_Incident_Activity.class);
                //mock_commonUser.getMyIncidents().get(position).setStatus(IncidentStatus.CONLUIDO);
                intent.putExtra("Incident", mock_commonUser.getMyIncidents().get(position));
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
