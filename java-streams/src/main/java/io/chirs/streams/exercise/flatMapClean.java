package io.chirs.streams.exercise;

import java.util.Arrays;
import java.util.List;

public class flatMapClean {

    // Tu objetivo es obtener una List<String> con todas las palabras individuales utilizadas en los comentarios.
    // Las palabras deben estar estrictamente en minúsculas y no debe haber duplicados en la lista final.
    // Piensa bien el orden en el que aplicas los operadores.
    public static void main(String[] args) {

        List<String> comentarios = List.of("El sistema falla", "Sistema lento pero funciona", "falla catastrófica");
        var words = comentarios.stream()
                .map(String::toLowerCase)
                .flatMap(comment -> Arrays.stream(comment.split(" ")))
                .distinct()
                .toList();

        words.forEach(System.out::println);
    }
}
