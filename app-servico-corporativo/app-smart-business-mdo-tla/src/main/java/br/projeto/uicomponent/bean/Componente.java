package br.projeto.uicomponent.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "componente")
public class Componente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeComponente;

	private List<Propriedade> propriedades;

	private List<Componente> componentes;

	public Componente() {
	}

	public Componente(String nomeComponente, List<Propriedade> propriedades, List<Componente> componentes) {
		super();
		this.nomeComponente = nomeComponente;
		this.propriedades = propriedades;
		this.componentes = componentes;
	}

	@XmlAttribute(name = "nomeComponente")
	public String getNomeComponente() {
		return nomeComponente;
	}

	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}

	@XmlElement(name = "propriedade")
	public List<Propriedade> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(List<Propriedade> propriedades) {
		this.propriedades = propriedades;
	}

	@XmlElement(name = "componente")
	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

}
