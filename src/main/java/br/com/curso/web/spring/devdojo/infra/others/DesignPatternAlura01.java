package br.com.curso.web.spring.devdojo.infra.others;

import lombok.*;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
class Orcamento {
    private double valor;
}

class CalculadorImposto {
    public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
        double valorImposto = imposto.calcula(orcamento);
        System.out.println(valorImposto);
    }
}

interface Imposto {
    double calcula(Orcamento orcamento);

    BigDecimal calcular(Orcamento orcamento);
}

class ICMS implements Imposto {
    @Override
    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * 0.1;
    }

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        return BigDecimal.valueOf(this.calcula(orcamento));
    }
}

class ISS implements Imposto {
    @Override
    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * 0.06;
    }

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        return BigDecimal.valueOf(this.calcula(orcamento));
    }
}

public class DesignPatternAlura01 {
    public static void main(String[] args) {
        Imposto iss = new ISS();
        Imposto icms = new ICMS();

        Orcamento orcamento = Orcamento.builder().valor(500.0).build();

        CalculadorImposto calculadora = new CalculadorImposto();
        calculadora.realizaCalculo(orcamento, iss);
        calculadora.realizaCalculo(orcamento, icms);
    }
}
