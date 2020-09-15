package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Nexo extends AppCompatActivity implements View.OnClickListener {

    private CheckBox o1,o2,o3,o4,o5;
    private Button bContinuarN;
    int puntajeN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexo);

        o1=findViewById(R.id.o1);
        o2=findViewById(R.id.o2);
        o3=findViewById(R.id.o3);
        o4=findViewById(R.id.o4);
        o5=findViewById(R.id.o5);
        bContinuarN=findViewById(R.id.bContinuarN);
        puntajeN=0;


        //Todos los checks
        o1.setOnClickListener(this);
        o2.setOnClickListener(this);
        o3.setOnClickListener(this);
        o4.setOnClickListener(this);
        o5.setOnClickListener(this);


        //click boton
        bContinuarN.setOnClickListener(this);

        if(o1.isChecked()==false && o2.isChecked()==false && o3.isChecked()==false && o4.isChecked()==false && o5.isChecked()==false) {
            bContinuarN.setBackgroundColor(Color.rgb(93, 96, 96));
        }

    }


    public void onClick (View view){


        switch (view.getId()) {

            case R.id.bContinuarN:
                //No dejo pasar al usuario hasta que elija por lo menos una de las opciones
                if(o1.isChecked()==false && o2.isChecked()==false && o3.isChecked()==false && o4.isChecked()==false && o5.isChecked()==false){
                    Toast.makeText(this,"Debe escoger alguna de las opciones", Toast.LENGTH_LONG).show();
                    return;
        }

            //Paso a la otra pantalla
            Intent i = new Intent(this, Sintomas.class);

            //Mando el puntaje
            i.putExtra("puntaje", puntajeN);
            startActivity(i);

            break;

            //Valido los checks

            case R.id.o1:
            o1.isChecked();

            //Controlo la suma y resta del puntaje
                if(o1.isChecked()){
                    puntajeN+=3;
                }else{
                    puntajeN-=3;
                }

            //Si "ninguna de las anteriores" tiene check se lo quita
                o5.setChecked(false);

                break;

            case R.id.o2:
                o2.isChecked();

                if(o2.isChecked()){
                    puntajeN+=3;
                }else {
                    puntajeN -= 3;
                }


                o5.setChecked(false);
                break;

            case R.id.o3:
                o3.isChecked();


                if(o3.isChecked()){
                    puntajeN+=3;
                }else{
                    puntajeN-=3;
                }

                o5.setChecked(false);
                break;

            case R.id.o4:
                o4.isChecked();

                if(o4.isChecked()){
                    puntajeN+=3;
                }else{
                    puntajeN-=3;
                }

                o5.setChecked(false);
                break;

            case R.id.o5:
                o5.isChecked();

                if(o5.isChecked()){
                    puntajeN=0;
                }

                //Des check los demas
                o1.setChecked(false);
                o2.setChecked(false);
                o3.setChecked(false);
                o4.setChecked(false);
                break;
        }


        //Controlo el cambio de boton, sino le ha dado a ningun checkbox el boton esta oscuro. Si ya le dio vuelve a su color normal
        if(o1.isChecked() || o2.isChecked() || o3.isChecked() || o4.isChecked() || o5.isChecked()) {
            bContinuarN.setBackgroundColor(Color.rgb(28,131,131));
        }else{
            bContinuarN.setBackgroundColor(Color.rgb(93, 96, 96));
        }

        Log.e("que dio", String.valueOf(puntajeN));

    }

}