package br.com.curso.web.spring.devdojo.infra.others.pattern_chain.negocio;

import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Compra;
import br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model.Promocao;

public abstract class Desconto {

    protected Desconto proximo;

    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }

    public abstract void desconto(Promocao promocao, Compra compra);
}
