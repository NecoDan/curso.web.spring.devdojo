package br.com.curso.web.spring.devdojo.infra.others.lambdas.algaworks.model;

public class EnviadorEmail {
    public void enviar(String to, String mensagem) {
        System.out.printf("Enviando e-mail para: %s ... Com o Texto: %s \n ", to, mensagem);
    }
}
