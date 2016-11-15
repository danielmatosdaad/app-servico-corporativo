package br.com.projeto.metadado.infra.comum.dto;

import java.io.Serializable;

public class MetaDadoComponenteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String metadadoXml;

	public String getMetadadoXml() {
		return metadadoXml;
	}

	public void setMetadadoXml(String metadadoXml) {
		this.metadadoXml = metadadoXml;
	}

}
