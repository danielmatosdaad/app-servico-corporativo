package br.com.projeto.metadado.infra;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import br.com.projeto.metadado.infra.comum.StringBufferOutputStream;
import br.com.projeto.metadado.xsl.MetadadoXSL;

public class CriadorMetaDadoFaceletsXSTL {

	private static final String TEMPLATE_XSL = "metadado.xslt";
	private static final String TRANSAFORMER_SAXON = "net.sf.saxon.TransformerFactoryImpl";
	private static Templates templateXSL;
	private static TransformerFactory factoryTransformer;

	static {
		System.setProperty("javax.xml.transform.TransformerFactory",
				"net.sf.saxon.TransformerFactoryImpl");
		factoryTransformer = carregarFactory();
		templateXSL = carregarTemplate();

		System.out.println("Servicos Carregados");

	}

	static StringBufferOutputStream transformarXmlBaseadoEmXsl(
			JAXBContext contextosJAXB, Object objeto)
			throws FileNotFoundException, TransformerConfigurationException,
			JAXBException {

		Marshaller marshaller = contextosJAXB.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		StringBuffer sb = new StringBuffer();
		StringBufferOutputStream streamBuffer = new StringBufferOutputStream(sb);
		Result outputResult = new StreamResult(streamBuffer);

		TransformerHandler handler = ((SAXTransformerFactory) factoryTransformer)
				.newTransformerHandler(templateXSL);
		handler.setResult(outputResult);
		marshaller.marshal(objeto, handler);
		return streamBuffer;
	}

	private static TransformerFactory carregarFactory() {

		System.out.println("Carregando factory xsl");
		return TransformerFactory.newInstance(TRANSAFORMER_SAXON, null);
	}

	private static Templates carregarTemplate() {

		System.out.println("Carregando Template xsl");

		try {

			StreamSource ss = new StreamSource(MetadadoXSL.class.getResource(
					TEMPLATE_XSL).openStream());

			return factoryTransformer.newTemplates(ss);

		} catch (IOException | TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	void validar() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args)
			throws TransformerConfigurationException, JAXBException,
			IOException {

		// MetaDadoServico mds = new MetaDadoServico(
		// AbstractProcessadorXml.criarMetadado());
		// mds.carregarTemplate();
		// mds.transformarXmlBaseadoEmXsl();
	}

}
