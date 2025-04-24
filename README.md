# UADE-2025-PROGRA-II-

Este proyecto es un sistema de gestión para un centro de emergencias médicas, implementado en Java. El sistema gestiona la atención de pacientes, asignación de médicos y reporte de la situación actual de la atención médica.

## Características

- **Ingreso de pacientes**: Se pueden registrar pacientes con un nombre y nivel de prioridad (Baja, Media, Alta).
- **Alta de doctores**: Se pueden ingresar médicos al sistema.
- **Atención de pacientes**: Los médicos pueden atender a los pacientes según su prioridad.
- **Liberación de médicos**: Los médicos que terminen de atender a un paciente se liberan para atender a otros.
- **Reportes**: El sistema genera reportes con el estado actual de los pacientes y médicos, como cantidad de pacientes en espera, pacientes siendo atendidos y médicos disponibles.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

- **`org.uade.structure`**: Contiene las estructuras de datos y clases relacionadas con la gestión de pacientes y médicos.
- **`org.uade.structure.implementation`**: Implementaciones de colas (`QueueTP` y `PriorityQueueTP`) utilizadas para gestionar las estructuras de datos.
- **`org.uade.structure.exception`**: Excepciones personalizadas utilizadas para manejar errores comunes como estructuras vacías.
- **`org.uade.structure.Utilidades`**: Contiene clases auxiliares como `Cargas` (para precargar médicos y pacientes) y `ValidadorNombre` (para validar los nombres de pacientes y médicos).

## Funcionalidad

1. **Ingreso de pacientes**:
   - Los pacientes se ingresan proporcionando su nombre y nivel de prioridad.
   - Se valida que el nombre del paciente sea válido (sin números o símbolos).

2. **Alta de doctores**:
   - Los médicos se agregan al sistema proporcionando su nombre.
   - Se valida que el nombre del médico sea válido.

3. **Atención de pacientes**:
   - Los pacientes se asignan a los médicos disponibles, respetando la prioridad de los pacientes (alta, media, baja).
   - Si no hay médicos disponibles o pacientes para atender, el sistema mostrará un mensaje de error.

4. **Liberación de médicos**:
   - Los médicos que terminan de atender a un paciente se liberan y pueden atender a otros pacientes.

5. **Generación de reportes**:
   - El sistema genera reportes con la cantidad de pacientes en espera, siendo atendidos y total atendidos.
   - También se muestra la lista de médicos disponibles y ocupados.

## Excepciones Personalizadas

El sistema utiliza excepciones personalizadas para gestionar casos de error como:

- **`EmptyStructureException`**: Se lanza cuando una estructura (como una cola de médicos o pacientes) está vacía.
- **`FullStructureException`**: Se lanza cuando una estructura está llena.
- **`InvalidOperationException`**: Se lanza cuando una operación no es válida, como ingresar un nombre inválido o una prioridad fuera de rango.

## Instrucciones para Ejecutar

### Requisitos Previos

- Tener instalado **Java** (versión 8 o superior).

### Compilación y Ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/nombre_del_repositorio.git
2. Compilar el proyecto:
   ```bash
   javac -d bin src/org/uade/structure/TPimplementation/Main.java
3. Ejecutar el proyecto:
   ```bash
   java -cp bin org.uade.structure.tpImplementation.Main
