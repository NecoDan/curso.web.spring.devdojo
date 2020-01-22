package br.com.curso.web.spring.devdojo.infra.util;

/*
 # As expressões lambdas podem ser definidas como métodos anônimos. Não são executadas em si próprios,expressões que não posuem nome.
 Com elas, pode-se implementar mensagens com alto nível de abrastração, pode enviar ou receber blocos de código que se comportam
 um pouco parecida de ordem superior = PARADIGMA FUNCIONAL.
 Todavia, os lambdas implementam os métodos que estão definidos em uma 'Interface Fucional'. Isto é, são utilizadas para substituirem
 a implementação da classe anônima, logo conseguimos empregar as classes anônimas de uma forma elegante que melhora a legibilidade do
 código.

 # Ordem Superior = quando uma operação pode-se receber outra operação, ou seja, receber um comportamento como parâmetro, podendo
 executá-lo internamente este comportamento.

 # Programação (paradigma) Funcional = uma forma de programar onde existe um conjunto de funções que podem ser verificadas pra obter determinado
 resultado.

 # Interfaces Funcionais = é aquela que contém apenas um método abstrato, sendo assim, este método especifica a finalidade desta interface.
 Norlamente representam uma única ação, acabam fornecendo um tipo alvo para as expressões lambdas e as referências
    * Function: uma função que recebe um único argumento;
    * Predicate: função que recebe um único parâmetro e retorna um booleano;
    * Consumer: função que recebe um único parâmetro, é void;

 # Stream = é uma seqência de elementos. Nesta há funções para operações em massa, provomendo assim, fácil manipulação dos elementos
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

interface Num {
    double getValor();
}

interface ValorNumerico {
    boolean testador(int numero);
};

interface ValorNumericoSecond {
    boolean testador(int numero, int numero2);
};


public class LambdasUtilExcriptBrasil {
    public static void main(String[] args) {
        executaTesteLambdasIteracaoInterna07();
    }

    public static void filtro(List<String> lista, Predicate<String> condicao) {
        for (String s : lista) {
            if (condicao.test(s))
                System.out.println(s);
        }
    }

    public static void filtroStream(List<String> lista, Predicate<String> condicao) {
        lista.stream().filter(condicao).forEach(System.out::println);
    }

    static void executaTesteLambdas01() {
        System.out.println("Iniciando teste....");

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Verificando a expressao lambada 01....");
            }
        };

        Runnable r2 = () -> System.out.println("Verificando a expressao lambada 02....");

        r1.run();
        r2.run();
    }

    static void executaTesteLambdas02() {
        Num num;
        num = () -> 333.12;
        System.out.println(num.getValor());
    }

    static void executaTesteLambdas03() {
        Num num;
        num = () -> 333.12;
        System.out.println(num.getValor());

        Num n2 = () -> Math.random() * 100;
        System.out.println(n2.getValor());
        System.out.println(n2.getValor());

        ValorNumerico isPar = (int n) -> (n % 2) == 0;
        System.out.println(isPar.testador(89));
        System.out.println(isPar.testador(90));
    }

    static void executaTesteLambdas04() {
        ValorNumericoSecond isDiv = (x, y) -> (x % y) == 0;
        System.out.println(isDiv.testador(10, 2));
        System.out.println(isDiv.testador(10, 3));

        ValorNumerico exp1 = n -> (n % 2) == 0;
        ValorNumericoSecond exp2 = (x, y) -> (x % y) == 0;

        ValorNumericoSecond exp3 = (x, y) -> {
            int w = (x + y);
            return w * 4 > 1000;
        };
    }

    static void executaTesteLambdasStream05() {
        List<String> estados = Arrays.asList("Maranhao", "Parana", "Sao Paulo");
        estados.forEach(System.out::println);
    }

    static void executaTesteLambdasPredicate06() {
        List<String> estados = Arrays.asList("Maranhao", "Parana", "Sao Paulo", "Sergipe", "Rio de Janeiro", "Santa Catarina");

        System.out.println(" ");
        System.out.println("Estados que iniciam com a letra S:");
        filtro(estados, (s) -> s.startsWith("S"));

        System.out.println(" ");
        System.out.println("Estados que finalizam com a letra o:");
        filtro(estados, (s) -> s.endsWith("o"));

        System.out.println(" ");
        System.out.println("Imprimindo toda a lista");
        filtro(estados, (s) -> Boolean.TRUE);

        System.out.println(" ");
        System.out.println("Deixando de imprimir toda a lista");
        filtro(estados, (s) -> Boolean.FALSE);

        System.out.println(" ");
        System.out.println("Imprime os nomes dos estados com mais de 10 caracteres:");
        filtro(estados, (s) -> s.length() > 10);
    }

    static void executaTesteLambdasIteracaoInterna07() {
        List<String> estados = Arrays.asList("Maranhao", "Parana", "Sao Paulo", "Sergipe", "Rio de Janeiro", "Santa Catarina");

        System.out.println(" ");
        System.out.println("Estados que iniciam com a letra S:");
        filtroStream(estados, (s) -> s.startsWith("S"));

        System.out.println(" ");
        System.out.println("Estados que finalizam com a letra o:");
        filtroStream(estados, (s) -> s.endsWith("o"));

        System.out.println(" ");
        System.out.println("Imprimindo toda a lista");
        filtroStream(estados, (s) -> Boolean.TRUE);

        System.out.println(" ");
        System.out.println("Deixando de imprimir toda a lista");
        filtroStream(estados, (s) -> Boolean.FALSE);

        System.out.println(" ");
        System.out.println("Imprime os nomes dos estados com mais de 10 caracteres:");
        filtroStream(estados, (s) -> s.length() > 10);
    }

}
