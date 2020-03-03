package br.com.curso.web.spring.devdojo.infra.others.tdd_casacodigo.conversor_romano.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum SimbolNumeralRomano {

    UNUS(1, "I", "UNUS", "UM"),

    QUINQUE(5, "V", "QUINQUE", "CINCO"),

    DECEM(10, "X", "DECEM", "DEZ"),

    QUINQUAGINTA(50, "L", "QUINQUAGINTA", "CINQUENTA"),

    CENTUM(100, "C", "CENTUM", "CEM"),

    QUINGENTI(500, "D", "QUINGENTI", "QUINHENTOS"),

    MILLE(1000, "M", "MILLE", "MIL");

    private static Map<Integer, SimbolNumeralRomano> lookup;
    private static Map<String, SimbolNumeralRomano> lookupNumeral;

    static {
        lookup = new HashMap<>();
        EnumSet<SimbolNumeralRomano> enumSet = EnumSet.allOf(SimbolNumeralRomano.class);

        for (SimbolNumeralRomano type : enumSet)
            lookup.put(type.codigo, type);
    }

    static {
        lookupNumeral = new HashMap<>();
        EnumSet<SimbolNumeralRomano> enumSet = EnumSet.allOf(SimbolNumeralRomano.class);

        for (SimbolNumeralRomano type : enumSet)
            lookupNumeral.put(type.numeral, type);
    }

    private int codigo;
    private String numeral;
    private String descricao;
    private String descricaoLiteral;

    SimbolNumeralRomano(int codigo, String numeral, String descricao, String descricaoLiteral) {
        inicialize(codigo, numeral, descricao, descricaoLiteral);
    }

    private void inicialize(int codigo, String numeral, String descricao, String descricaoLiteral) {
        this.codigo = codigo;
        this.numeral = numeral;
        this.descricao = descricao;
        this.descricaoLiteral = descricaoLiteral;
    }

    public static SimbolNumeralRomano fromCodigo(int codigo) {
        if (lookup.containsKey(codigo))
            return lookup.get(codigo);

        throw new IllegalArgumentException(String.format("Código do número Romano inválido: %d", codigo));
    }

    public static SimbolNumeralRomano fromNumeral(String numeral) {
        if (lookupNumeral.containsKey(numeral))
            return lookupNumeral.get(numeral);

        throw new IllegalArgumentException("Numeral referente ao padrão dos números romanos inválido:".concat(numeral));
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNumeral() {
        return this.numeral;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getDescricaoLiteral() {
        return this.descricaoLiteral;
    }

    public String toStringSimples() {
        return String.valueOf(this.codigo).concat(" - ").concat(this.getDescricaoLiteral());
    }

    public Boolean isUnus() {
        return Objects.equals(this, SimbolNumeralRomano.UNUS);
    }

    public Boolean isQuinque() {
        return Objects.equals(this, SimbolNumeralRomano.QUINQUE);
    }

    public Boolean isDecem() {
        return Objects.equals(this, SimbolNumeralRomano.DECEM);
    }

    public Boolean isQuinquaginta() {
        return Objects.equals(this, SimbolNumeralRomano.QUINQUAGINTA);
    }

    public Boolean isCentum() {
        return Objects.equals(this, SimbolNumeralRomano.CENTUM);
    }

    public Boolean isQuingenti() {
        return Objects.equals(this, SimbolNumeralRomano.QUINGENTI);
    }

    public Boolean isMille() {
        return Objects.equals(this, SimbolNumeralRomano.MILLE);
    }
}
