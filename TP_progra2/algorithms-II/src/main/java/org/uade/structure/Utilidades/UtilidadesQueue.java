package org.uade.structure.Utilidades;
import org.uade.structure.implementation.QueueTP;

public class UtilidadesQueue {

    private static QueueTP getNewQueue(QueueTP queue) {
        return new QueueTP();
    }

    public static QueueTP copy(QueueTP queue) {
        QueueTP aux = getNewQueue(queue);
        QueueTP copy = getNewQueue(queue);
        while (!queue.isEmpty()) {
            aux.add(queue.getElement());
            queue.remove();
        }

        while (!aux.isEmpty()) {
            copy.add(aux.getElement());
            queue.add(aux.getElement());
            aux.remove();
        }

        return copy;
    }

    public static void print(QueueTP queue) {
        QueueTP copy = copy(queue);
        while (!copy.isEmpty()) {
            System.out.println(copy.getElement());
            copy.remove();
        }
    }









}
