package br.smartbusiness.metadado.uicomponent.bean;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metadado")
public class MetaDado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeMetadado;

	private List<Componente> componentes;

	public MetaDado() {
	}

	public MetaDado(List<Componente> componentes) {
		this.componentes = componentes;
	}

	@XmlElement(name = "componente")
	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	public String getNomeMetadado() {
		return nomeMetadado;
	}

	public void setNomeMetadado(String nomeMetadado) {
		this.nomeMetadado = nomeMetadado;
	}

}
