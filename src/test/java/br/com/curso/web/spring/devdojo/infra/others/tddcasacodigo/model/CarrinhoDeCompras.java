package br.com.curso.web.spring.devdojo.infra.others.tddcasacodigo.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CarrinhoDeCompras {

    private Long id;
    private BigDecimal valorTotal;
    private List<Produto> produtos;

    public void adiciona(Produto produto) {
        if (Objects.isNull(this.produtos))
            this.produtos = new ArrayList<>();

        if (Objects.isNull(this.valorTotal))
            this.valorTotal = BigDecimal.ZERO;

        this.produtos.add(produto);
        this.setValorTotal(this.valorTotal.add(Objects.isNull(produto.getValor()) ? BigDecimal.ZERO : produto.getValor()));
    }

    public CarrinhoDeCompras adicionar(Produto produto) {
        this.adiciona(produto);
        return this;
    }
}


