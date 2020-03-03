package br.com.curso.web.spring.devdojo.infra.others.pattern_chain.service;

import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Compra;
import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Produto;
import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Promocao;
import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.negocio.Desconto;
import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.negocio.DescontoDiaNamoradosHandler;
import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.negocio.DescontoNatalHandler;
import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.negocio.DescontoQueimaEstoqueHandler;

import java.math.BigDecimal;
import java.util.Map;

public class CalculadorValorCompraService {

    private Desconto desconto;

    public CalculadorValorCompraService() {
        Desconto descontoDiaDosNamorados = new DescontoDiaNamoradosHandler();
        Desconto descontoNatal = new DescontoNatalHandler();
        Desconto descontoQueimaEstoque = new DescontoQueimaEstoqueHandler();

        this.desconto = descontoDiaDosNamorados;
        descontoDiaDosNamorados.setProximo(descontoNatal);
        descontoNatal.setProximo(descontoQueimaEstoque);
    }

    public void efetuarCalculoCompra(Compra compra) {
        compra.setValorTotalCompra(this.valorCompra(compra.getPromocao(), compra));
    }

    public BigDecimal valorCompra(Compra compra) {
        return this.valorCompra(compra.getPromocao(), compra);
    }

    private BigDecimal valorCompra(Promocao promocao, Compra compra) {
        this.desconto.desconto(promocao, compra);

        BigDecimal valorTotal = BigDecimal.ZERO;
        for (Map.Entry<Produto, Integer> produtoEntry : compra.getProdutos().entrySet()) {
            BigDecimal valorProduto = produtoEntry.getKey().getValor().multiply(BigDecimal.valueOf(produtoEntry.getValue()));
            valorTotal = valorTotal.add(BigDecimal.valueOf(valorProduto.doubleValue()));
        }

        return compra.calcularComDesconto(valorTotal);
    }
}
