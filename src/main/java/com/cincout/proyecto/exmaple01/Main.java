package com.cincout.proyecto.exmaple01;

import java.util.Optional;
import java.util.Scanner;

/**
 * Ejemplo de uso de {@link Optional} en Java.
 *
 * <p>Se solicita un nombre al usuario y se valida usando {@code Optional}
 * en lugar de condicionales tradicionales.</p>
 *
 * <h2>Características mostradas:</h2>
 * <ul>
 *   <li>{@code Optional.ofNullable()} para envolver valores que pueden ser nulos.</li>
 *   <li>{@code filter()} para descartar cadenas vacías.</li>
 *   <li>{@code orElseGet()} para proveer un valor alternativo ("Invitado").</li>
 *   <li>Alternativa con {@code orElseThrow()} para lanzar excepciones.</li>
 * </ul>
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre: ");
        String nameInput = scanner.nextLine();

        // Envolvemos el input en un Optional, descartando si es vacío
        Optional<String> optional = Optional.ofNullable(nameInput)
                .filter(name -> !name.isEmpty());

        // Opción 1: Valor por defecto "Invitado" si está vacío o null
        String name = optional.orElseGet(() -> "Invitado");

        // Opción 2 (comentada): lanzar excepción si no hay valor
        // String name = optional.orElseThrow(() -> new IllegalStateException("Error: nombre requerido"));

        System.out.println("Bienvenido " + name);

        scanner.close();
    }
}
