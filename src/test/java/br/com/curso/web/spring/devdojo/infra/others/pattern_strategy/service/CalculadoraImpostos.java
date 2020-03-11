package br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.service;

import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.model.Orcamento;
import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.negocio.Imposto;

public class CalculadoraImpostos implements ICalculadoraImpostos {

    @Override
    public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
        double valorImposto = imposto.calcula(orcamento);
        System.out.println(valorImposto);
    }
}
