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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText name, id;
    private Button bContinuarR;
    String nombre,iden,identi,namee;
    Set<String> usuarios;
    String puntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        //
        name=findViewById(R.id.name);
        id= findViewById(R.id.id);
        bContinuarR=findViewById(R.id.bContinuarR);


        //obtengo al usuario
        usuarios = getSharedPreferences("locker", MODE_PRIVATE).getStringSet("usuario", null);

        //Obtengo todoss los datos del usuario, del shared preferences
        puntaje=getSharedPreferences("locker",MODE_PRIVATE).getString("puntajeFinal", null);
        identi=getSharedPreferences("locker", MODE_PRIVATE).getString("id", null);
        namee=getSharedPreferences("locker",MODE_PRIVATE).getString("nombreFinal", null);


        if(usuarios==null){
            usuarios=new HashSet<String>();
        }

        //click boton
        bContinuarR.setOnClickListener(this);

        //agregarUser();

        Log.e(">>>", String.valueOf(usuarios));

    }


    public void onClick(View view){

        //obtengo los datos
        nombre= name.getText().toString();
        iden= id.getText().toString();



        //No dejo pasar al usuario hasta que ponga todos los datos
        if(nombre.trim().isEmpty() || iden.trim().isEmpty()) {
            Toast.makeText(this, "Alguno de los campos no ha sido llenado", Toast.LENGTH_LONG).show();
            return;
        }

        //No dejo pasar al usuario si se intenta registrar de nuevo
        //Valido que no e de error si esta null
        if(identi!= null) {
            if (identi.contains(iden)) {
                Toast.makeText(this, "Este usuario ya esta registrado", Toast.LENGTH_LONG).show();
                Log.e(">>>", "Holaaa");
                return;
            }
        }


        //Paso a la siguiente pantalla
        Intent i= new Intent(this,Nexo.class);
        startActivity(i);

        //meto el nombre y la identificacion en el shared preferences
        SharedPreferences preferences= getSharedPreferences("locker", MODE_PRIVATE);
        preferences.edit().putString("nombreFinal", nombre).apply();
        preferences.edit().putString("id", iden).apply();

    }


    //Este metodo agregar al usuario, la mande a Sintomas para que los cree cuando pasa a la otra pantalla
     /* public void agregarUser(){

        String nombre = getSharedPreferences("locker", MODE_PRIVATE).getString("nombreFinal", null);
        puntaje=getSharedPreferences("locker",MODE_PRIVATE).getString("puntajeFinal", null);


        //añado usuarios
        if(nombre!= null || puntaje != null) {
            usuarios.add(nombre + "  " + puntaje);
        }


        for(Iterator<String> it = usuarios.iterator(); it.hasNext();) {
            String a= it.next();
            Log.e("Hola", a);
        }


        //Shared Preferences, guardo los datos de mi usuario
        SharedPreferences preferences=getSharedPreferences("locker", MODE_PRIVATE);
        preferences.edit().putStringSet("usuario",usuarios).apply();

    }*/


}