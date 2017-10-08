package br.com.app.challenge.smart_cities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;


public class ActivityCadastroIncidente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_incidente);

        final Button button = (Button)findViewById(R.id.rbCriarIncidente);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });

        final ImageButton ibutton = (ImageButton) findViewById(R.id.ibCamera);
        ibutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent k = new Intent(ActivityCadastroIncidente.this,AndroidCameraApi.class);
                startActivity(k);
            }
        });
    }


    }


