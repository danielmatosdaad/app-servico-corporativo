package br.com.projeto.metadado.infra.interfaces;


import java.io.Serializable;
import java.util.List;

import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.projeto.metadado.infra.comum.IdentificadorWrapper;
import br.com.projeto.metadado.infra.comum.MetadadoUI;
import br.com.projeto.metadado.infra.comum.dto.MetaDadoComponenteDTO;
import br.com.projeto.metadado.infra.comum.dto.ObterMetaDadoDTO;

public interface IRegrasNavegacao extends Serializable{


	public MetadadoUI funcionalidadeMetadado(ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException;

}
