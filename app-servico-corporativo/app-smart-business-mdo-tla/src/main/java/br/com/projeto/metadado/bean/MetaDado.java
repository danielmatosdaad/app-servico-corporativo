package br.com.projeto.metadado.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metadado")
public class MetaDado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeMetadado;

	private Conteudo conteudo;

	public MetaDado() {
		// TODO Auto-generated constructor stub
	}

	public MetaDado(Conteudo conteudo) {

		this.conteudo = conteudo;

	}

	@XmlElement(name = "conteudo")
	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public String getNomeMetadado() {
		return nomeMetadado;
	}

	public void setNomeMetadado(String nomeMetadado) {
		this.nomeMetadado = nomeMetadado;
	}

}
