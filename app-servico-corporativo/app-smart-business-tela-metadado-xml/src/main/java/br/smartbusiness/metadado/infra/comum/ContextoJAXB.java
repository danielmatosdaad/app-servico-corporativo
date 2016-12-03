package br.smartbusiness.metadado.infra.comum;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class ContextoJAXB {

	private JAXBContext contextosJAXB;
	private Object instancia;
	private Class clazz;

	public ContextoJAXB(Object instancia, Class clazz) {

		try {
			this.clazz = clazz;
			this.instancia = instancia;
			this.contextosJAXB = JAXBContext.newInstance(clazz);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ContextoJAXB(Class clazz) {

		try {
			this.clazz = clazz;
			this.contextosJAXB = JAXBContext.newInstance(clazz);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JAXBContext getContextosJAXB() {
		return contextosJAXB;
	}

	public Object getInstancia() {

		return this.instancia;
	}

	public Class getTipoInstancia() {

		return this.clazz;
	}

}
