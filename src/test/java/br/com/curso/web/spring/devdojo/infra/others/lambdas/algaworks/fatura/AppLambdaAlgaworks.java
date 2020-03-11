package br.com.curso.web.spring.devdojo.infra.others.lambdas.algaworks.fatura;

import br.com.curso.web.spring.devdojo.infra.others.lambdas.algaworks.fatura.model.EnviadorEmail;
import br.com.curso.web.spring.devdojo.infra.others.lambdas.algaworks.fatura.model.Fatura;
import br.com.curso.web.spring.devdojo.infra.others.lambdas.algaworks.fatura.repository.FaturaRepository;

import java.util.List;

public class AppLambdaAlgaworks {
    public static void main(String[] args) {
        EnviadorEmail enviadorEmail = new EnviadorEmail();

        List<Fatura> faturas = new FaturaRepository().recuperarFaturasVencidas();
        faturas.forEach(f -> enviadorEmail.enviar(f.getEmailDevedor(), f.toStringResumoFatura()));
    }
}
