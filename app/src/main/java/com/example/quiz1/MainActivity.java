package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView users;
    private Button bRegistro;
    String nombre, id;
    private Usuario usuario;

    ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        users = findViewById(R.id.users);
        bRegistro = findViewById(R.id.bRegistro);
        usuarios= new ArrayList<Usuario>();


        //obtengo los datos del usuario por el shared preferences
        nombre = getSharedPreferences("locker", MODE_PRIVATE).getString("nombre", "NO_USER");
        id = getSharedPreferences("locker", MODE_PRIVATE).getString("id", "NO_ID");


        //añado los usuarios al arreglo
        usuarios.add(new Usuario(nombre,id));




        //usuario= new Usuario(nombre,id);
        //users.setText(" "+ nombre+" "+ id);
        //users.setText(usuario+ " ");
        pintarUsuario();

        //click Boton
        bRegistro.setOnClickListener(this);

    }


    public void onClick(View view) {

        //Paso a la siguiente pantalla
        Intent i = new Intent(this, Registro.class);
        startActivity(i);

    }

    public void pintarUsuario(){

        for(int i=0; i<usuarios.size(); i++) {
            usuarios.get(i).devolverPregunta();
            users.append(usuarios.get(i).devolverPregunta()+ "\n");

        }

    }
}





