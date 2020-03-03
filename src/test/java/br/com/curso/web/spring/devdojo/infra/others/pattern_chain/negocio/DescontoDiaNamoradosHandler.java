package br.com.curso.web.spring.devdojo.infra.others.pattern_chain.negocio;

import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Compra;
import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Promocao;

import java.math.BigDecimal;
import java.util.Objects;

public class DescontoDiaNamoradosHandler extends Desconto {

    private final static double VALOR_DESCONTO_NAMORADOS = 15.00;

    @Override
    public void desconto(Promocao promocao, Compra compra) {
        if (isDescontoDiaDosNamorados(promocao, compra))
            compra.aplicarDesconto(VALOR_DESCONTO_NAMORADOS);

        if (Objects.nonNull(proximo))
            proximo.desconto(promocao, compra);
    }

    public boolean isParamValidos(Promocao promocao, Compra compra) {
        return (Objects.nonNull(promocao) && Objects.nonNull(compra));
    }

    public boolean isDescontoDiaDosNamorados(Promocao promocao, Compra compra) {
        return (this.isParamValidos(promocao, compra) && promocao.isDiaDosNamorados() && compra.getPromocao().isDiaDosNamorados());
    }
}
