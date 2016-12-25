package br.com.app.smart.business.funcionalidade.interfaces;

import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.app.smart.business.funcionalidade.dto.FuncionalidadeDTO;

public interface IFuncionalidadeDAO {

	public FuncionalidadeDTO adicionarFuncionalidadeSemRelacionamento(FuncionalidadeDTO funcionalidadeDTO) throws InfraEstruturaException,NegocioException;
}
