package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView users;
    private Button bRegistro;
    String nombre, id, puntaje;
    private Usuario usuario;

    ArrayList<Usuario> usuarios= new ArrayList<Usuario>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        users = findViewById(R.id.users);
        bRegistro = findViewById(R.id.bRegistro);

        //Le doy scroll a la lista cuando ya es muy grande
        users.setMovementMethod(new ScrollingMovementMethod());

        //Aqui limpio el arraylist cuando necesite
        //getSharedPreferences("locker",MODE_PRIVATE).edit().clear().apply();


        //obtengo los datos del usuario y su puntaje en el shared preferences para poder pintarlo aca
        Set<String> pref= getSharedPreferences("locker",MODE_PRIVATE).getStringSet("usuario", null);
        puntaje=getSharedPreferences("locker",MODE_PRIVATE).getString("puntajeFinal", null);

        Log.e(" Usuarios", String.valueOf(pref));


        //ya pinto los usuarios
        pintarUsuario(pref);

        //click Boton
        bRegistro.setOnClickListener(this);

    }


    public void onClick(View view) {

        //Paso a la pantalla de registro
        Intent i = new Intent(this, Registro.class);
        startActivity(i);

    }


    //Metodo para pintar los usarios
    public void pintarUsuario( Set<String> pref){

        new Thread(

                ()->{
                    //valido que no me de error por un null
                    if(pref!= null) {
                        for (String s : pref) {
                            runOnUiThread(() -> users.append(s + "\n"));
                        }
                    }
                }

        ).start();

    }


}





