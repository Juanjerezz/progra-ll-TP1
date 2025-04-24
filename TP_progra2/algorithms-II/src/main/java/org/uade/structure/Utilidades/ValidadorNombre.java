package org.uade.structure.Utilidades;

public class ValidadorNombre {
    public static boolean esNombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty() && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }
}