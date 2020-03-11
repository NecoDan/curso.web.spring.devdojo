package br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.service;

import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.model.Orcamento;
import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.negocio.Imposto;

public interface ICalculadoraImpostos {
    void realizaCalculo(Orcamento orcamento, Imposto imposto);
}
