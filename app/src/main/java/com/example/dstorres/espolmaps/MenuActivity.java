package com.example.dstorres.espolmaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dstorres.espolmaps.load_src.GifRun;


/**
 * Created by dstorres on 27/05/2016.
 */
public class MenuActivity  extends AppCompatActivity {
    private Button ib_menu_b = null;
    private Button ib_menu_l = null;
    private Button ib_menu_a = null;
    private Button ib_menu_i = null;
    private Intent rutasActivity= null;
    private Intent acerActivity= null;
    private Intent infoActivity= null;
    private GifRun w;
    private SurfaceView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        v= (SurfaceView) findViewById(R.id.surfaceView);
        ib_menu_b = (Button)findViewById(R.id.ButtonUbicacion);
        ib_menu_l = (Button)findViewById(R.id.imageButtonLista);
        ib_menu_a = (Button)findViewById(R.id.ButtonAcercade);
        ib_menu_i = (Button)findViewById(R.id.imageButtonInfo);

        w = new GifRun();
        w.LoadGiff(v,this,R.drawable.one_piece);

        ib_menu_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuActivity.this, "Pulsaste el boton de buscar", Toast.LENGTH_SHORT).show();
            }
        });

        ib_menu_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rutasActivity = new Intent(MenuActivity.this, rutasActivity.class);
                startActivity(rutasActivity);

            }
        });

        ib_menu_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acerActivity = new Intent(MenuActivity.this, acerActivity.class);
                startActivity(acerActivity);

            }
        });
        ib_menu_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoActivity = new Intent(MenuActivity.this, informacionActivity.class);
                startActivity(infoActivity);

            }
        });

        w.LoadGiff(v,this,R.drawable.one_piece);
    }
}
