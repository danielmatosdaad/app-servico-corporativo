package br.smartbusiness.metadado.infra.xml.conversor;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import br.smartbusiness.metadado.conversor.ConversorXml;
import br.smartbusiness.metadado.conversor.enums.TipoConversaoXML;
import br.smartbusiness.metadado.uicomponent.bean.Componente;
import br.smartbusiness.metadado.uicomponent.bean.MetaDado;
import br.smartbusiness.metadado.util.FileUtil;

public class ConversorXmlTest {

	@Test
	public void testTransformarStreamMetadadoXmlEmObjeto() {
		URL url = ConversorXmlTest.class.getResource("/arquivos-xml-objetos/metadado.xml");
		String path = url.getPath();
		InputStream inXmlMdo = FileUtil.lerArquivo(path);
		ConversorXml<MetaDado> conversorXml = new ConversorXml<MetaDado>(inXmlMdo,MetaDado.class,
				TipoConversaoXML.INPUTSTREAM_STRING_INTANCIA);
		MetaDado mdo = conversorXml.converter();
		Assert.assertNotNull(mdo);
	}
	
	@Test
	public void testTransformarStreamComponenteXmlEmObjeto() {
		URL url = ConversorXmlTest.class.getResource("/arquivos-xml-objetos/componente.xml");
		String path = url.getPath();
		InputStream inXmlMdo = FileUtil.lerArquivo(path);
		ConversorXml<Componente> conversorXml = new ConversorXml<Componente>(inXmlMdo,Componente.class,
				TipoConversaoXML.INPUTSTREAM_STRING_INTANCIA);
		Componente componente = conversorXml.converter();
		Assert.assertNotNull(componente);
	}
	
	@Test
	public void testTransformarStreamComponenteXmlEmStringBuffer() {
		URL url = ConversorXmlTest.class.getResource("/arquivos-xml-objetos/componente.xml");
		String path = url.getPath();
		InputStream inXmlMdo = FileUtil.lerArquivo(path);
		ConversorXml<Componente> conversorXml = new ConversorXml<Componente>(inXmlMdo,Componente.class,
				TipoConversaoXML.INPUTSTREAM_STRING_INTANCIA);
		Componente componente = conversorXml.converter();
		ConversorXml<StringBuffer> conversorStreamXml = new ConversorXml<StringBuffer>(componente,Componente.class,
				TipoConversaoXML.INPUTSTREAM_STRING_BUFFER);
		StringBuffer sb = conversorStreamXml.converter();
		Assert.assertNotNull(sb);
		Assert.assertNotNull(sb.toString());
	}
	
	@Test
	public void testTransformarComponenteStringXml() {
		URL url = ConversorXmlTest.class.getResource("/arquivos-xml-objetos/componente.xml");
		String path = url.getPath();
		InputStream inXmlMdo = FileUtil.lerArquivo(path);
		ConversorXml<Componente> conversorXml = new ConversorXml<Componente>(inXmlMdo,Componente.class,
				TipoConversaoXML.INPUTSTREAM_STRING_INTANCIA);
		Componente componente = conversorXml.converter();
		ConversorXml<StringBuffer> conversorStreamXml = new ConversorXml<StringBuffer>(componente,Componente.class,
				TipoConversaoXML.INPUTSTREAM_STRING_BUFFER);
		StringBuffer sb = conversorStreamXml.converter();
		Assert.assertNotNull(sb);
		Assert.assertNotNull(sb.toString());
		
		ConversorXml<Componente> conversorStringXml = new ConversorXml<Componente>(sb.toString(),Componente.class,
				TipoConversaoXML.STRING_INTANCIA);
		Componente s = conversorStringXml.converter();
		Assert.assertNotNull(s);
	}

}
