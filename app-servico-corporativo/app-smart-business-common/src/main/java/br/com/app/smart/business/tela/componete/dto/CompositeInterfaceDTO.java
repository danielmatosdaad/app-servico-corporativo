package br.com.app.smart.business.tela.componete.dto;

import java.io.Serializable;
import java.util.Map;


public class CompositeInterfaceDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String nome;

	public String nomeExibicao;

	public String descricao;
	
	public Map<String, String> atributos;
	
	public ComponenteDTO componente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeExibicao() {
		return nomeExibicao;
	}

	public void setNomeExibicao(String nomeExibicao) {
		this.nomeExibicao = nomeExibicao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Map<String, String> getAtributos() {
		return atributos;
	}

	public void setAtributos(Map<String, String> atributos) {
		this.atributos = atributos;
	}

	public ComponenteDTO getComponente() {
		return componente;
	}

	public void setComponente(ComponenteDTO componente) {
		this.componente = componente;
	}

	
}
