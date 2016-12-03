package br.smartbusiness.metadado.uicomponent.bean;

import java.io.Serializable;

public class Propriedade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	private String valor;

	public Propriedade() {

	}

	public Propriedade(String nome, String valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
