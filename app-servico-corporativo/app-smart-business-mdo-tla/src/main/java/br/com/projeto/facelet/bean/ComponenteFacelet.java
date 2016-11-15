package br.com.projeto.facelet.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


public class ComponenteFacelet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeComponente;
	private String nameSpace;
	private List<PropriedadeComponenteFacelet> propriedades;

	public ComponenteFacelet() {
		// TODO Auto-generated constructor stub
	}
	public ComponenteFacelet(String nomeComponente, String nameSpace,
			List<PropriedadeComponenteFacelet> propriedades) {

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
	public List<PropriedadeComponenteFacelet> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(List<PropriedadeComponenteFacelet> propriedades) {
		this.propriedades = propriedades;
	}

}
