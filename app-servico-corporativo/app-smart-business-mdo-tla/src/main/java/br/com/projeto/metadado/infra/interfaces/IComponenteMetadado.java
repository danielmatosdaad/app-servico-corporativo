package br.com.projeto.metadado.infra.interfaces;

import java.io.Serializable;

import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.projeto.metadado.infra.comum.MetadadoUI;
import br.com.projeto.metadado.infra.comum.dto.ObterMetaDadoDTO;

public interface IComponenteMetadado extends Serializable {

	public MetadadoUI gerar(ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException;
}
