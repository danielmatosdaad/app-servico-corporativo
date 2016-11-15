package br.com.projeto.facelet.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ConteudoFacelet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeConteudo;
	private List<ComponenteFacelet> componentes;
	
	public ConteudoFacelet() {
		// TODO Auto-generated constructor stub
	}
	public ConteudoFacelet(List<ComponenteFacelet> componentes) {

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
	public List<ComponenteFacelet> getComponentes() {
		return componentes;
	}
	
	public void setComponentes(List<ComponenteFacelet> componentes) {
		this.componentes = componentes;
	}
	
	
}
