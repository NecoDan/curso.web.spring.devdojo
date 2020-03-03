package br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@ToString
public class Compra {

    private Promocao promocao;
    private Map<Produto, Integer> produtos;
    private BigDecimal valorDesconto;
    protected BigDecimal valorTotalCompra;

    public Compra() {
        this.produtos = new HashMap<>();
    }

    public void comprar(Produto produto, int quantidade) {
        int quantidadeTotal = quantidade;

        if (Objects.nonNull(this.produtos) && Objects.nonNull(this.produtos.get(produto))) {
            int quantidadeComprada = this.produtos.get(produto);
            quantidadeTotal = quantidadeComprada + quantidade;
        }

        this.produtos.put(produto, quantidadeTotal);
    }

    public void aplicarDesconto(double valorDesconto) {
        if (valorDesconto > 0.0)
            this.setValorDesconto(BigDecimal.valueOf(valorDesconto / 100));
    }

    public BigDecimal calcularComDesconto(BigDecimal valor) {
        BigDecimal valorTotalComDesconto = BigDecimal.ZERO;

        if (Objects.isNull(valor))
            return valorTotalComDesconto;

        if (Objects.isNull(this.getValorDesconto()))
            return valor;

        BigDecimal valorComDesconto = valor.multiply(this.getValorDesconto());
        return valor.subtract(valorComDesconto);
    }
}
