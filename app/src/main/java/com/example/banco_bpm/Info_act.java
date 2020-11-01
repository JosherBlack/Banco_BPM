package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity
{
    private VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        vv = (VideoView)findViewById(R.id.vv);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.trailer_01;

        Uri uri = Uri.parse(ruta);

        vv.setVideoURI(uri);

        MediaController media = new MediaController(this) ;
        vv.setMediaController(media);
    }

    public void Maps(View v)
    {
        Intent i = new Intent(this, Maps_act.class);
        startActivity(i);

    }
}