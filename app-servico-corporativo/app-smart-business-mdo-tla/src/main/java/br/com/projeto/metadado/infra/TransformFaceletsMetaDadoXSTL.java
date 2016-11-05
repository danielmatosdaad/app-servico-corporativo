package br.com.projeto.metadado.infra;

import java.io.File;
import java.net.URL;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import br.com.projeto.metadado.infra.comum.StringBufferOutputStream;

public class TransformFaceletsMetaDadoXSTL {

	private static final String TEMPLATE_XSL = "facelets_metadado.xslt";

	public static StringBuffer transform(File inXML) throws TransformerConfigurationException, TransformerException {

		try {

			System.out.println("Arquivo a ser processado:" + inXML.getName());
			URL urlXsl = TransformFaceletsMetaDadoXSTL.class.getResource(TEMPLATE_XSL);
			TransformerFactory factory = TransformerFactory.newInstance();
			StreamSource xslStream = new StreamSource(urlXsl.getPath());
			Transformer transformer = factory.newTransformer(xslStream);
			transformer.setErrorListener(new MyErrorListener());
			StreamSource in = new StreamSource(inXML);
			
			StringBuffer sb = new StringBuffer();
			StringBufferOutputStream streamBuffer = new StringBufferOutputStream(sb);
			
			StreamResult out = new StreamResult(streamBuffer);
			transformer.transform(in, out);
			return streamBuffer.getBuffer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
		return null;
	}


}

class MyErrorListener implements ErrorListener {
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
