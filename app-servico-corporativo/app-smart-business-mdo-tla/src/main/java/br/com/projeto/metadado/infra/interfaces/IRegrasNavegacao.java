package br.com.projeto.metadado.infra.interfaces;


import java.io.Serializable;

import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.app.smart.business.funcionalidade.dto.MetaDadoDTO;
import br.com.projeto.metadado.infra.comum.dto.ObterMetaDadoDTO;

public interface IRegrasNavegacao extends Serializable{

	public MetaDadoDTO funcionalidadeMetadado(ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException;

}
