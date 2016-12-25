package br.smartbusiness.metadado.servico.implementacao;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.app.smart.business.processoconfiguracao.dto.ResultadoConvercaoComponenteUI;
import br.com.app.smart.business.tela.componente.dto.ComponenteTelaDTO;
import br.com.app.smart.business.tela.componente.dto.CompositeDTO;
import br.smartbusiness.metadado.infra.xml.conversor.ConversorXslTest;

public class ComponenteTelaServiceImpTest {

	@Test
	public void testConverterArquivoEmCompositeDTO() {

		URL url = ConversorXslTest.class.getResource("/arquivos-xml-objetos/botao.xhtml");
		String path = url.getPath();
		File file = new File(path);
		List<File> componenteEmArquivo = new ArrayList<File>();
		componenteEmArquivo.add(file);
		ComponenteTelaServiceImp servico = new ComponenteTelaServiceImp();
		List<CompositeDTO> composites = servico.converterArquivo(componenteEmArquivo);

		Assert.assertNotNull(composites);
		Assert.assertNotNull(composites.get(0));

	}

	@Test
	public void testConverterCompositeDTOEmComponenteTelaDTO() {

		URL url = ConversorXslTest.class.getResource("/arquivos-xml-objetos/botao.xhtml");
		String path = url.getPath();
		File file = new File(path);
		List<File> componenteEmArquivo = new ArrayList<File>();
		componenteEmArquivo.add(file);
		ComponenteTelaServiceImp servico = new ComponenteTelaServiceImp();
		List<CompositeDTO> composites = servico.converterArquivo(componenteEmArquivo);

		Assert.assertNotNull(composites);
		Assert.assertNotNull(composites.get(0));

		List<ComponenteTelaDTO> componentesTelaDTO = servico.converterComposite(composites);

		Assert.assertNotNull(componentesTelaDTO);
		Assert.assertNotNull(componentesTelaDTO.get(0));

	}

	@Test
	public void testConverterComponenteTelaDTOComponeteUI() {

		URL url = ConversorXslTest.class.getResource("/arquivos-xml-objetos/botao.xhtml");
		String path = url.getPath();
		File file = new File(path);
		List<File> componenteEmArquivo = new ArrayList<File>();
		componenteEmArquivo.add(file);
		ComponenteTelaServiceImp servico = new ComponenteTelaServiceImp();
		List<CompositeDTO> composites = servico.converterArquivo(componenteEmArquivo);

		Assert.assertNotNull(composites);
		Assert.assertNotNull(composites.get(0));

		List<ComponenteTelaDTO> componentesTelaDTO = servico.converterComposite(composites);

		Assert.assertNotNull(componentesTelaDTO);
		Assert.assertNotNull(componentesTelaDTO.get(0));

		ResultadoConvercaoComponenteUI resultado = servico.converterComponenteUI(componentesTelaDTO);

		Assert.assertNotNull(resultado.getComponeteXhtml());
		Assert.assertNotNull(resultado.getComponeteXhtml().get(0));
		System.out.println(resultado.getComponeteXhtml().get(0));
	}

}
