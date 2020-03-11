package br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.negocio;

import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.model.Orcamento;

import java.math.BigDecimal;

public class ImpostoICMS implements Imposto {

    private final static double PERCENTUAL_TAXA_ICMS = 8.00;

    @Override
    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * (PERCENTUAL_TAXA_ICMS/100);
    }

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        return BigDecimal.valueOf(calcula(orcamento));
    }
}