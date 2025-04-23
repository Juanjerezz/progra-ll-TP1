package org.uade.structure.TPimplementation;
import org.uade.structure.Utilidades.Cargas;
import org.uade.structure.Utilidades.UtilidadesQueue;
import org.uade.structure.implementation.PriorityQueueTP;
import org.uade.structure.implementation.QueueTP;
import org.uade.structure.exception.EmptyStructureException;
import org.uade.structure.exception.FullStructureException;
import org.uade.structure.exception.InvalidOperationException;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        // tdas
        QueueTP colaMedicos = new QueueTP(); //LIMITAR CANTIDAD MAXIMA !!!
        QueueTP medicosOcupados = new QueueTP();
        PriorityQueueTP colaPacientes = new PriorityQueueTP();
        int contadorPacientes = 0;
        int contPacientesAtendiendose=0;
        int contPacientesAAtender=3;//pacientes precargados(o se borran los precargados e inicia en 0, o paso la cantidad de pacientes precargados (?))



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

            try {
                switch (opcion) {
                    case 1:

                        //Ingresar nombre y prioridad de pacientes !!!

                        System.out.println("Ingrese el nombre del paciente: ");
                        String nombrePaciente = scanner.nextLine();
                        System.out.println("Ingrese nivel de prioridad (1-Baja,2-Media,3-Alta): ");//se cambio el valor de prioridad
                        int prioridad = scanner.nextInt();

                        if (prioridad < 1 || prioridad > 3) {
                            throw new InvalidOperationException("Nivel de prioridad inválido. Debe ser 1, 2 o 3.");
                        }
                        colaPacientes.add(new Pacientes(nombrePaciente, prioridad));
                        contPacientesAAtender++;

                        System.out.println("\n✅ Paciente ingresado correctamente.\n");
                        break;

                    case 2:

                        //Agregar un nuevo doctor a la cola
                        System.out.println("Ingrese el nombre del doctor");
                        String doctor = scanner.nextLine();
                        colaMedicos.add(new Medicos(doctor));

                        System.out.println("\nDoctor ingresado correctamente.\n-----------------------");
                        break;

                    case 3:
                        if (colaMedicos.isEmpty()) {
                            throw new EmptyStructureException("No hay médicos disponibles para asignar.");
                        }
                        if (colaPacientes.isEmpty()) {
                            throw new EmptyStructureException("No hay pacientes en espera.");
                        }

                        Medicos medicoSeleccionado = colaMedicos.getElement();
                        colaMedicos.remove();
                        Pacientes pacienteSeleccionado = colaPacientes.getElement();
                        colaPacientes.remove();

                        medicosOcupados.add(medicoSeleccionado);

                        System.out.println("Paciente " + pacienteSeleccionado + " asignado a " + medicoSeleccionado.getNombre() + "\n");

                        contPacientesAtendiendose++;
                        contPacientesAAtender--;
                        break;
                    case 4:
                        if (medicosOcupados.isEmpty()) {
                            throw new EmptyStructureException("No hay médicos atendiendo pacientes.");
                        }

                        Medicos medicoLibre = medicosOcupados.getElement();
                        medicosOcupados.remove();
                        System.out.println("Doctor " + medicoLibre + " terminó de atender a su paciente.");
                        colaMedicos.add(medicoLibre);

                        contadorPacientes++;
                        contPacientesAtendiendose--;
                        break;
                    case 5:
                        //Generacion de reporte
                        //se imprime la cantidad de pacientes atendidos, osea...
                        //guardar cada vez que un medico se libera
                        System.out.println();
                        System.out.println("Pacientes en espera a ser atendidos: " + contPacientesAAtender );
                        System.out.println("\nPacientes siendo atendidos:  " + contPacientesAtendiendose );
                        System.out.println("\nTotal pacientes atendidos: " + contadorPacientes );
                        System.out.println();

                        System.out.println("Medicos disponibles: ");
                        System.out.println();

                        UtilidadesQueue.print(colaMedicos);
                        System.out.println();
                        System.out.println("Medicos ocupados: ");
                        UtilidadesQueue.print(medicosOcupados);
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
            catch (InputMismatchException e) {
                    System.out.println("⚠️ Error: Debes ingresar un número entero \n");
                    scanner.nextLine();
            } catch (EmptyStructureException | FullStructureException | InvalidOperationException e) {
                System.out.println("⚠️ Error: " + e.getMessage() + "\n");
            } catch (Exception e) {
                System.out.println("⚠️ Error inesperado: " + e.getMessage() + "\n");
            }

    }
        scanner.close();
}}

