package org.uade.structure.tpImplementation;

public class Pacientes {
    //Atributos
    String nombre;
    int prioridad;


    public Pacientes(String nombre,int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    //Constructor



    //Metodos

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

