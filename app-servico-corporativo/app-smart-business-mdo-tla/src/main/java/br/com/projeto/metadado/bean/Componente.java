package br.com.projeto.metadado.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


public class Componente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeComponente;
	private String nameSpace;
	private List<Propriedade> propriedades;

	public Componente() {
		// TODO Auto-generated constructor stub
	}
	public Componente(String nomeComponente, String nameSpace,
			List<Propriedade> propriedades) {

		this.nomeComponente = nomeComponente;
		this.nameSpace = nameSpace;
		this.propriedades = propriedades;
	}

	@XmlAttribute(name="nomeComponente")
	public String getNomeComponente() {
		return nomeComponente;
	}


	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}

	@XmlAttribute(name="nameSpace")
	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	@XmlElement(name="propriedade")
	public List<Propriedade> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(List<Propriedade> propriedades) {
		this.propriedades = propriedades;
	}

}
