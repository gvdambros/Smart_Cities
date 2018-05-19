package br.com.app.challenge.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.app.challenge.model.CommonUser;
import br.com.app.challenge.utils.Constants;
import br.com.app.challenge.utils.LazyAdapter;

public class ListMyIncidentsActivity extends AppCompatActivity {

    //CommonUser mock_commonUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_incident);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final CommonUser mock_commonUser = Constants.mockCommonUser;

        Integer[] imgid_r = new Integer[mock_commonUser.getMyIncidents().size()];
        Integer[] imgid_l = new Integer[mock_commonUser.getMyIncidents().size()];
        String[]  itemname = new String[mock_commonUser.getMyIncidents().size()];

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
                Intent intent = new Intent(ListMyIncidentsActivity.this, ShowMyIncidentActivity.class);
                intent.putExtra("Incident", mock_commonUser.getMyIncidents().get(position));
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.near_incident) {
            Intent intent = new Intent(ListMyIncidentsActivity.this, NearIncidentActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
