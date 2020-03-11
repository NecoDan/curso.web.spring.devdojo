package br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Frete {

    private BigDecimal valor;
    private int distancia = 0;
    private TipoFrete tipoFrete;

    public void calcularValorTotalFrete(BigDecimal valorTaxa) {
        if (Objects.isNull(this.valor))
            this.valor = BigDecimal.ZERO;

        this.valor = new BigDecimal(String.valueOf(this.valor.add(valorTaxa)));
    }
}
