package br.com.app.smart.business.tela.componente.interfaces;

import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.app.smart.business.funcionalidade.dto.MetaDadoDTO;

public interface IMetaDadoUtilDAO {

	MetaDadoDTO buscarMetaDadoFuncionalidade(int idFuncionalidade, int numeroTela)
			throws InfraEstruturaException, NegocioException;
	

}
