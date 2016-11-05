package br.com.metadado.componente;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.projeto.metadado.infra.comum.MetadadoUI;
import br.com.projeto.metadado.infra.comum.dto.ObterMetaDadoDTO;
import br.com.projeto.metadado.infra.interfaces.IComponenteMetadado;
import br.com.projeto.metadado.infra.interfaces.IRegrasNavegacao;

@Named
public class ComponenteMetadado implements IComponenteMetadado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IRegrasNavegacao regrasNavegacao;

	@Override
	public MetadadoUI gerar(ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException {
		MetadadoUI metadoUI = regrasNavegacao.funcionalidadeMetadado(obterMetaDadoDTO);

		return metadoUI;
	}

}
