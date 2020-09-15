package com.example.quiz1;

public class Usuario {

    String nombre, id, puntaje;
    String text;

    public Usuario(String nombre,String puntaje){

        this.nombre=nombre;
        this.puntaje=puntaje;
        text= nombre+ "       " + puntaje;

    }



    String devolverPregunta(){
        return text;
    }



}
