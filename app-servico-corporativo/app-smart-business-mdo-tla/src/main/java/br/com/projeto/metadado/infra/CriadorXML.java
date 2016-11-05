package br.com.projeto.metadado.infra;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;

import br.com.projeto.metadado.bean.Componente;
import br.com.projeto.metadado.bean.MetaDado;
import br.com.projeto.metadado.bean.MetadadoMock;
import br.com.projeto.metadado.bean.Propriedade;
import br.com.projeto.metadado.infra.comum.StringBufferOutputStream;

public class CriadorXML {

	public static Marshaller getMarshaller(JAXBContext contextosJAXB)
			throws JAXBException {

		return contextosJAXB.createMarshaller();
	}
	
	public static Unmarshaller getUnmarshaller(JAXBContext contextosJAXB)
			throws JAXBException {

		return contextosJAXB.createUnmarshaller();
	}

	public static StringBufferOutputStream criar(JAXBContext contextosJAXB,
			Object objeto) throws JAXBException, FileNotFoundException {

		StringBufferOutputStream fluxoSaida = new StringBufferOutputStream();
		contextosJAXB.createMarshaller().marshal(objeto, fluxoSaida);

		return fluxoSaida;
	}
	
	public static Object transformarXmlEmObjeto(JAXBContext contextosJAXB,String xml){
		
		try {
			
			return getUnmarshaller(contextosJAXB).unmarshal(new StreamSource( new StringReader(xml.trim()) ) );
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean validar(Object objeto) {

		return VerificadorAnotacao.validar(objeto, XmlRootElement.class);

	}

	public static void main(String[] args) {

	
		// List<Propriedade> propriedades = new ArrayList<Propriedade>();
		//
		// Propriedade p1 = new Propriedade("nomeValorLabel", "teste");
		// Propriedade p2 = new Propriedade("nomeValorInput", "teste");
		// propriedades.add(p1);
		// propriedades.add(p2);
		//
		// Componente c = new Componente("entradadados",
		// "http://url.projeto/componentes", propriedades);
		// List<Componente> componentes = new ArrayList<Componente>();
		// componentes.add(c);
		//
		// MetaDado metadado = new MetaDado(componentes);
		//
		
		MetaDado menu = MetadadoMock.criarMetadadoTelaPrincipal();
		MetaDado entrada = MetadadoMock.criarMetadadoTelaIncialPagamentoTitulo();
		MetaDado confirmacao = MetadadoMock.criarMetadadoTelaConfirmacaoPagamentoTitulo();
		MetaDado comprovante = MetadadoMock.criarMetadadoTelaComprovantePagamentoTitulo();
		
		 try {
			 JAXBContext contextosJAXB=null;
			 StringBufferOutputStream saida =null;
		 CriadorXML criador = new CriadorXML();
		 
		 contextosJAXB = JAXBContext.newInstance(menu
					.getClass());
		  saida =criador.criar(contextosJAXB, menu);
			
			
		 System.out.println("xml criado");
		 System.out.println(saida.getBuffer().toString());
		 
		 contextosJAXB = JAXBContext.newInstance(entrada
					.getClass());
		  saida =criador.criar(contextosJAXB, entrada);
			
			
		 System.out.println("xml criado");
		 System.out.println(saida.getBuffer().toString());
		 
		 contextosJAXB = JAXBContext.newInstance(entrada
					.getClass());
		saida=criador.criar(contextosJAXB, confirmacao);
			
		 System.out.println("xml criado");
		 System.out.println(saida.getBuffer().toString());
		 	
		 contextosJAXB = JAXBContext.newInstance(entrada
					.getClass());
		saida=criador.criar(contextosJAXB, comprovante);
		 
		 System.out.println("xml criado");
		 System.out.println(saida.getBuffer().toString());
		 
//		 criador.gravarArquivo(metadado,
//		 "src/com/br/projeto/metadado/infra/", metadado.getClass()
//		 .getSimpleName(), ".xml");
		 } catch (JAXBException | IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
	}
}
