package com.example.dstorres.espolmaps;

import android.app.Activity;
import android.os.Bundle;
import java.io.File;
import android.os.Environment;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
/**
 * Created by dstorres on 31/05/2016.
 */

public class rutasActivity extends Activity {

    // Declare variables
    private String[] FilePathStrings;
    private String[] FileNameStrings;
    private File[] listFile;
    private boolean lb_existe = false;
    String path = Environment.getExternalStorageDirectory().getPath();
    GridView grid;
    GridViewAdapter adapter;
    File file;
    String state_actual = Environment.getExternalStorageState();
    String state_configurado = Environment.MEDIA_MOUNTED;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);

        if (!state_actual.equals(state_configurado)) {
                Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                        .show();
        } else {
            file = new File("/sdcard/EspolMAps");
            if(!file.exists()){
                lb_existe = file.mkdir();
            }
        }

        if (file.isDirectory()) {
            listFile = file.listFiles();
            if (listFile.length > 0) {
                FilePathStrings = new String[listFile.length];
                FileNameStrings = new String[listFile.length];

                for (int i = 0; i < listFile.length; i++) {
                    FilePathStrings[i] = listFile[i].getAbsolutePath();
                    FileNameStrings[i] = listFile[i].getName();
                }

                grid = (GridView) findViewById(R.id.gridview);
                adapter = new GridViewAdapter(this, FilePathStrings, FileNameStrings);
                grid.setAdapter(adapter);


                grid.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                        Intent i = new Intent(getApplicationContext(), imagenElegia.class);

                        i.putExtra("id", position);
                        i.putExtra("filepath", FilePathStrings);
                        startActivity(i);
                    }
                });

            }else {
                Toast.makeText(this, "No hay archivos Disponibles", Toast.LENGTH_LONG)
                        .show();
            }
        }


    }


}