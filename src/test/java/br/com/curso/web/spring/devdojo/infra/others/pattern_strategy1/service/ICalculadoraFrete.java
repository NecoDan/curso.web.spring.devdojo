package br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.service;

import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.model.Frete;

import java.math.BigDecimal;

public interface ICalculadoraFrete {
    BigDecimal calcularValorFrete(Frete frete);
}
