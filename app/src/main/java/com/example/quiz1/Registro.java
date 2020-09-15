package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText name, id;
    private Button bContinuarR;
    String nombre,iden;
    ArrayList<Usuario> usuarios;
    String puntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //
        name=findViewById(R.id.name);
        id= findViewById(R.id.id);
        bContinuarR=findViewById(R.id.bContinuarR);
        usuarios= new ArrayList<Usuario>();


        //click boton
        bContinuarR.setOnClickListener(this);

    }


    public void onClick(View view){
        //obtengo los datos
        nombre= name.getText().toString();
        iden= id.getText().toString();


        usuarios.add(new Usuario(nombre, puntaje));
        Log.e(" ", "esto deberia pintarse");



        //No dejo pasar al usuario hasta que ponga todos los datos
        if(nombre.trim().isEmpty() || iden.trim().isEmpty()) {
            Toast.makeText(this, "Alguno de los campos no ha sido llenado", Toast.LENGTH_LONG).show();
            return;
        }

        //Paso a la siguiente pantalla
        Intent i= new Intent(this,Nexo.class);
        startActivity(i);


        //Shared Preferences, guardo los datos de mi usuario
        SharedPreferences preferences=getSharedPreferences("locker", MODE_PRIVATE);
        preferences.edit().putString("nombre",nombre).apply();
        preferences.edit().putString("id",iden).apply();


    }
}