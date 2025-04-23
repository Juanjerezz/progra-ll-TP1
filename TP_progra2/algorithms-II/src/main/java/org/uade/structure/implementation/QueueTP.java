package org.uade.structure.implementation;
import org.uade.structure.TPimplementation.Medicos;


public class QueueTP {

    private static final int capacidadMaxima = 15; // Puedes ajustar el límite según sea necesario

    private static class Nodo {
        Medicos dato;
        Nodo siguiente;

        Nodo(Medicos dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo head;
    private Nodo end;
    private int size;

    public QueueTP() {
        head = null;
        end = null;
        size = 0;
    }

    // Métodos

    public Medicos getElement() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return head.dato;
    }

    public void add(Medicos medico) {
        if (size >= capacidadMaxima) {
            throw new IllegalStateException("La cola ha alcanzado su capacidad máxima.");
        }
        Nodo nuevo = new Nodo(medico);
        if (isEmpty()) {
            head = nuevo;
        } else {
            end.siguiente = nuevo;
        }
        end = nuevo;
        size++;
    }

    public void remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        head = head.siguiente;
        if (head == null) {
            end = null;
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}