package br.com.app.smart.business.tela.componete.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "componente")
public class ComponenteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nameSpace;

	private String nomeComponente;

	private List<PropriedadeDTO> propriedades;

	private List<ComponenteDTO> componentes;

	public ComponenteDTO() {
	}

	public ComponenteDTO(String nomeComponente, List<PropriedadeDTO> propriedades, List<ComponenteDTO> componentes) {
		super();
		this.nomeComponente = nomeComponente;
		this.propriedades = propriedades;
		this.componentes = componentes;
	}

	public ComponenteDTO(String nomeComponente, String nameSpace, List<PropriedadeDTO> propriedades) {

		super();
		this.nomeComponente = nomeComponente;
		this.nameSpace = nameSpace;
		this.propriedades = propriedades;
	}

	public ComponenteDTO(String nomeComponente, String nameSpace, List<PropriedadeDTO> propriedades,
			List<ComponenteDTO> componentes) {

		super();
		this.nomeComponente = nomeComponente;
		this.nameSpace = nameSpace;
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
	public List<PropriedadeDTO> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(List<PropriedadeDTO> propriedades) {
		this.propriedades = propriedades;
	}

	@XmlElement(name = "componente")
	public List<ComponenteDTO> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<ComponenteDTO> componentes) {
		this.componentes = componentes;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	@XmlAttribute(name = "nameSpace")
	public String getNameSpace() {
		return nameSpace;
	}


}
