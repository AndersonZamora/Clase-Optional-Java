package com.cincout.proyecto.exmple05;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // --- Ejemplo 1: ifPresentOrElse ---
        String maybeName = null;

        Optional.ofNullable(maybeName)
                .ifPresentOrElse(
                        n -> System.out.println("Nombre encontrado: " + n.toUpperCase()),
                        () -> System.out.println("No se encontró ningún nombre")
                );

        // --- Ejemplo 2: lista de Optionals ---
        List<Optional<String>> optionals = List.of(
                Optional.of("Hola"),
                Optional.empty(),
                Optional.of("Adios")
        );

        // Forma tradicional con filter + get
        System.out.println("\n--- Forma tradicional ---");
        optionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);

        // Forma moderna con flatMap(Optional::stream)
        System.out.println("\n--- Forma moderna con flatMap ---");
        optionals.stream()
                .flatMap(Optional::stream) // se "aplanan" los Optionals
                .forEach(System.out::println);

        // También se puede recolectar a una lista directamente
        List<String> values = optionals.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        System.out.println("\nValores recolectados: " + values);
    }
}
