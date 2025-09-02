package com.cincout.proyecto.example03;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //filter
        Optional<String> dni = Optional.of("12345678");

        Optional<String> result = dni.filter(d -> d.startsWith("1"));

        System.out.println("DNI: " + result.orElse("No válido"));


        Optional<String> email = Optional.ofNullable("   gabri@gmail.com  ");

        email.map(String::trim)
                .filter(e -> e.contains("@"))
                .ifPresent(m -> System.out.println("Enviando correo a: "+ m));
    }
}
