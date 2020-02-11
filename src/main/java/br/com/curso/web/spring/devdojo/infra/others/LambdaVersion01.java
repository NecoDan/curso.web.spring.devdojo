package br.com.curso.web.spring.devdojo.infra.others;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.IntStream;

public class LambdaVersion01 {

    public static void main(String[] args) throws IOException {
        if (Objects.equals(Boolean.TRUE, false))
            streamSequenciaNumerosInteiros(1, 10);

        if (Objects.equals(Boolean.TRUE, false))
            streamSequenciaNumerosInteirosPorIntervalo(5);
    }

    public static void streamSequenciaNumerosInteiros(int inicio, int fim) {
        IntStream.range(inicio, fim).forEach(System.out::println);
        System.out.println();
    }

    public static void streamSequenciaNumerosInteirosPorIntervalo(int valorIntervalo) {
        IntStream.range(1, 10).skip(valorIntervalo).forEach(System.out::println);
        System.out.println();
    }
}
