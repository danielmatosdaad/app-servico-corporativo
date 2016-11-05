package br.com.projeto.metadado.infra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Result;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import br.com.projeto.metadado.bean.MetaDado;
import br.com.projeto.metadado.infra.comum.StringBufferOutputStream;

class TransformadorXSLT {

	public void transformarParaArquivo(Object objeto) throws JAXBException,
			TransformerException, IOException {

		// CriadorXSD criadorXSD = new CriadorXSD();
		// criadorXSD.criar(objeto);
		// System.out.println("criado xd");
		// TransformerFactory tf = TransformerFactory.newInstance();
		// StreamSource xslt = new StreamSource(
		// "src/com/br/projeto/metadado/infra/schema.xsl");
		// JAXBContext jc = JAXBContext.newInstance(Library.class);
		// CriadorXML c = new CriadorXML();
		//
		// Marshaller m = c.criar(
		// objeto,
		// "src/com/br/projeto/metadado/infra/".concat(objeto.getClass()
		// .getSimpleName().concat(".xml")));
		// JAXBSource source = new JAXBSource(m, objeto);
		// Transformer transformer = tf.newTransformer(xslt);
		// StreamResult result = new StreamResult(new FileOutputStream(
		// "src/com/br/projeto/metadado/infra/".concat(objeto.getClass()
		// .getSimpleName().concat(".html"))));
		//
		// transformer.transform(source, result);
	}

	public OutputStream transformar(MetaDado metadado) throws IOException,
			JAXBException, TransformerException {

		SAXTransformerFactory transFact = criarTransformerFactory();

		String uriXslt = TransformadorXSLT.class.getResource("metadado.xslt")
				.getPath();
		System.out.println(uriXslt);
		FileInputStream fis = new FileInputStream(uriXslt);
		InputStream xsl = TransformadorXSLT.class.getResource("metadado.xslt")
				.openStream();
		String uriXhtml = TransformadorXSLT.class.getResource("").getPath();
		String uriCompletaXhtml = uriXhtml.concat(metadado.getClass()
				.getSimpleName().concat(".xhtml"));
		TransformerFactory tf = TransformerFactory.newInstance();

		FileInputStream fileInputStream = new FileInputStream(
				"src/br/com/projeto/metadado/infra/metadado.xslt");
		FileOutputStream outputStream = new FileOutputStream(uriCompletaXhtml);
		StreamSource xslt = new StreamSource(fileInputStream);
		Transformer transformer = tf.newTransformer(xslt);

		// Source
		JAXBContext jc = JAXBContext.newInstance(MetaDado.class);
		JAXBSource source = new JAXBSource(jc, metadado);

		// Result
		StreamResult result = new StreamResult(outputStream);

		// Transform
		transformer.transform(source, result);
		return outputStream;

	}

	public static StringBufferOutputStream transformar(JAXBContext contextosJAXB,
			Object objeto) throws JAXBException, IOException {
		try {

			SAXTransformerFactory transFact = criarTransformerFactory();

			String input = TransformadorXSLT.class.getResource("metadado.xslt")
					.getPath();
			Templates displayTemplate = transFact
					.newTemplates(new StreamSource(input));

			Marshaller marshaller = contextosJAXB.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringBufferOutputStream fluxoSaida = new StringBufferOutputStream();

			Result outputResult = new StreamResult(fluxoSaida);
			TransformerHandler handler = ((SAXTransformerFactory) transFact)
					.newTransformerHandler(displayTemplate);
			handler.setResult(outputResult);
			marshaller.marshal(objeto, handler);
			return fluxoSaida;
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();

		}

		return null;
	}

	public SAXTransformerFactory criarTransformerFactoryPadrao() {

		return (SAXTransformerFactory) TransformerFactory.newInstance();

	}

	public static SAXTransformerFactory criarTransformerFactory() {

		return (SAXTransformerFactory) TransformerFactory.newInstance(
				"net.sf.saxon.TransformerFactoryImpl", null);

	}

	public static void criarMetadadoXSTL() throws IOException {

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
		// TransformadorXSLT txslt = null;
		// try {
		// txslt = new TransformadorXSLT(metadado);
		// } catch (TransformerConfigurationException | JAXBException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// try {
		// try {
		// txslt.gravarArquivo(metadado,
		// "src/com/br/projeto/metadado/infra/", metadado
		// .getClass().getSimpleName(), ".xhtml");
		// System.out.println("Transformado");
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// } catch (JAXBException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	public static void main(String... args) throws IOException {

		// Book book1 = new Book();
		// book1.setAuthor("Daniel");
		// book1.setTitle("livro");
		//
		// Book book2 = new Book();
		// book2.setAuthor("alessandra");
		// book2.setTitle("livro 2");
		//
		// Library catalog = new Library();
		// catalog.getBooks().add(book1);
		// catalog.getBooks().add(book2);
		// //
		// TransformadorXSLT txslt = null;
		// try {
		// txslt = new TransformadorXSLT(criarMetadado());
		// } catch (TransformerConfigurationException | JAXBException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// try {
		// try {
		// txslt.gravarArquivo(criarMetadado(), MetaDadoXHTML.class
		// .getResource("").getPath().concat("/"), criarMetadado()
		// .getClass().getSimpleName(), ".xhtml");
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("Transformado");
		// } catch (JAXBException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

}
