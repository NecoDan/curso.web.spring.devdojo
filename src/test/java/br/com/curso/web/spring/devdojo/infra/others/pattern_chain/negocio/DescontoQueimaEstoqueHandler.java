package br.com.curso.web.spring.devdojo.infra.others.pattern_chain.negocio;

import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Compra;
import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Promocao;

import java.math.BigDecimal;
import java.util.Objects;

public class DescontoQueimaEstoqueHandler extends Desconto {

    private final static double VALOR_DESCONTO_QUEIMA_ESTOQUE = 25.00;

    @Override
    public void desconto(Promocao promocao, Compra compra) {
        if (isDescontoQueimaEstoque(promocao, compra))
            compra.aplicarDesconto(VALOR_DESCONTO_QUEIMA_ESTOQUE);

        if (Objects.nonNull(proximo))
            proximo.desconto(promocao, compra);
    }

    private boolean isParamValidos(Promocao promocao, Compra compra) {
        return (Objects.nonNull(promocao) && Objects.nonNull(compra));
    }

    private boolean isDescontoQueimaEstoque(Promocao promocao, Compra compra) {
        return (this.isParamValidos(promocao, compra) && promocao.isQueimaEstoque() && compra.getPromocao().isQueimaEstoque());
    }
}
