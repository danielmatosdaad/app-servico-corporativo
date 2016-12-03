package br.com.projeto.facelet.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metadado")
public class Facelet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeMetadado;

	private String icon;

	private ConteudoFacelet conteudo;

	public Facelet() {
		// TODO Auto-generated constructor stub
	}

	public Facelet(ConteudoFacelet conteudo) {

		this.conteudo = conteudo;

	}

	@XmlElement(name = "conteudo")
	public ConteudoFacelet getConteudo() {
		return conteudo;
	}

	public void setConteudo(ConteudoFacelet conteudo) {
		this.conteudo = conteudo;
	}

	public String getNomeMetadado() {
		return nomeMetadado;
	}

	public void setNomeMetadado(String nomeMetadado) {
		this.nomeMetadado = nomeMetadado;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
