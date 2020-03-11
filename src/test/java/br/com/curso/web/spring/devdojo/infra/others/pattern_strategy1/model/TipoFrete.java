package br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.model;

import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.service.CalculadoraFreteNormal;
import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.service.CalculadoraFreteSedex;
import br.com.curso.web.spring.devdojo.infra.others.pattern_strategy1.service.ICalculadoraFrete;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TipoFrete {

    NORMAL(1, "NORMAL") {
        @Override
        public ICalculadoraFrete obterFrete() {
            return new CalculadoraFreteNormal();
        }
    },

    PAC(2, "PAC") {
        @Override
        public ICalculadoraFrete obterFrete() {
            return null;
        }
    },

    SEDEX(3, "SEDEX") {
        @Override
        public ICalculadoraFrete obterFrete() {
            return new CalculadoraFreteSedex();
        }
    };

    private static Map<Integer, TipoFrete> lookup;

    static {
        lookup = new HashMap<>();
        EnumSet<TipoFrete> enumSet = EnumSet.allOf(TipoFrete.class);

        for (TipoFrete type : enumSet)
            lookup.put(type.codigo, type);
    }

    private int codigo;
    private String descricao;

    TipoFrete(int codigo, String descricao) {
        inicialize(codigo, descricao);
    }

    private void inicialize(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TipoFrete fromCodigo(int codigo) {
        if (lookup.containsKey(codigo))
            return lookup.get(codigo);

        throw new IllegalArgumentException(String.format("Código do Tipo Frete inválido: %d", codigo));
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public abstract ICalculadoraFrete obterFrete();
}
