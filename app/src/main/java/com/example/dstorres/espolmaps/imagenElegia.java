package com.example.dstorres.espolmaps;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
/**
 * Created by dstorres on 04/06/2016.
 */
public class imagenElegia extends Activity  {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_im_cap);
        Intent i = getIntent();

        String[] filepath = i.getStringArrayExtra("filepath");
        int position = i.getExtras().getInt("id");

        ImageView imageView = (ImageView) findViewById(R.id.SingleView);
        Bitmap bmp = BitmapFactory.decodeFile(filepath[position]);
        imageView.setImageBitmap(bmp);

    }
}
