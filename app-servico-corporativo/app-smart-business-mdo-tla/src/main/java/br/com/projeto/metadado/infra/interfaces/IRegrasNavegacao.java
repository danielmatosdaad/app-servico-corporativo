package br.com.projeto.metadado.infra.interfaces;


import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.projeto.metadado.infra.comum.MetadadoUI;
import br.com.projeto.metadado.infra.comum.dto.ObterMetaDadoDTO;

public interface IRegrasNavegacao {


	public MetadadoUI funcionalidadeMetadado(ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException;
}
