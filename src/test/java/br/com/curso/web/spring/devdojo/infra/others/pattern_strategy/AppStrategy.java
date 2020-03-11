package br.com.curso.web.spring.devdojo.infra.others.pattern_strategy;

import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.model.Orcamento;
import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.negocio.ImpostoICMS;
import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.negocio.Imposto;
import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.negocio.ImpostoISS;
import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.service.CalculadoraImpostos;
import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy.service.ICalculadoraImpostos;

public class AppStrategy {
    public static void main(String[] args) {
        Orcamento orcamento = Orcamento
                .builder()
                .valor(500.0)
                .build();

        ICalculadoraImpostos calculadorImposto = new CalculadoraImpostos();
        Imposto iss = new ImpostoISS();
        calculadorImposto.realizaCalculo(orcamento, iss);

        Imposto icms = new ImpostoICMS();
        calculadorImposto.realizaCalculo(orcamento, icms);
    }
}
