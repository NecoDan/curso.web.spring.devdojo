package br.com.curso.web.spring.devdojo.infra;

public class CustomErrorType {

	private String erroMensagem;

	public CustomErrorType(String erroMensagem) {
		this.erroMensagem = erroMensagem;
	}

	public String getErroMensagem() {
		return erroMensagem;
	}
}
