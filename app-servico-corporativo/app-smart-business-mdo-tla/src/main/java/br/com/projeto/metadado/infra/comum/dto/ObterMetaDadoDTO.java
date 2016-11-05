package br.com.projeto.metadado.infra.comum.dto;

import java.io.Serializable;

public class ObterMetaDadoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroFuncionalidade ;
	private int numeroTela;

	public int getNumeroFuncionalidade() {
		return numeroFuncionalidade;
	}

	public void setNumeroFuncionalidade(int numeroFuncionalidade) {
		this.numeroFuncionalidade = numeroFuncionalidade;
	}

	public int getNumeroTela() {
		return numeroTela;
	}

	public void setNumeroTela(int numeroTela) {
		this.numeroTela = numeroTela;
	}

}
