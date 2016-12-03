package br.smartbusiness.metadado.conversor;

import java.io.InputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import br.smartbusiness.metadado.conversor.enums.TipoConversaoXML;
import br.smartbusiness.metadado.infra.comum.ContextoJAXB;
import br.smartbusiness.metadado.infra.comum.StringBufferOutputStream;

public class ConversorXml<S> implements Conversor<S> {

	private ContextoJAXB contexto;

	private TipoConversaoXML tipoConversao;

	
	public ConversorXml(InputStream input) {

		this.contexto = new ContextoJAXB(input, InputStream.class);
		this.tipoConversao = TipoConversaoXML.INPUTSTREAM_STRING_INTANCIA;
	}
	
	public ConversorXml(String input) {

		this.contexto = new ContextoJAXB(input, String.class);
		this.tipoConversao = TipoConversaoXML.STRING_INTANCIA;
	}
	
	public ConversorXml(Object input, Class cast,TipoConversaoXML tipoConversao) {

		this.contexto = new ContextoJAXB(input, cast);
		this.tipoConversao = tipoConversao;
	}

	private Unmarshaller getUnmarshaller() throws JAXBException {

		return this.contexto.getContextosJAXB().createUnmarshaller();
	}

	public S converter() {

		if (this.contexto.getInstancia() == null || this.contexto.getTipoInstancia() == null) {
			throw new RuntimeException("Parametros de Construcao invalidos");
		}

		switch (tipoConversao) {
		case STRING_INTANCIA:
			return converterStringParaInstancia();

		case INPUTSTREAM_STRING_BUFFER:
			return converteStreamParaStringBuffer();
		case INPUTSTREAM_STRING_INTANCIA:
			return converterStreamParaInstancia();

		}
		return null;

	}

	public S converteStreamParaStringBuffer() {

		try {
			StringBufferOutputStream fluxoSaida = new StringBufferOutputStream();
			this.contexto.getContextosJAXB().createMarshaller().marshal(this.contexto.getInstancia(), fluxoSaida);

			return (S) fluxoSaida.getBuffer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private S converterStringParaInstancia() {

		try {
			StreamSource stream = new StreamSource(new StringReader((String) this.contexto.getInstancia()));
			return (S) getUnmarshaller().unmarshal(stream);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private S converterStreamParaInstancia() {

		try {
			StreamSource stream = new StreamSource((InputStream) this.contexto.getInstancia());
			return (S) getUnmarshaller().unmarshal(stream);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
