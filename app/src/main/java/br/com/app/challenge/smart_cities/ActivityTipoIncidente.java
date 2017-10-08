package br.com.app.challenge.smart_cities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class ActivityTipoIncidente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tipo_incidente);

        final Button button = (Button)findViewById(R.id.btConfirmar);
        final RadioButton rb;
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent k = new Intent(ActivityTipoIncidente.this, ActivityCadastroIncidente.class);
                startActivity(k);
            }
        });




    }



}
