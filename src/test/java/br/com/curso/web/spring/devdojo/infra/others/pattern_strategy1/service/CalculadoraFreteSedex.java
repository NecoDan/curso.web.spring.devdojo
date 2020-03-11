package br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.service;

import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.model.Frete;

import java.math.BigDecimal;
import java.util.Objects;

public class CalculadoraFreteSedex implements ICalculadoraFrete {

    private final static double VALOR_TAXA_SEDEX = 1.45;

    @Override
    public BigDecimal calcularValorFrete(Frete frete) {
        BigDecimal valorCalculado = BigDecimal.ZERO;

        if (Objects.isNull(frete))
            return valorCalculado;

        valorCalculado = BigDecimal.valueOf(Double.parseDouble(String.valueOf(frete.getDistancia())) * VALOR_TAXA_SEDEX + 12);
        return valorCalculado;
    }
}
