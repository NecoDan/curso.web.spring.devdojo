package br.com.curso.web.spring.devdojo.util.exceptions;

public class ValidacaoException extends Exception {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }

    public ValidacaoException(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}
