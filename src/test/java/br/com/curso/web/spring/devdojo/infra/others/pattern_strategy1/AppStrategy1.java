package br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1;

import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.model.Frete;
import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.model.TipoFrete;
import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.service.ICalculadoraFrete;

public class AppStrategy1 {
    public static void main(String[] args) {
        ICalculadoraFrete calculadoraFrete = null;

        Frete freteNormal = Frete.builder().tipoFrete(TipoFrete.NORMAL).distancia(100).build();

        calculadoraFrete = freteNormal.getTipoFrete().obterFrete();
        freteNormal.calcularValorTotalFrete(calculadoraFrete.calcularValorFrete(freteNormal));
        System.out.printf("O valor total do frete NORMAL é = R$%.2f ", freteNormal.getValor().doubleValue());
        System.out.println();

        Frete freteSedex = Frete.builder().distancia(100).tipoFrete(TipoFrete.SEDEX).build();
        calculadoraFrete = freteSedex.getTipoFrete().obterFrete();
        freteSedex.calcularValorTotalFrete(calculadoraFrete.calcularValorFrete(freteSedex));
        System.out.printf("O valor total do frete VIA SEDEX é = R$%.2f ", freteSedex.getValor().doubleValue());
        System.out.println();

    }
}
