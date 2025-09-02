package com.cincout.proyecto.example04;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // --- Ejemplo 1: findFirst() con lista no vacía ---
        List<String> names = List.of("Carlos","Ana","Teddy");

        Optional<String> first = names.stream().findFirst();

        first.ifPresent(n -> System.out.println("El primero es: " + n));

        // --- Ejemplo 2: findFirst() en lista vacía ---
        List<String> emptyList = List.of();

        Optional<String> firstEmpty = emptyList.stream().findFirst();

        System.out.println("¿Está presente? " + firstEmpty.isPresent());

        // Alternativa más clara con ifPresentOrElse
        firstEmpty.ifPresentOrElse(
                n -> System.out.println("Primer elemento: " + n),
                () -> System.out.println("Lista vacía, no hay elementos")
        );

        // --- Ejemplo 3: búsqueda en lista de objetos ---
        record Product(String name, double price){}

        List<Product> products = List.of(
                new Product("TV", 200),
                new Product("Laptop", 400)
        );

        Optional<Product> maybeTV = products.stream()
                .filter(p -> p.name().equalsIgnoreCase("tv"))
                .findFirst();

        // Usando orElseGet() → más eficiente que orElse, porque crea el objeto solo si es necesario
        Product result = maybeTV.orElseGet(() -> new Product("Genérico", 0));

        System.out.println("Resultado: " + result.name() + " - $" + result.price());

        // --- Ejemplo 4: findAny() (similar a findFirst, pero no garantiza orden en streams paralelos) ---
        Optional<String> anyName = names.stream().findAny();
        anyName.ifPresent(n -> System.out.println("Elemento encontrado con findAny(): " + n));
    }
}
