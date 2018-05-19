
package br.com.app.challenge.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

import br.com.app.challenge.service.CommonUserService;

/**
 * Created by gvdambros on 10/8/17.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button list_incident_button = (Button) findViewById(R.id.list_incident_button);
        list_incident_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListMyIncidentsActivity.class);
                startActivity(intent);
            }
        });

        Button new_incident_button = (Button) findViewById(R.id.new_incident_button);
        new_incident_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterIncidentActivity.class);
                startActivity(intent);
            }
        });

        Button near_incident_button = (Button) findViewById(R.id.near_incident_button);
        near_incident_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NearIncidentActivity.class);
                startActivity(intent);
            }
        });

        Map map = new HashMap<String, String>();
        map.put("email", "gustavo@wow.com.br");
        map.put("password", "1234");
        map.put("name", "gustavo@wow.com.br");
        map.put("phone", "123456789");
        map.put("experience", "1");

        CommonUserService commonUserService = new CommonUserService();
        commonUserService.login( map );
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