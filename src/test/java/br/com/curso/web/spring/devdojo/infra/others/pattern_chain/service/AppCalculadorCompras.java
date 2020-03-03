package br.com.curso.web.spring.devdojo.infra.others.pattern_chain.service;

import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Compra;
import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Produto;
import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Promocao;

import java.math.BigDecimal;

import static java.lang.String.format;

public class AppCalculadorCompras {

    public static void main(String[] args) {
        CalculadorValorCompraService calculadorValorCompraService = new CalculadorValorCompraService();

        Produto prodGeladeira = Produto
                .builder()
                .nome("Ventilador Mondial Maxi Power 140W 6 Pas 3 Velocidades, 40cm")
                .valor(BigDecimal.valueOf(94.90))
                .build();

        Compra compraNoLancamento = new Compra();
        compraNoLancamento.setPromocao(Promocao.SEM_DESCONTO);
        compraNoLancamento.comprar(prodGeladeira, 1);

        calculadorValorCompraService.efetuarCalculoCompra(compraNoLancamento);
        System.out.println(format("Valor do %s: R$ %.2f", prodGeladeira.getNome(), compraNoLancamento.getValorTotalCompra()));

        Compra compraDiaDosNamorados = new Compra();
        compraDiaDosNamorados.setPromocao(Promocao.DIA_NAMORADOS);
        compraDiaDosNamorados.comprar(prodGeladeira, 1);

        calculadorValorCompraService.efetuarCalculoCompra(compraDiaDosNamorados);
        System.out.println(format("Valor do %s: R$ %.2f", prodGeladeira.getNome(), compraDiaDosNamorados.getValorTotalCompra()));

        Compra compraNatal = new Compra();
        compraNatal.setPromocao(Promocao.NATAL);
        compraNatal.comprar(prodGeladeira, 1);

        calculadorValorCompraService.efetuarCalculoCompra(compraNatal);
        System.out.println(format("Valor do %s: R$ %.2f", prodGeladeira.getNome(), compraNatal.getValorTotalCompra()));
    }
}
