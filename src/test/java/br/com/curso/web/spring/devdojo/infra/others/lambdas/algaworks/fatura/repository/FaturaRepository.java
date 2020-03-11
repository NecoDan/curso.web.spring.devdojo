package br.com.curso.web.spring.devdojo.infra.others.lambdas.algaworks.fatura.repository;

import br.com.curso.web.spring.devdojo.infra.others.lambdas.algaworks.fatura.model.Fatura;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FaturaRepository {
    public List<Fatura> recuperarFaturasVencidas() {
        List<Fatura> faturasVencidas = new ArrayList<>();
        faturasVencidas.add(Fatura.builder()
                .emailDevedor("gustavo@gmail.com")
                .valor(BigDecimal.valueOf(350.00))
                .dataVencimento(LocalDate.now().minusDays(3))
                .build());

        faturasVencidas.add(Fatura.builder()
                .emailDevedor("marcela@gmail.com")
                .valor(BigDecimal.valueOf(150.00))
                .dataVencimento(LocalDate.now().minusMonths(2).minusDays(2))
                .build());

        return faturasVencidas;
    }
}
