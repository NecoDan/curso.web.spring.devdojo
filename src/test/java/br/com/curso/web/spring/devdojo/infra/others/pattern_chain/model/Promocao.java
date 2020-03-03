package br.com.curso.web.spring.devdojo.infra.others.pattern_chain.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum Promocao {

    SEM_DESCONTO(1, "SEM DESCONTO"),

    DIA_NAMORADOS(2, "SEM DESCONTO"),

    NATAL(3, "SEM DESCONTO"),

    QUEIMA_ESTOQUE(5, "SEM DESCONTO"),

    DESCONTO_PROGRESSIVO(5, "SEM DESCONTO");

    private static Map<Integer, Promocao> lookup;

    static {
        lookup = new HashMap<>();
        EnumSet<Promocao> enumSet = EnumSet.allOf(Promocao.class);

        for (Promocao type : enumSet)
            lookup.put(type.codigo, type);
    }

    private int codigo;
    private String descricao;

    Promocao(int codigo, String descricao) {
        inicialize(codigo, descricao);
    }

    private void inicialize(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Promocao fromCodigo(int codigo) {
        if (lookup.containsKey(codigo))
            return lookup.get(codigo);

        throw new IllegalArgumentException(String.format("Código do número da promoção inválida: %d", codigo));
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public boolean isDiaDosNamorados() {
        return Objects.equals(this, Promocao.DIA_NAMORADOS);
    }

    public boolean isNatal() {
        return Objects.equals(this, Promocao.NATAL);
    }

    public boolean isQueimaEstoque() {
        return Objects.equals(this, Promocao.QUEIMA_ESTOQUE);
    }

}
