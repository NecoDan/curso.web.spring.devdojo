package br.com.curso.web.spring.devdojo.infra.others.pattern_chain.negocio;

import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Compra;
import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Promocao;

import java.math.BigDecimal;
import java.util.Objects;

public class DescontoNatalHandler extends Desconto {

    private final static double VALOR_DESCONTO_NATAL = 20.00;

    @Override
    public void desconto(Promocao promocao, Compra compra) {
        if (isDescontoNatal(promocao, compra))
            compra.aplicarDesconto(VALOR_DESCONTO_NATAL);

        if (Objects.nonNull(proximo))
            proximo.desconto(promocao, compra);
    }

    private boolean isParamValidos(Promocao promocao, Compra compra) {
        return (Objects.nonNull(promocao) && Objects.nonNull(compra));
    }

    private boolean isDescontoNatal(Promocao promocao, Compra compra) {
        return (this.isParamValidos(promocao, compra) && promocao.isNatal() && compra.getPromocao().isNatal());
    }
}
