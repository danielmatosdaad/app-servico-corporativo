package br.com.app.smart.business.interfaces;

import java.io.File;
import java.util.List;

import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.processoconfiguracao.dto.ResultadoConvercaoComponenteUI;
import br.com.app.smart.business.tela.componente.dto.ComponenteTelaDTO;
import br.com.app.smart.business.tela.componente.dto.CompositeDTO;
import br.com.app.smart.business.tela.componente.dto.CompositeInterfaceDTO;
public interface IComponenteTelaService {

	public List<CompositeDTO> converterArquivo(List<File> files);

	public List<ComponenteTelaDTO> converterComposite(List<CompositeDTO> composites);

	public ResultadoConvercaoComponenteUI converterComponenteUI(List<ComponenteTelaDTO> metadados);

	public List<ComponenteTelaDTO> converterCompositeInterfaces(List<CompositeInterfaceDTO> compositeInterfaceDTOs)
			throws InfraEstruturaException;
}
