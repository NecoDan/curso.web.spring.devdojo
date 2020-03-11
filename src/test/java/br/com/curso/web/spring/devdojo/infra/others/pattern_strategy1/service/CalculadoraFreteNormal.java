package br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.service;

import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.model.Frete;

import java.math.BigDecimal;
import java.util.Objects;

public class CalculadoraFreteNormal implements ICalculadoraFrete {

    private final static double VALOR_TAXA_NORMAL = 1.25;

    @Override
    public BigDecimal calcularValorFrete(Frete frete) {
        BigDecimal valorCalculado = BigDecimal.ZERO;

        if (Objects.isNull(frete))
            return valorCalculado;

        valorCalculado = BigDecimal.valueOf(Double.parseDouble(String.valueOf(frete.getDistancia())) * VALOR_TAXA_NORMAL + 10);
        return valorCalculado;
    }
}
