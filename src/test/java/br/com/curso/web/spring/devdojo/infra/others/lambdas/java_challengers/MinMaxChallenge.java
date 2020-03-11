package br.com.curso.web.spring.devdojo.infra.others.lambdas.java_challengers;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinMaxChallenge {
    public static void main(String[] args) {
        IntStream intStream = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .mapToInt(n -> n);

        IntStream intStream2 = Stream.of(6, 7, 8, 9, 10)
                .mapToInt(n -> n);

        IntStream intStream3 = intStream;
        OptionalInt optionalIntMin = intStream.min();
        OptionalInt optionalIntMax = intStream.max();

        int soma = optionalIntMax.orElse(5) + optionalIntMin.orElse(5);
        System.out.println(soma);
    }
}
