package br.com.app.smart.business.tela.componente.dto;

import java.io.Serializable;

public class CompositeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CompositeInterfaceDTO interfaces;
	private CompositeImplentationDTO impletation;
	private String icon;

	public CompositeInterfaceDTO getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(CompositeInterfaceDTO interfaces) {
		this.interfaces = interfaces;
	}

	public CompositeImplentationDTO getImpletation() {
		return impletation;
	}

	public void setImpletation(CompositeImplentationDTO impletation) {
		this.impletation = impletation;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
