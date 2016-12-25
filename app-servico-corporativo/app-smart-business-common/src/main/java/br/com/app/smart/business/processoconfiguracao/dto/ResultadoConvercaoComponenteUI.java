package br.com.app.smart.business.processoconfiguracao.dto;

import java.io.Serializable;
import java.util.List;

public class ResultadoConvercaoComponenteUI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<StringBuffer> componeteXhtml;
	private List<StringBuffer> componenteXml;

	public List<StringBuffer> getComponeteXhtml() {
		return componeteXhtml;
	}

	public void setComponeteXhtml(List<StringBuffer> componeteXhtml) {
		this.componeteXhtml = componeteXhtml;
	}

	public List<StringBuffer> getComponenteXml() {
		return componenteXml;
	}

	public void setComponenteXml(List<StringBuffer> componenteXml) {
		this.componenteXml = componenteXml;
	}

}
