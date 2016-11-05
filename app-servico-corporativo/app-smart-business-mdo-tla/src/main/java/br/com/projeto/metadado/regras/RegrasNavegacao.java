package br.com.projeto.metadado.regras;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.projeto.metadado.bean.MetaDado;
import br.com.projeto.metadado.infra.comum.MetadadoUI;
import br.com.projeto.metadado.infra.comum.dto.ObterMetaDadoDTO;
import br.com.projeto.metadado.infra.interfaces.IRegrasNavegacao;
import br.com.projeto.metadado.regras.IRegrasMetaDado;

@Named
public class RegrasNavegacao implements IRegrasNavegacao {

	@Inject
	private IRegrasMetaDado regrasMetadados;

	public MetadadoUI funcionalidadeMetadado(
			ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException {
		MetaDado mdo = buscarMetadado(obterMetaDadoDTO);
		MetadadoUI metadadoUi = this.regrasMetadados.funcionalidadeMetadado(
				obterMetaDadoDTO.getNumeroTela(),
				obterMetaDadoDTO.getNumeroFuncionalidade(), mdo);
		return metadadoUi;
	}

	private MetaDado buscarMetadado(
			ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException {

		return this.regrasMetadados.buscarMetadado(
				obterMetaDadoDTO.getNumeroTela(),
				obterMetaDadoDTO.getNumeroFuncionalidade());
	}

}
