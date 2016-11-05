package br.com.app.smart.business.dto;

import br.com.app.smart.business.interfaces.IResultadoService;

public class RespostaDTO<D> implements IResultadoService<D> {

	private Boolean sucessso = Boolean.FALSE;
	private String mensagem = "";

	private D resposta;

	public RespostaDTO(D resposta, Boolean sucesso, String mensagem) {
		this.resposta = resposta;
		this.sucessso = sucesso;
		this.mensagem = mensagem;
	}

	public D getResposta() {
		return resposta;
	}

	public Boolean isSucesso() {

		return sucessso;
	}

	public String getMensagem() {

		return mensagem;
	}

}
