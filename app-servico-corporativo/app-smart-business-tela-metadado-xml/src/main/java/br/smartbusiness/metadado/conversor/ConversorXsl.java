package br.smartbusiness.metadado.conversor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import br.smartbusiness.metadado.conversor.enums.TemplateXsl;
import br.smartbusiness.metadado.conversor.enums.TipoConversaoXsl;
import br.smartbusiness.metadado.infra.comum.ContextoJAXB;
import br.smartbusiness.metadado.infra.comum.MyErrorListener;
import br.smartbusiness.metadado.infra.comum.StringBufferOutputStream;

public class ConversorXsl<S> implements Conversor<S> {

	private ContextoJAXB contexto;

	private TipoConversaoXsl tipoConversao;

	private TemplateXsl template;

	private File inXslFile;

	private StringBuffer inXslStrinBuffer;

	public ConversorXsl(StringBuffer inXml, StringBuffer inXsl) {

		this.contexto = new ContextoJAXB(inXml, inXml.getClass());
		this.inXslStrinBuffer = inXsl;
		this.tipoConversao = TipoConversaoXsl.CONVERTER_INSTANCIA_STRINBUFFER_USANDO_TEMPLATENAME_STRING_BUFFER;
	}

	public ConversorXsl(File inXml, File inXsl) {

		this.contexto = new ContextoJAXB(inXml, inXml.getClass());
		this.inXslFile = inXsl;
		this.tipoConversao = TipoConversaoXsl.CONVERTER_INSTANCIA_FILE_USANDO_TEMPLATENAME_FILE;
	}
	
	public ConversorXsl(File input, TemplateXsl template) {

		this.contexto = new ContextoJAXB(input, input.getClass());
		this.tipoConversao = TipoConversaoXsl.CONVERTER_INSTANCIA_FILE_USANDO_TEMPLATENAME;
		this.template = template;
	}

	public ConversorXsl(Object input, TemplateXsl template) {

		this.contexto = new ContextoJAXB(input, input.getClass());
		this.tipoConversao = TipoConversaoXsl.CONVERTER_INSTANCIA_USANDO_TEMPLATENAME;
		this.template = template;
	}

	@Override
	public S converter() {
		switch (this.tipoConversao) {
		case CONVERTER_INSTANCIA_USANDO_TEMPLATENAME:
			return converterInstanciaUsandoTemplateName();
		case CONVERTER_INSTANCIA_FILE_USANDO_TEMPLATENAME:
			return converterInstanciaFileUsandoTemplateName();
		case CONVERTER_INSTANCIA_FILE_USANDO_TEMPLATENAME_FILE:
			return converterInstanciaFileUsandoTemaplateFile();
		case CONVERTER_INSTANCIA_STRINBUFFER_USANDO_TEMPLATENAME_STRING_BUFFER:
			return converterInstanciaStringBufferUsandoTemaplateStringBuffer();
		}
		return null;
	}

	public S converterInstanciaUsandoTemplateName() {

		try {
			SAXTransformerFactory transFact = criarTransformerFactory();
			String input = ConversorXsl.class.getResource(this.template.getValor()).getPath();
			Templates displayTemplate = transFact.newTemplates(new StreamSource(input));

			Marshaller marshaller = this.contexto.getContextosJAXB().createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringBufferOutputStream fluxoSaida = new StringBufferOutputStream();

			Result outputResult = new StreamResult(fluxoSaida);
			TransformerHandler handler = ((SAXTransformerFactory) transFact).newTransformerHandler(displayTemplate);
			handler.setResult(outputResult);
			marshaller.marshal(this.contexto.getInstancia(), handler);
			return (S) fluxoSaida.getBuffer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public S converterInstanciaFileUsandoTemplateName() {

		StringBuffer sb = new StringBuffer();
		try {

			URL urlXsl = this.getClass().getResource(this.template.getValor());
			TransformerFactory factory = TransformerFactory.newInstance();
			StreamSource xslStream = new StreamSource(urlXsl.getPath());
			Transformer transformer = factory.newTransformer(xslStream);
			transformer.setErrorListener(new MyErrorListener());
			StreamSource in = new StreamSource((File) this.contexto.getInstancia());

			StringBufferOutputStream streamBuffer = new StringBufferOutputStream(sb);

			StreamResult out = new StreamResult(streamBuffer);
			transformer.transform(in, out);
			return (S) streamBuffer.getBuffer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private S converterInstanciaFileUsandoTemaplateFile() {

		StringBuilder sbXML;
		try {
			sbXML = converterStringBuilder((File) this.contexto.getInstancia());
			StringBuilder sbXsl = converterStringBuilder(this.inXslFile);
			StringBufferOutputStream outBuffer = new StringBufferOutputStream();

			TransformerFactory factory = TransformerFactory.newInstance();
			StreamSource xslStream = new StreamSource(sbXsl.toString());
			Transformer transformer = factory.newTransformer(xslStream);
			transformer.setErrorListener(new MyErrorListener());
			StreamSource in = new StreamSource(sbXML.toString());
			StreamResult out = new StreamResult(outBuffer);
			transformer.transform(in, out);

			return (S) outBuffer.getBuffer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private S converterInstanciaStringBufferUsandoTemaplateStringBuffer() {

		try {
			StringBuffer sbXML = (StringBuffer) this.contexto.getInstancia();
			StringBuffer sbXsl = this.inXslStrinBuffer;
			StringBufferOutputStream outBuffer = new StringBufferOutputStream();

			TransformerFactory factory = TransformerFactory.newInstance();
			StreamSource xslStream = new StreamSource(sbXsl.toString());
			Transformer transformer = factory.newTransformer(xslStream);
			transformer.setErrorListener(new MyErrorListener());
			StreamSource in = new StreamSource(sbXML.toString());
			StreamResult out = new StreamResult(outBuffer);
			transformer.transform(in, out);

			return (S) outBuffer.getBuffer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private StringBuilder converterStringBuilder(File file) throws IOException {

		FileInputStream fis = new FileInputStream(file);
		StringBuilder sb = new StringBuilder();
		int content;
		while ((content = fis.read()) != -1) {

			sb.append((char) content);
		}

		return sb;

	}

	protected SAXTransformerFactory criarTransformerFactoryPadrao() {

		return (SAXTransformerFactory) TransformerFactory.newInstance();

	}

	protected SAXTransformerFactory criarTransformerFactory() {

		return (SAXTransformerFactory) TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);

	}
}
