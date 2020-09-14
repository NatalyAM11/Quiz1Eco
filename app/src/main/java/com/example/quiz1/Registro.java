package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText name, id;
    private Button bContinuarR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //
        name=findViewById(R.id.name);
        id= findViewById(R.id.id);
        bContinuarR=findViewById(R.id.bContinuarR);

        //click boton
        bContinuarR.setOnClickListener(this);

    }


    public void onClick(View view){

        //Paso a la siguiente pantalla
        Intent i= new Intent(this,Nexo.class);
        startActivity(i);

    }
}