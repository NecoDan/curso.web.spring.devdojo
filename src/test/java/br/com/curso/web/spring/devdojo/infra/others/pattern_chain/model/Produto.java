package br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Produto {
    private String nome;
    private BigDecimal valor;
}
