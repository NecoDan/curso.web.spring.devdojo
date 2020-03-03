package br.com.curso.web.spring.devdojo.infra.others.tdd_casacodigo.carrinho_compras.model;

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
    private Long id;
    private String descricao;
    private String codigoBarras;
    private BigDecimal valor;
}
