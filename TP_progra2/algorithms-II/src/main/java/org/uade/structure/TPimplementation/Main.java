package org.uade.structure.TPimplementation;
import org.uade.structure.Utilidades.Cargas;
import org.uade.structure.Utilidades.UtilidadesQueue;
import org.uade.structure.implementation.PriorityQueueTP;
import org.uade.structure.implementation.QueueTP;


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        // tdas
        QueueTP colaMedicos = new QueueTP(); //LIMITAR CANTIDAD MAXIMA !!!
        QueueTP medicosOcupados = new QueueTP();
        PriorityQueueTP colaPacientes = new PriorityQueueTP();
        int contadorPacientes = 0;



        Cargas.cargaMedicos(colaMedicos);
        Cargas.cargaPacientes(colaPacientes);






        Scanner scanner = new Scanner(System.in);
        int opcion;

        boolean salir = false;

        while(!salir) {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Ingreso de pacientes.");
            System.out.println("2. Alta doctores.");
            System.out.println("3. Atencion de pacientes");
            System.out.println("4. Liberar doctor.");
            System.out.println("5. Reportes y analisis");
            System.out.println("0. Salir");
            System.out.println("-----------------------");
            System.out.println("Elige una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion) {
                case 1:

                    //Ingresar nombre y prioridad de pacientes !!!

                    System.out.println("Ingrese el nombre del paciente");
                    String nombrePaciente = scanner.nextLine();
                    System.out.println("Ingrese nivel de prioridad (1,2,3)");
                    int prioridad = scanner.nextInt();
                    colaPacientes.add(new Pacientes(nombrePaciente,prioridad));



                    System.out.println();
                    System.out.println("-----------------------");




                    break;
                case 2:

                    //Agregar un nuevo doctor a la cola
                    System.out.println("Ingrese el nombre del doctor");
                    String doctor = scanner.nextLine();
                    colaMedicos.add(new Medicos(doctor));

                    System.out.println();
                    System.out.println("-----------------------");



                    break;
                case 3:
                    //Tomar un paciente de la cola y asignarle un medico
                    System.out.println();

                    if(!colaPacientes.isEmpty()) {
                        Medicos medicoSeleccionado = colaMedicos.getElement();
                        colaMedicos.remove();
                        Pacientes pacienteSeleccionado = colaPacientes.getElement();
                        colaPacientes.remove();

                        medicosOcupados.add(medicoSeleccionado);


                        System.out.println("Paciente " + pacienteSeleccionado + " asignado a  " + medicoSeleccionado.getNombre());
                        System.out.println();
                    }else {
                        System.out.println("No hay pacientes a atender");
                        System.out.println();
                    }


                    //cuando no queden pacientes imprimir "Todos los pacientes atendidos :D"

                    // quizas (?) cada x cantidad de pacientes, liberar el mas viejo

                    break;

                case 4:

                    if(!medicosOcupados.isEmpty()) {
                    System.out.println();
                    Medicos medicoLibre = medicosOcupados.getElement();
                    medicosOcupados.remove();
                    System.out.println("Doctor " + medicoLibre + " termino de atender a su paciente");
                    colaMedicos.add(medicoLibre);
                    contadorPacientes ++;
                    }else {
                        System.out.println("No hay medicos atendiendo.");
                        System.out.println();
                    }

                    break;

                case 5:

                    //Generacion de reporte

                    //se imprime la cantidad de pacientes atendidos, osea...
                    //guardar cada vez que un medico se libera

                    System.out.println();
                    System.out.println("Se atendieron: " + contadorPacientes +  " pacientes");
                    System.out.println("Medicos disponibles: ");
                    UtilidadesQueue.print(colaMedicos);
                    System.out.println();


                    break;

                case 0:
                    salir = true;
                    System.out.println();
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}

