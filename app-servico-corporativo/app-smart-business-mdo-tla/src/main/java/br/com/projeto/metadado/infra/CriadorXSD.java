package br.com.projeto.metadado.infra;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.annotation.XmlType;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import br.com.projeto.metadado.infra.comum.StringBufferOutputStream;

class CriadorXSD {

	public static StringBufferOutputStream criar(JAXBContext contextosJAXB,
			Object objeto) throws JAXBException, IOException {

		final StringBufferOutputStream fluxoSaida = new StringBufferOutputStream();
		contextosJAXB.generateSchema(new SchemaOutputResolver() {

			@Override
			public Result createOutput(String namespaceUri,
					String suggestedFileName) throws IOException {
				StreamResult result = new StreamResult(fluxoSaida);
				result.setSystemId(StringBufferOutputStream.class.getSimpleName().toString());

				return result;
			}
		});

		return fluxoSaida;
	}

	public static boolean validarAnotacao(Object objeto) {

		return VerificadorAnotacao.validar(objeto, XmlType.class);
	}

}
