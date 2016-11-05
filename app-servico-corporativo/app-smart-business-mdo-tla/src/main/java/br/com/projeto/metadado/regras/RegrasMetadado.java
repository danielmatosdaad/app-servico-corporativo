package br.com.projeto.metadado.regras;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;

import br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO;
import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.app.smart.business.funcionalidade.dto.FuncionalidadeDTO;
import br.com.app.smart.business.funcionalidade.dto.MetaDadoDTO;
import br.com.projeto.metadado.bean.Componente;
import br.com.projeto.metadado.bean.MetaDado;
import br.com.projeto.metadado.bean.Propriedade;
import br.com.projeto.metadado.infra.ProcessadorXml;
import br.com.projeto.metadado.infra.comum.FactoryIdentificador;
import br.com.projeto.metadado.infra.comum.Identificador;
import br.com.projeto.metadado.infra.comum.IdentificadorWrapper;
import br.com.projeto.metadado.infra.comum.MetadadoUI;
import br.com.projeto.metadado.infra.comum.PadraoIdentificador;
import br.com.projeto.metadado.infra.comum.StringBufferOutputStream;
import br.com.projeto.metadado.infra.comum.TipoProcessamento;
import br.com.projeto.metadado.infra.comum.TipoTransformacao;

@Named
public class RegrasMetadado implements IRegrasMetaDado {

	@Inject
	private ProcessadorXml processadorXML;

	@Inject
	private IServicoRemoteDAO<FuncionalidadeDTO> funcionalidadeService;

	@Inject
	private IServicoRemoteDAO<MetaDadoDTO> metaDadoService;

	private StringBufferOutputStream transformarMetadado(MetaDado metadado)
			throws TransformerException, JAXBException, FileNotFoundException {

		StringBufferOutputStream stream = this.processadorXML.processar(TipoProcessamento.TRASFORMAR_XML_OBJETO,
				metadado);
		System.out.println("Stream gerado: " + stream.getBuffer().toString());
		return stream;
	}

	public List<IdentificadorWrapper> obterIdComponente(int numeroTela, int funcionalidade,
			PadraoIdentificador identificador, MetaDado metadado) {

		FactoryIdentificador fabricaIdentificador = identificador.getFabricaIdentificador();

		List<Componente> componenetes = metadado.getConteudo().getComponentes();
		List<IdentificadorWrapper> listaId = new ArrayList<IdentificadorWrapper>();

		for (Componente componente : componenetes) {

			List<Propriedade> propriedades = componente.getPropriedades();
			for (Propriedade propriedade : propriedades) {

				if (propriedade.getNome().contains(fabricaIdentificador.getIdentificadorPadrao().getValor())) {

					System.out.println("Valor do identificador: " + propriedade.getValor());
					Identificador id = fabricaIdentificador.getInstancia(fabricaIdentificador, propriedade.getValor());
					IdentificadorWrapper wrapper = new IdentificadorWrapper<Identificador>(id);

					if (id != null) {
						listaId.add(wrapper);
					}
				}

			}

		}

		return listaId;
	}

	@Override
	public MetadadoUI funcionalidadeMetadado(int numeroTela, int funcionalidade, MetaDado metadado) {
		// TODO Auto-generated method stub
		List<IdentificadorWrapper> listaIdentificadores = obterIdComponente(numeroTela, funcionalidade,
				PadraoIdentificador.PADRAO_IDENTIFICADOR_NEGOCIAL, metadado);

		List<IdentificadorWrapper> listaIdentificadoresBean = obterIdComponente(numeroTela, funcionalidade,
				PadraoIdentificador.PADRAO_IDENTIFICADOR_BEAN, metadado);

		MetadadoUI metadadoUI = new MetadadoUI();
		metadadoUI.setIdentificadoreNegocialMetadados(listaIdentificadores);
		metadadoUI.setIdentificadoreBeanMetadados(listaIdentificadoresBean);
		try {
			metadadoUI.setMetadado(transformarMetadado(metadado));
		} catch (FileNotFoundException | TransformerException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return metadadoUI;
	}

	@Override
	public MetaDado buscarMetadado(int numeroTela, int funcionalidade)
			throws InfraEstruturaException, NegocioException {
		// TODO Auto-generated method stub

		FuncionalidadeDTO funcionalidadeDTO = this.funcionalidadeService.bustarPorID(Long.valueOf(funcionalidade));
		String metadado = null;
		MetaDado metadadoProcessado = null;

		for (MetaDadoDTO mdo : funcionalidadeDTO.getMetadados()) {

			if (mdo.getNumeroTela() == numeroTela) {

				metadado = mdo.getXml();

				if (metadado != null) {

					return (MetaDado) this.processadorXML.transformar(TipoTransformacao.TRASFORMAR_XML_OBJETO,
							metadado);
				}

			}
		}

		return metadadoProcessado;
	}

	@Override
	public MetadadoUI atualizarTela(long idMetaDado) throws InfraEstruturaException, NegocioException {
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
					System.out.println("Tela Atualizada:");
					System.out.println("Tela Atualizada:" + metadadoDTO.getXhtml());
				}
			} catch (FileNotFoundException | TransformerException | JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<MetaDado> transformarFaceletsEmMetadados(List<File> lista) {

		List<MetaDado> metadados = new ArrayList<MetaDado>();

		if (lista != null) {

			for (File xml : lista) {
				try {
					Object obj = this.processadorXML.transformar(MetaDado.class, xml);
					if (obj instanceof MetaDado) {

						MetaDado mdo = (MetaDado) obj;
						mdo.setNomeMetadado(xml.getName());
						metadados.add(mdo);
					}
				} catch (TransformerException e) {
					e.printStackTrace();
				}

			}
		}

		return metadados;
	}

	public StringBuffer transformaParaXml(MetaDado metaDado) {

		if (metaDado == null) {
			StringBuffer sb = new StringBuffer();
			return sb;
		}
		StringBufferOutputStream out = this.processadorXML.processar(TipoProcessamento.CRIAR_XML, metaDado);

		return out.getBuffer();
	}

	public StringBuffer transformaMetaDadoParaFacelet(MetaDado metaDado) {
		if (metaDado == null) {
			StringBuffer sb = new StringBuffer();
			return sb;
		}
		StringBufferOutputStream out = this.processadorXML.processar(TipoProcessamento.TRASFORMAR_XML_OBJETO, metaDado);
		return out.getBuffer();
	}

}
