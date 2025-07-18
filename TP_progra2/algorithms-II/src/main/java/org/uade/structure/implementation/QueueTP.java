package org.uade.structure.implementation;
import org.uade.structure.definition.QueueADT;
import org.uade.structure.exception.EmptyStructureException;
import org.uade.structure.exception.FullStructureException;
import org.uade.structure.tpImplementation.Medicos;


public class QueueTP  implements QueueADT {

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

    public int getElement(){
        return 0;
    }

    public Medicos getElement(int index) {
        if (isEmpty()) {
            throw new EmptyStructureException("La cola está vacía.");
        }
        return head.dato;
    }

    public void add(int value){

    }

    public void add(Medicos medico) {
        if (size >= capacidadMaxima) {
            throw new FullStructureException("La cola ha alcanzado su capacidad máxima.");
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
            throw new EmptyStructureException("La cola está vacía.");
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