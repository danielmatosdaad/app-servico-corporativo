package br.com.app.smart.business.tela.componete.dto;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metadado")
public class ComponenteTelaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeMetadado;

	private List<ComponenteDTO> componentes;

	public ComponenteTelaDTO() {
	}

	public ComponenteTelaDTO(List<ComponenteDTO> componentes) {
		this.componentes = componentes;
	}

	@XmlElement(name = "componente")
	public List<ComponenteDTO> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<ComponenteDTO> componentes) {
		this.componentes = componentes;
	}

	public String getNomeMetadado() {
		return nomeMetadado;
	}

	public void setNomeMetadado(String nomeMetadado) {
		this.nomeMetadado = nomeMetadado;
	}

}
