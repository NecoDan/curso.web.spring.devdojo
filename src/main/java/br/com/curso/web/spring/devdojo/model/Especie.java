package br.com.curso.web.spring.devdojo.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Especie {

    private Long especieId;
    private String descricao;
    private String name;
    private Boolean ativo;
    private LocalDateTime dataCadastro;
}
