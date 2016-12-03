package br.smartbusiness.metadado.infra.comum;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

public class MyErrorListener implements ErrorListener {
	public void warning(TransformerException e) throws TransformerException {
		show("Warning", e);
		throw (e);
	}

	public void error(TransformerException e) throws TransformerException {
		show("Error", e);
		throw (e);
	}

	public void fatalError(TransformerException e) throws TransformerException {
		show("Fatal Error", e);
		throw (e);
	}

	private void show(String type, TransformerException e) {
		System.out.println(type + ": " + e.getMessage());
		if (e.getLocationAsString() != null)
			System.out.println(e.getLocationAsString());

	}
}
