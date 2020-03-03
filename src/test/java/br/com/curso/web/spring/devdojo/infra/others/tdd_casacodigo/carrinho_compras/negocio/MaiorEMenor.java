package br.com.curso.web.spring.devdojo.infra.others.tdd_casacodigo.carrinho_compras.negocio;

import br.com.curso.web.spring.devdojo.infra.others.tdd_casacodigo.carrinho_compras.model.CarrinhoDeCompras;
import br.com.curso.web.spring.devdojo.infra.others.tdd_casacodigo.carrinho_compras.model.Produto;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MaiorEMenor {

    private Produto menor;
    private Produto maior;

    public void encontra(CarrinhoDeCompras carrinho) {
        for (Produto produto : carrinho.getProdutos()) {
            if (Objects.isNull(this.menor) || produto.getValor().doubleValue() < this.menor.getValor().doubleValue())
                this.menor = produto;

            if (Objects.isNull(this.maior) || produto.getValor().doubleValue() > this.maior.getValor().doubleValue())
                this.maior = produto;
        }
    }

    public void encontraLambda(CarrinhoDeCompras carrinho) {
        if (Objects.isNull(carrinho))
            return;
    }
}
