package br.com.curso.web.spring.devdojo.model;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Estudante {

    private Long id;
    private String nome;
    public static List<Estudante> estudantes;

    static {
        estudanteRepository();
    }

    private static void estudanteRepository() {
        estudantes = new ArrayList<Estudante>(Arrays.asList(
                new Estudante(1L, "Daniel"),
                new Estudante(2L, "Daniel Santos"),
                new Estudante(3L, "Daniele Freitas")));
    }
}
