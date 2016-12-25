package br.com.app.smart.business.processoconfiguracao.interfaces;

import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.app.smart.business.processoconfiguracao.dto.ProcessoConfiguracaoDTO;

public interface IProcessoConfiguracaoRemote {

	public ProcessoConfiguracaoDTO configurarNevegacaoSistema(ProcessoConfiguracaoDTO dto) throws InfraEstruturaException, NegocioException;
}
