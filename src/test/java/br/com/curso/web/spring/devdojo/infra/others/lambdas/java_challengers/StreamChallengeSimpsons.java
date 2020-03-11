package br.com.curso.web.spring.devdojo.infra.others.lambdas.java_challengers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamChallengeSimpsons {

    public static void main(String[] args) {
        List<Simpson> simpsonList = Arrays
                .asList(new Simpson("Homer", 35),
                        new Simpson("Bart", 10),
                        new Simpson("Margie", 30),
                        new Simpson("Lisa", 8)
                );

        simpsonList.forEach(System.out::println);

        Optional<Simpson> bart = simpsonList.stream()
                .filter(simpson -> simpson.getNome().equals("Bart"))
                .filter(simpson -> simpson.getIdade() > 9)
                .findFirst();

        List<Simpson> list = simpsonList.stream()
                .filter(simpson -> simpson.getNome().equals("Bart"))
                .filter(simpson -> simpson.getIdade() > 9)
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }

    static class Simpson {
        private String nome;
        private int idade;

        public Simpson(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

        @Override
        public String toString() {
            return "Simpson{" +
                    "NOME='" + nome + '\'' +
                    ", IDADE=" + idade +
                    '}';
        }
    }
}
