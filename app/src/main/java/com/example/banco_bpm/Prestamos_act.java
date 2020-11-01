package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Creditos;

public class Prestamos_act extends AppCompatActivity
{

    private Spinner spin1, spin2;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        spin1 = (Spinner)findViewById(R.id.spclientes);
        spin2 = (Spinner)findViewById(R.id.spCredito);
        text = (TextView)findViewById(R.id.tv);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");


        ArrayAdapter<String> adapt1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapt2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCreditos);

        spin1.setAdapter(adapt1);
        spin2.setAdapter(adapt2);
    }

    public void Prestamo(View v) {
        String cliente = spin1.getSelectedItem().toString().toLowerCase();
        String planes = spin2.getSelectedItem().toString().toLowerCase();

        Creditos creditos = new Creditos();

        int axel = 750000;
        int roxana = 900000;
        int base = 0;

//AXEL
        if (cliente.equals("axel") && planes.equals("hipotecario"))
        {
            base = axel;
            int resultHipotecario = base + creditos.getHipotecario();
            text.setText("El prestamo es: " + resultHipotecario);
        }

        if (cliente.equals("axel") && planes.equals("automotriz"))
        {
            base = axel;
            int resultAutomotriz = base + creditos.getAutomotriz();
            text.setText("El precio del plan es: " + resultAutomotriz);
        }

        //ROXANA

        if (cliente.equals("roxana") && planes.equals("hipotecario"))
        {
            base = roxana;
            int resultHipotecario = base + creditos.getHipotecario();
            text.setText("El prestamo es: " + resultHipotecario);
        }

        if (cliente.equals("roxana") && planes.equals("automotriz"))
        {
            base = roxana;
            int resultAutomotriz = base + creditos.getAutomotriz();
            text.setText("El precio del plan es: " + resultAutomotriz);
        }


    }

    public void Deuda(View v) {
        String cliente = spin1.getSelectedItem().toString().toLowerCase();
        String planes = spin2.getSelectedItem().toString().toLowerCase();

        Creditos creditos = new Creditos();

        int axel = 750000;
        int roxana = 900000;
        int base = 0;
        int ultimo = 0;

        //AXEL
        if (cliente.equals("axel") && planes.equals("hipotecario"))
        {
            base = axel;
            int resultHipotecario = base + creditos.getHipotecario();
            ultimo = resultHipotecario/12;
            text.setText("Cuota de: " + ultimo);
        }

        if (cliente.equals("axel") && planes.equals("automotriz"))
        {
            base = axel;
            int resultAutomotriz = base + creditos.getAutomotriz();
            ultimo = resultAutomotriz/8;
            text.setText("Cuota de: " + ultimo);
        }

        //ROXANA

        if (cliente.equals("roxana") && planes.equals("hipotecario"))
        {
            base = roxana;
            int resultHipotecario = base + creditos.getHipotecario();
            ultimo = resultHipotecario/12;
            text.setText("Cuota de: " + ultimo);
        }

        if (cliente.equals("roxana") && planes.equals("automotriz"))
        {
            base = roxana;
            int resultAutomotriz = base + creditos.getAutomotriz();
            ultimo = resultAutomotriz/8;
            text.setText("Cuota de: " + ultimo);
        }
    }
}