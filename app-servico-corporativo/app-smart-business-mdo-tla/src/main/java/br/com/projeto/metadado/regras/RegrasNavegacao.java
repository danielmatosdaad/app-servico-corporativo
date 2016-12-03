package br.com.projeto.metadado.regras;

import javax.inject.Inject;
import javax.inject.Named;
import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.app.smart.business.funcionalidade.dto.MetaDadoDTO;
import br.com.projeto.metadado.bean.MetaDado;
import br.com.projeto.metadado.infra.comum.dto.ObterMetaDadoDTO;
import br.com.projeto.metadado.infra.interfaces.IRegrasNavegacao;
import br.com.projeto.metadado.regras.IRegrasMetaDado;

@Named
public class RegrasNavegacao implements IRegrasNavegacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IRegrasMetaDado regrasMetadados;

	public MetaDadoDTO funcionalidadeMetadado(
			ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException {
		MetaDadoDTO metaDadoDTO = this.regrasMetadados.buscarMetadado(
				obterMetaDadoDTO.getNumeroTela(),
				obterMetaDadoDTO.getNumeroFuncionalidade());
		return metaDadoDTO;
	}

	private MetaDado buscarMetadado(
			ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException {

		MetaDadoDTO metaDadoDTO = this.regrasMetadados.buscarMetadado(
				obterMetaDadoDTO.getNumeroTela(),
				obterMetaDadoDTO.getNumeroFuncionalidade());
		
		return this.regrasMetadados.converterMetaDado(metaDadoDTO);
	}


}
