package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity
{
    private ProgressBar pb;
    private Button bt1;

    private EditText nombre;
    private EditText contra;



    private String nombre1 = "android";
    private String contra1 = "123";



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre = (EditText) findViewById(R.id.etnombre);
        contra = (EditText) findViewById(R.id.et);

        pb = (ProgressBar)findViewById(R.id.pb) ;
        pb.setVisibility(View.INVISIBLE);
        bt1 = (Button)findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View view)
        {
            new Task().execute();
        }
        }
        );
    }

    class Task extends AsyncTask<String, Void, String>
    {

        @Override
        protected void onPreExecute()
        {
           pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings)
        {
            for (int i = 1; i<= 10; i++)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {
            if (nombre.getText().toString().toLowerCase().equals(nombre1.toLowerCase()))
            {
                if(contra.getText().toString().toLowerCase().equals(contra1.toLowerCase()))
                {
                    pb.setVisibility(View.INVISIBLE);
                    Intent i = new Intent(getBaseContext(), Home_act.class);
                    startActivity(i);
                }
                else
                {
                    contra.setText("Contraseña Inválida");
                }
            }
            else
            {
                nombre.setText("Nombre Inválido");
            }
        }
    }
}