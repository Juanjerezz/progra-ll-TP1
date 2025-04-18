package org.uade.structure.Utilidades;

import org.uade.structure.TPimplementation.Medicos;
import org.uade.structure.TPimplementation.Pacientes;
import org.uade.structure.implementation.PriorityQueueTP;
import org.uade.structure.implementation.QueueTP;

public class Cargas {
    public static void cargaMedicos(QueueTP queue) {
        queue.add(new Medicos("Doctor/a Alvarez"));
        queue.add(new Medicos("Doctor/a Perez"));
        queue.add(new Medicos("Doctor/a Ramirez"));
        queue.add(new Medicos("Doctor/a Fernandez"));
        queue.add(new Medicos("Doctor/a Gonzalez"));
        queue.add(new Medicos("Doctor/a Arroyo"));
        queue.add(new Medicos("Doctor/a Miranda"));
        queue.add(new Medicos("Doctor/a Juarez"));
        queue.add(new Medicos("Doctor/a Pereira"));
        queue.add(new Medicos("Doctor/a Moran"));
    }

    public static void cargaPacientes(PriorityQueueTP queue) {
        queue.add(new Pacientes("Juan",1));
        queue.add(new Pacientes("Martin",2));
        queue.add(new Pacientes("Francisco",3));
    }
}
