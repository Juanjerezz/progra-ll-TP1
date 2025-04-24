package org.uade.structure.implementation;

import org.uade.structure.tpImplementation.Pacientes;

public class PriorityQueueTP {

    private static final int CAPACIDAD_MAXIMA = 100;

    private static class Nodo {
        Pacientes paciente;
        Nodo siguiente;

        Nodo(Pacientes paciente) {
            this.paciente = paciente;
            this.siguiente = null;
        }
    }

    private Nodo head;
    private Nodo end;
    private int size;

    public PriorityQueueTP() {
        head = null;
        end = null;
        size = 0;
    }

    /**
     * Descripción: Devuelve el primer paciente (de mayor prioridad). Precondición: Debe haber elementos.
     */
    public Pacientes getElement() {
        if (isEmpty()) {
            throw new IllegalStateException("La estructura está vacía");
        }
        return head.paciente;
    }

    /**
     * Descripción: Devuelve la prioridad del primer paciente. Precondición: Debe haber elementos.
     */
    public int getPriority() {
        if (isEmpty()) {
            throw new IllegalStateException("La estructura está vacía");
        }
        return head.paciente.getPrioridad();
    }

    /**
     * Descripción: Agrega un paciente ordenado por prioridad. Precondición: No debe superar la capacidad máxima.
     */
    public void add(Pacientes nuevoPaciente) {
        if (size >= CAPACIDAD_MAXIMA) {
            throw new IllegalStateException("La estructura ha alcanzado su capacidad máxima");
        }

        Nodo nuevoNodo = new Nodo(nuevoPaciente);

        if (isEmpty() || nuevoPaciente.getPrioridad() > head.paciente.getPrioridad()) {
            // Inserta al inicio si es mayor prioridad
            nuevoNodo.siguiente = head;
            head = nuevoNodo;
            if (end == null) {
                end = nuevoNodo;
            }
        } else {
            // Inserta en la posición correspondiente
            Nodo actual = head;
            while (actual.siguiente != null &&
                    actual.siguiente.paciente.getPrioridad() >= nuevoPaciente.getPrioridad()) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;

            if (nuevoNodo.siguiente == null) {
                end = nuevoNodo;
            }
        }

        size++;
    }

    /**
     * Descripción: Elimina el primer paciente. Precondición: Debe haber elementos.
     */
    public void remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La estructura está vacía");
        }

        head = head.siguiente;
        if (head == null) {
            end = null;
        }
        size--;
    }

    /**
     * Descripción: Verifica si la estructura está vacía.
     */
    public boolean isEmpty() {
        return size == 0;
    }

}