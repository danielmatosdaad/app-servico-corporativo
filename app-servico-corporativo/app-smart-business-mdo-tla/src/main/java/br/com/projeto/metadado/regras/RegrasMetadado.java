package br.com.projeto.metadado.regras;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO;
import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.app.smart.business.funcionalidade.dto.FuncionalidadeDTO;
import br.com.app.smart.business.funcionalidade.dto.MetaDadoDTO;
import br.com.metadado.conversor.ConversorMetadadoFacelet;
import br.com.projeto.facelet.bean.Facelet;
import br.com.projeto.metadado.bean.Componente;
import br.com.projeto.metadado.bean.Conteudo;
import br.com.projeto.metadado.bean.MetaDado;
import br.com.projeto.metadado.bean.Propriedade;
import br.com.projeto.metadado.infra.ProcessadorXml;
import br.com.projeto.metadado.infra.comum.Identificador;
import br.com.projeto.metadado.infra.comum.PadraoIdentificador;
import br.com.projeto.metadado.infra.comum.StringBufferOutputStream;
import br.com.projeto.metadado.infra.comum.TipoProcessamento;
import br.com.projeto.metadado.infra.comum.TipoTransformacao;

@Named
public class RegrasMetadado implements IRegrasMetaDado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ProcessadorXml processadorXML;

	@Inject
	private IServicoRemoteDAO<FuncionalidadeDTO> funcionalidadeService;

	@Inject
	private IServicoRemoteDAO<MetaDadoDTO> metaDadoService;

	public RegrasMetadado() {
		if (this.processadorXML == null) {
			this.processadorXML = new ProcessadorXml();
		}
	}

	public StringBufferOutputStream transformarMetadado(MetaDado metadado)
			throws TransformerException, JAXBException, FileNotFoundException {

		StringBufferOutputStream stream = this.processadorXML.processar(TipoProcessamento.TRASFORMAR_XML_OBJETO,
				metadado);
		System.out.println("Stream gerado: " + stream.getBuffer().toString());
		return stream;
	}

	@Override
	public String converterMetadado(MetaDado metadado) {

		try {
			StringBufferOutputStream sb = transformarMetadado(metadado);
			return sb.getBuffer().toString();
		} catch (FileNotFoundException | TransformerException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	@Override
	public MetaDadoDTO buscarMetadado(int numeroTela, int funcionalidade)
			throws InfraEstruturaException, NegocioException {

		FuncionalidadeDTO funcionalidadeDTO = this.funcionalidadeService.bustarPorID(Long.valueOf(funcionalidade));
		String metadado = null;
		MetaDado metadadoProcessado = null;

		for (MetaDadoDTO mdo : funcionalidadeDTO.getMetadados()) {

			if (mdo.getNumeroTela() == numeroTela) {

				return mdo;

			}
		}

		return null;
	}

	@Override
	public MetaDadoDTO atualizarTela(long idMetaDado) throws InfraEstruturaException, NegocioException {
		MetaDadoDTO metadadoDTO = metaDadoService.bustarPorID(idMetaDado);

		String metadado = metadadoDTO.getXml();

		if (metadado != null) {

			MetaDado mdo = (MetaDado) this.processadorXML.transformar(TipoTransformacao.TRASFORMAR_XML_OBJETO,
					metadado);

			try {
				StringBufferOutputStream out = transformarMetadado(mdo);
				if (out != null) {
					metadadoDTO.setXhtml(out.getBuffer().toString());
					metadadoDTO = metaDadoService.alterar(metadadoDTO);
					System.out.println("Tela Atualizada:" + metadadoDTO.getXhtml());
				}
			} catch (FileNotFoundException | TransformerException | JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return metadadoDTO;
	}

	@Override
	public List<Facelet> transformarEmFacelets(List<File> lista) {

		List<Facelet> facelets = new ArrayList<Facelet>();

		if (lista != null) {

			for (File xml : lista) {
				try {
					Object obj = this.processadorXML.transformar(Facelet.class, xml);
					if (obj instanceof Facelet) {

						Facelet facelet = (Facelet) obj;
						facelet.setNomeMetadado(xml.getName());
						facelets.add(facelet);
					}
				} catch (TransformerException e) {
					e.printStackTrace();
				}

			}
		}

		return facelets;
	}

	@Override
	public StringBuffer transformaParaXml(MetaDado metaDado) {

		if (metaDado == null) {
			StringBuffer sb = new StringBuffer();
			return sb;
		}
		StringBufferOutputStream out = this.processadorXML.processar(TipoProcessamento.CRIAR_XML, metaDado);

		return out.getBuffer();
	}

	@Override
	public StringBuffer transformaMetaDadoParaFacelet(MetaDado metaDado) {
		if (metaDado == null) {
			StringBuffer sb = new StringBuffer();
			return sb;
		}
		StringBufferOutputStream out = this.processadorXML.processar(TipoProcessamento.TRASFORMAR_XML_OBJETO, metaDado);
		return out.getBuffer();
	}

	@Override
	public List<String> converterFaceletMetadadoUI(List<Facelet> lista)
			throws TransformerConfigurationException, TransformerException {

		List<String> listaMetadadoUI = new ArrayList<String>();

		for (Facelet facelet : lista) {

			String metaDadoUI = converterFaceletMetadadoUI(facelet);
			listaMetadadoUI.add(metaDadoUI);
		}

		return listaMetadadoUI;
	}

	public String converterFaceletMetadadoUI(Facelet facelet)
			throws TransformerConfigurationException, TransformerException {

		MetaDado metaDado = ConversorMetadadoFacelet.converter(facelet);
		String metaDadoUI = converterMetadado(metaDado);
		return metaDadoUI;
	}

	public MetaDado converterFaceletMetaDado(List<Facelet> faceletes) {
		StringBuffer sb = new StringBuffer();

		ArrayList<Componente> componentes = new ArrayList<Componente>();
		Conteudo conteudo = new Conteudo(componentes);
		conteudo.setNomeConteudo("html");
		MetaDado metadado = new MetaDado(conteudo);

		try {
			for (Facelet facelet : faceletes) {
				MetaDado mdo = ConversorMetadadoFacelet.converter(facelet);
				metadado.getConteudo().getComponentes().addAll(mdo.getConteudo().getComponentes());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Resultado: " + sb.toString());
		return metadado;
	}

	@Override
	public MetaDado converterMetaDado(MetaDadoDTO metaDadoDTO) {
		
		if (metaDadoDTO == null || (metaDadoDTO.getXml() == null || metaDadoDTO.getXml().isEmpty())) {

			return null;
		}
		return (MetaDado) this.processadorXML.transformar(TipoTransformacao.TRASFORMAR_XML_OBJETO,
				metaDadoDTO.getXml());
	}

}
