package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Clientes_act extends AppCompatActivity
{
    private EditText edcodigo, ednombre, edsalario;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        edcodigo = (EditText)findViewById(R.id.edit_codigo);
        ednombre = (EditText)findViewById(R.id.edit_nombre);
        edsalario = (EditText)findViewById(R.id.edit_salario);
    }

    public void AnadirClientes(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "datos", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        if(!edcodigo.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo", edcodigo.getText().toString());
            registro.put("nombre", ednombre.getText().toString());
            registro.put("salario", edsalario.getText().toString());

            bd.insert("clientes", null, registro);
            bd.close();

            Toast.makeText(this, "Se Ha Registrado Un Cliente.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Debe Ingresar Datos Correctos.", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar(View v)

    {
        edcodigo.setText("");
        ednombre.setText("");
        edsalario.setText("");

        Toast.makeText(this, "Formulario Limpio", Toast.LENGTH_SHORT).show();
    }

    public void MostrarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "datos", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM clientes WHERE codigo ="+ codigo,null);

            if (fila.moveToFirst())
            {
                ednombre.setText(fila.getString(0));
                edsalario.setText(fila.getString(1));
            }
            else
            {
                Toast.makeText(this,"Cliente No Existe.", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"Debe Poner Código De Cliente.",Toast.LENGTH_SHORT).show();
        }
    }

    public void EliminarClientes(View v)
    {
        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(this, "datos", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();
        db.delete("clientes","codigo="+codigo,null);

        Toast.makeText(this,"Se Ha Eliminado El Cliente",Toast.LENGTH_LONG).show();

    }

    public void ActualizarClientes(View v)
    {
        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(this, "datos", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = edcodigo.getText().toString();

        ContentValues cont = new ContentValues();
        cont.put("codigo",edcodigo.getText().toString());
        cont.put("nombre",ednombre.getText().toString());
        cont.put("salario",edsalario.getText().toString());

        if (!codigo.isEmpty())
        {
            db.update("clientes",cont,"codigo="+codigo,null);
            Toast.makeText(this,"Se Ha Actualizado el Cliente",Toast.LENGTH_LONG).show();
        }
    }
}