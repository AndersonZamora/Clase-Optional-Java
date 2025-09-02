package com.cincout.proyecto.example02;

import java.util.Optional;

/**
 * Ejemplo del uso de Optional en Java.
 *
 * <p>Se muestran operaciones comunes como:
 * <ul>
 *     <li><b>map()</b> → transformar valores si existen</li>
 *     <li><b>flatMap()</b> → aplanar Optionals anidados</li>
 *     <li><b>filter()</b> → validar un valor dentro del Optional</li>
 *     <li><b>ifPresent()</b> → ejecutar acción si el valor está presente</li>
 * </ul>
 * </p>
 */
public class Main {
    public static void main(String[] args) {

        // --- map(): transformar el contenido si existe ---
        Optional<String> name = Optional.of("Anderson");
        //Optional<String> name = Optional.empty(); // prueba alternativa

        Optional<String> nameUpperCase = name.map(String::toUpperCase);
        System.out.println("Nombre en mayúsculas: " + nameUpperCase.orElse("Sin nombre"));

        // --- map encadenado: múltiples transformaciones ---
        Optional<String> username = Optional.of("     Gabriel           ");

        String nameLowerCase = username
                .map(String::trim)        // elimina espacios en blanco
                .map(String::toLowerCase) // convierte a minúsculas
                .orElse("Sin nombre");

        System.out.println("Username: " + nameLowerCase);

        // --- flatMap(): evita Optional anidado ---
        Optional<Optional<String>> optionalOfOptional =
                Optional.of(Optional.of("Valor interno"));

        Optional<String> resultFlatMap = optionalOfOptional.flatMap(op -> op);
        System.out.println("Resultado flatMap: " + resultFlatMap.orElse("Sin valor"));

        // --- filter(): validación condicional ---
        Optional<String> dni = Optional.of("12345678");

        Optional<String> result = dni.filter(d -> d.startsWith("1"));
        System.out.println("DNI: " + result.orElse("No válido"));

        // --- ifPresent(): ejecutar acción si el valor existe ---
        Optional<String> email = Optional.ofNullable("   gabri@gmail.com  ");

        email.map(String::trim)            // elimina espacios extra
                .filter(e -> e.contains("@")) // valida formato mínimo de correo
                .ifPresent(m -> System.out.println("Enviando correo a: " + m));
    }
}
