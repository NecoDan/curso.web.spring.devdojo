package br.com.curso.web.spring.devdojo.infra.others.lambdas.algaworks.service;

import br.com.curso.web.spring.devdojo.infra.others.lambdas.algaworks.model.EnviadorEmail;
import br.com.curso.web.spring.devdojo.infra.others.lambdas.algaworks.model.Fatura;
import br.com.curso.web.spring.devdojo.infra.others.lambdas.algaworks.repository.FaturaRepository;

import java.util.List;

public class AppLambdaAlgaworks {
    public static void main(String[] args) {
        EnviadorEmail enviadorEmail = new EnviadorEmail();

        List<Fatura> faturas = new FaturaRepository().recuperarFaturasVencidas();
        faturas.forEach(f -> enviadorEmail.enviar(f.getEmailDevedor(), f.toStringResumoFatura()));
    }
}
