package br.com.projeto.metadado.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Conteudo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeConteudo;
	private List<Componente> componentes;
	
	public Conteudo() {
		// TODO Auto-generated constructor stub
	}
	public Conteudo(List<Componente> componentes) {

		this.componentes=componentes;
	
	}
	
	@XmlAttribute(name="nomeConteudo")
	public String getNomeConteudo() {
		return nomeConteudo;
	}

	public void setNomeConteudo(String nomeConteudo) {
		this.nomeConteudo = nomeConteudo;
	}
	
	@XmlElement(name="componente")
	public List<Componente> getComponentes() {
		return componentes;
	}
	
	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}
	
	
}
