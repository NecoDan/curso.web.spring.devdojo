package br.com.curso.web.spring.devdojo.infra.others.tddcasacodigo.service;

import br.com.curso.web.spring.devdojo.infra.others.tddcasacodigo.model.CarrinhoDeCompras;
import br.com.curso.web.spring.devdojo.infra.others.tddcasacodigo.model.MaiorEMenor;
import br.com.curso.web.spring.devdojo.infra.others.tddcasacodigo.model.Produto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

@Slf4j
public class MaiorEMenorTest {

    @Test
    public void deveTestarProdutosMenorEMaiorAPartirCarrinhosComprasInicial() {
        // -- 01_Cenário
        CarrinhoDeCompras c = CarrinhoDeCompras.builder()
                .build()
                .adicionar(Produto.builder()
                        .descricao("Liquidificador")
                        .valor(BigDecimal.valueOf(250.0))
                        .build())
                .adicionar(Produto.builder()
                        .descricao("Geladeira")
                        .valor(BigDecimal.valueOf(450.0))
                        .build())
                .adicionar(Produto.builder()
                        .descricao("Jogo de Pratos")
                        .valor(BigDecimal.valueOf(70.0))
                        .build());

        // 02_Ação
        MaiorEMenor maiorEMenorAlgoritmo = MaiorEMenor.builder().build();
        maiorEMenorAlgoritmo.encontra(c);

        // 03_Verificação=Validação
        Assert.assertEquals("Jogo de Pratos", maiorEMenorAlgoritmo.getMenor().getDescricao());
        Assert.assertEquals("Geladeira", maiorEMenorAlgoritmo.getMaior().getDescricao());

        log.info("{} ", "#TEST: deveTestarProdutosMenorEMaiorAPartirCarrinhosComprasInicial: ");
        log.info("{} ", "MENOR Produto: ".concat(maiorEMenorAlgoritmo.getMenor().getDescricao()));
        log.info("{} ", "MAIOR Produto: ".concat(maiorEMenorAlgoritmo.getMaior().getDescricao()));
        log.info("{} ", "Valor Total Produtos: ".concat(c.getValorTotal().toPlainString()));
    }

    @Test
    public void deveTestarProdutosMenorEMaiorAPartirCarrinhosComprasInverteOrdem() {
        // -- 01_Cenário
        CarrinhoDeCompras c = CarrinhoDeCompras.builder()
                .build()
                .adicionar(Produto.builder()
                        .descricao("Geladeira")
                        .valor(BigDecimal.valueOf(450.0))
                        .build())
                .adicionar(Produto.builder()
                        .descricao("Liquidificador")
                        .valor(BigDecimal.valueOf(250.0))
                        .build())
                .adicionar(Produto.builder()
                        .descricao("Jogo de Pratos")
                        .valor(BigDecimal.valueOf(70.0))
                        .build());

        // 02_Ação
        MaiorEMenor maiorEMenorAlgoritmo = MaiorEMenor.builder().build();
        maiorEMenorAlgoritmo.encontra(c);

        // 03_Verificação=Validação
        Assert.assertEquals("Jogo de Pratos", maiorEMenorAlgoritmo.getMenor().getDescricao());
        Assert.assertEquals("Geladeira", maiorEMenorAlgoritmo.getMaior().getDescricao());

        log.info("{} ", "#TEST: deveTestarProdutosMenorEMaiorAPartirCarrinhosComprasInverteOrdem: ");
        log.info("{} ", "MENOR Produto: ".concat(maiorEMenorAlgoritmo.getMenor().getDescricao()));
        log.info("{} ", "MAIOR Produto: ".concat(maiorEMenorAlgoritmo.getMaior().getDescricao()));
        log.info("{} ", "Valor Total Produtos: ".concat(c.getValorTotal().toPlainString()));
    }

    @Test
    public void deveTestarProdutosMenorEMaiorApenasComUmProdutoNoCarrinho(){
        // -- 01_Cenário
        Produto p = Produto.builder()
                .descricao("Geladeira")
                .valor(BigDecimal.valueOf(450.0))
                .build();

        CarrinhoDeCompras c = CarrinhoDeCompras.builder()
                .build()
                .adicionar(p);

        // 02_Ação
        MaiorEMenor maiorEMenorAlgoritmo = MaiorEMenor.builder().build();
        maiorEMenorAlgoritmo.encontra(c);

        // 03_Verificação=Validação
        Assert.assertEquals(p, maiorEMenorAlgoritmo.getMenor());
        Assert.assertEquals(p, maiorEMenorAlgoritmo.getMaior());

        log.info("{} ", "#TEST: deveTestarProdutosMenorEMaiorAPartirCarrinhosComprasInverteOrdem: ");
        log.info("{} ", "MENOR Produto: ".concat(maiorEMenorAlgoritmo.getMenor().getDescricao()));
        log.info("{} ", "MAIOR Produto: ".concat(maiorEMenorAlgoritmo.getMaior().getDescricao()));
        log.info("{} ", "Valor Total Produtos: ".concat(c.getValorTotal().toPlainString()));
    }
}
