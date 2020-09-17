package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Sintomas extends AppCompatActivity implements View.OnClickListener {

    private CheckBox s1,s2,s3,s4,s5,s6;
    private Button bFinalizar;
    int puntaje;
    Set<String> usuarios;
    String nombre, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        //recibo el el al usuario
        usuarios = getSharedPreferences("locker", MODE_PRIVATE).getStringSet("usuario", null);

        //recibo todos los datos del usuario del shared preferences
        nombre=getSharedPreferences("locker",MODE_PRIVATE).getString("nombreFinal", null);
        id=getSharedPreferences("locker", MODE_PRIVATE).getString("id", null);
        puntaje=getIntent().getExtras().getInt("puntaje");


        //evito que me de error por el null
        if(usuarios==null){
            usuarios=new HashSet<String>();
        }


        bFinalizar=findViewById(R.id.bFinalizar);
        s1= findViewById(R.id.s1);
        s2= findViewById(R.id.s2);
        s3= findViewById(R.id.s3);
        s4= findViewById(R.id.s4);
        s5= findViewById(R.id.s5);
        s6= findViewById(R.id.s6);

        //Valido todos los checks
        s1.setOnClickListener(this);
        s2.setOnClickListener(this);
        s3.setOnClickListener(this);
        s4.setOnClickListener(this);
        s5.setOnClickListener(this);
        s6.setOnClickListener(this);

        //click boton
        bFinalizar.setOnClickListener(this);


        Log.e("que pasa", String.valueOf(nombre));

    }



    public void onClick (View view){


        switch (view.getId()) {

            case R.id.bFinalizar:

                //No dejo pasar al usuario hasta que elija por lo menos una de las opciones
                if(s1.isChecked()==false && s2.isChecked()==false && s3.isChecked()==false && s4.isChecked()==false && s5.isChecked()==false &&s6.isChecked()==false){
                    Toast.makeText(this,"Debe escoger alguna de las opciones", Toast.LENGTH_LONG).show();
                    return;
                }

                //metodo para crear el usuario
                agregarUser();


            //Paso a la otra pantalla
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            break;


            //Valido todos los checks
            case R.id.s1:
                s1.isChecked();

                //Controlo la suma y resta del puntaje
                if(s1.isChecked()){
                    puntaje+=4;
                }else {
                    puntaje-=4;
                }

                //Si "ninguna de la anteriores" tiene check se lo quita
                s6.setChecked(false);

                break;

            case R.id.s2:
                s2.isChecked();

                if(s2.isChecked()){
                    puntaje+=4;
                }else{
                    puntaje-=4;
                }

                s6.setChecked(false);
                break;

            case R.id.s3:
                s3.isChecked();

                if(s3.isChecked()){
                puntaje+=4;
                }else{
                    puntaje-=4;
                }

                s6.setChecked(false);
                break;

            case R.id.s4:
                s4.isChecked();

                if(s4.isChecked()){
                    puntaje+=4;
                }else{
                    puntaje-=4;
                }

                s6.setChecked(false);
                break;

            case R.id.s5:
                s5.isChecked();

                if(s5.isChecked()){
                    puntaje+=4;
                }else{
                    puntaje-=4;
                }

                s6.setChecked(false);

                break;

            case R.id.s6:
                s6.isChecked();

                //Si le da a ninguno el puntaje es 0
                if(s6.isChecked()){
                    puntaje=puntaje;
                }

                //Si le dio a "ninguno"" entonces le quita el check a las otras
                s1.setChecked(false);
                s2.setChecked(false);
                s3.setChecked(false);
                s4.setChecked(false);
                s5.setChecked(false);

        }

        //meto el puntaje final en el shared preferences
        SharedPreferences preferences= getSharedPreferences("locker", MODE_PRIVATE);
        preferences.edit().putString("puntajeFinal", String.valueOf(puntaje)).apply();



        //Controlo el cambio de boton, sino le ha dado a ningun checkbox el boton esta oscuro. Si ya le dio vuelve a su color normal
        if(s1.isChecked()==false || s2.isChecked()==false || s3.isChecked()==false || s4.isChecked()==false || s5.isChecked()==false || s6.isChecked()==false){
          bFinalizar.setBackgroundColor(Color.rgb(28,131,131));
        }else{
            bFinalizar.setBackgroundColor(Color.rgb(93, 96, 96));
        }

        Log.e("que dio", String.valueOf(puntaje));

    }



    public void agregarUser(){

        String nombre = getSharedPreferences("locker", MODE_PRIVATE).getString("nombreFinal", null);

        //añado usuarios
        if(nombre!= null) {
            usuarios.add(nombre + "  " + puntaje);
        }


        for(Iterator<String> it = usuarios.iterator(); it.hasNext();) {
            String a= it.next();
        }


        //Shared Preferences, guardo los datos de mi usuario
        SharedPreferences preferences=getSharedPreferences("locker", MODE_PRIVATE);
        preferences.edit().putStringSet("usuario",usuarios).apply();

    }


}