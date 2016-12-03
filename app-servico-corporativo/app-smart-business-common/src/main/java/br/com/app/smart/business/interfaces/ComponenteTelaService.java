package br.com.app.smart.business.interfaces;

import java.io.File;
import java.util.List;

import br.com.app.smart.business.tela.componete.dto.ComponenteDTO;
import br.com.app.smart.business.tela.componete.dto.ComponenteTelaDTO;
import br.com.app.smart.business.tela.componete.dto.CompositeDTO;
public interface ComponenteTelaService {

	public List<CompositeDTO> converterArquivo(List<File> files);

	public List<ComponenteTelaDTO> converterComposite(List<CompositeDTO> composites);

	public List<StringBuffer> converterComponenteUI(List<ComponenteTelaDTO> metadados);
}
