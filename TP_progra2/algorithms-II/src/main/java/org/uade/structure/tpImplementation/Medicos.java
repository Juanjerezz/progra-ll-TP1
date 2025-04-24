package org.uade.structure.tpImplementation;

public class Medicos{

    //atributos
    String nombre;

    //constructor
    public Medicos(String nombre) {
       this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }
}




