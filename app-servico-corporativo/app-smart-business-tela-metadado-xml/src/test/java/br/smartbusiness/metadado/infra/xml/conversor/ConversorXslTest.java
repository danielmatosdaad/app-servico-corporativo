package br.smartbusiness.metadado.infra.xml.conversor;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.smartbusiness.metadado.conversor.ConversorBean;
import br.smartbusiness.metadado.conversor.ConversorXml;
import br.smartbusiness.metadado.conversor.ConversorXsl;
import br.smartbusiness.metadado.conversor.enums.TemplateXsl;
import br.smartbusiness.metadado.conversor.enums.TipoConversaoXML;
import br.smartbusiness.metadado.uicomponent.bean.Componente;
import br.smartbusiness.metadado.uicomponent.bean.CompositeImp;
import br.smartbusiness.metadado.uicomponent.bean.CompositeImplentationImp;
import br.smartbusiness.metadado.uicomponent.bean.CompositeInterfacesImp;
import br.smartbusiness.metadado.uicomponent.bean.IComposite;
import br.smartbusiness.metadado.uicomponent.bean.ICompositeImplentation;
import br.smartbusiness.metadado.uicomponent.bean.ICompositeInterfaces;
import br.smartbusiness.metadado.uicomponent.bean.MetaDado;

public class ConversorXslTest {

	@Test
	public void converterComponenteParaMetadaoXsl() throws IOException {

		// primeiro carrego o componente botao, sua implementacao e interfaces
		// atraves do composite_all_componente.
		URL url = ConversorXslTest.class.getResource("/arquivos-xml-objetos/botao.xhtml");
		String path = url.getPath();
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		StringBuilder sb = new StringBuilder();
		int content;
		while ((content = fis.read()) != -1) {

			sb.append((char) content);
		}

		ConversorXsl<StringBuffer> conversorXslAllComponente = new ConversorXsl<StringBuffer>(file,
				TemplateXsl.COMPOSITE_ALL_COMPONENTE);

		StringBuffer componenteInterfaceImplementacaoSB = conversorXslAllComponente.converter();
		Assert.assertNotNull(componenteInterfaceImplementacaoSB);
		System.out.println(componenteInterfaceImplementacaoSB.toString());

		// depois converto o objeto carregado de componentes (interfaces e
		// implementacao)
		// atraves do xls metadado_ui que transformara em um coponete ui que
		// sera injedado na tela.
		

	ConversorXml<Componente> conversorComponenteXml = new ConversorXml<>(componenteInterfaceImplementacaoSB.toString(), Componente.class, TipoConversaoXML.STRING_INTANCIA);
	Componente componente =	conversorComponenteXml.converter();	
		
	
		
		ICompositeInterfaces interfaces = new CompositeInterfacesImp(componente);
		ICompositeImplentation implementacao = new CompositeImplentationImp(componente);
		IComposite composite = new CompositeImp(interfaces, implementacao);

		List<ICompositeInterfaces> interfacesComposite = new ArrayList<ICompositeInterfaces>();
		interfacesComposite.add(composite.getInterfaces());

		List<MetaDado> metadados = ConversorBean.converterParaMetadado(interfacesComposite);
		for (MetaDado metaDado : metadados) {
			
			
			ConversorXsl<StringBuffer> conversorXslToMetadado = new ConversorXsl<StringBuffer>(metaDado,
					TemplateXsl.METADADO_UI);
			
			StringBuffer xmlMetadado = conversorXslToMetadado.converter();
			Assert.assertNotNull(xmlMetadado);
			System.out.println(xmlMetadado.toString());
		}
		
	}

}
