package br.com.projeto.metadado.infra;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;

import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;

import br.com.projeto.metadado.bean.MetaDado;
import br.com.projeto.metadado.infra.comum.StringBufferOutputStream;
import br.com.projeto.metadado.infra.comum.TipoProcessamento;
import br.com.projeto.metadado.infra.comum.TipoTransformacao;

@Named
public class ProcessadorXml implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StringBufferOutputStream processar(TipoProcessamento tipoProcessamento, Object objeto) {
		try {

			JAXBContext contextosJAXB = JAXBContext.newInstance(objeto.getClass());

			switch (tipoProcessamento) {
			case CRIAR_XML:

				return CriadorXML.criar(contextosJAXB, objeto);
			case CRIAR_XSD:

				return CriadorXSD.criar(contextosJAXB, objeto);
			case CRIAR_XSL:

				break;
			case TRASFORMAR_XML_OBJETO:
				return CriadorMetaDadoFaceletsXSTL.transformarXmlBaseadoEmXsl(contextosJAXB, objeto);

			default:
				break;
			}
		} catch (JAXBException | IOException | TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Object transformar(TipoTransformacao tipoTransformacao, String objeto) {

		try {

			JAXBContext contextosJAXB = JAXBContext.newInstance(MetaDado.class);

			switch (tipoTransformacao) {

			case TRASFORMAR_XML_OBJETO:
				return CriadorXML.transformarXmlEmObjeto(contextosJAXB, objeto);

			default:
				break;
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Object transformar(Class clazz, File xml) throws TransformerConfigurationException, TransformerException {

		try {

			JAXBContext contextosJAXB = JAXBContext.newInstance(clazz);

			StringBuffer out = TransformFaceletsMetaDadoXSTL.transform(xml);
			System.out.println(out.toString());
			Object o = CriadorXML.getUnmarshaller(contextosJAXB)
					.unmarshal(new StreamSource(new StringReader(out.toString().trim())));
			return o;
		} catch (

		JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Object transformar(TipoTransformacao tipoTransformacao, Class clazz, Object objeto) {

		try {

			JAXBContext contextosJAXB = JAXBContext.newInstance(clazz);

			switch (tipoTransformacao) {

			case TRASFORMAR_XML_OBJETO:
				return CriadorXML.transformarXmlEmObjeto(contextosJAXB, (String) objeto);

			default:
				break;
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean validarAnotacao(Object objeto) {

		return true;
	}

}
