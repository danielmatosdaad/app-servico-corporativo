package br.com.app.smart.business.tela.componete.dto;

import java.io.Serializable;

public class CompositeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CompositeInterfaceDTO interfaces;
	private CompositeImplentationDTO impletation;
	
	

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

}
