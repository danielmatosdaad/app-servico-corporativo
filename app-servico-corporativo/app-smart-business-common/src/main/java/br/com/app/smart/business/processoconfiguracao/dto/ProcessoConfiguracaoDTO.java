package br.com.app.smart.business.processoconfiguracao.dto;

import java.io.Serializable;
import java.util.List;

import br.com.app.smart.business.funcionalidade.dto.FuncionalidadeDTO;
import br.com.app.smart.business.funcionalidade.dto.GrupoFuncionalidadeDTO;
import br.com.app.smart.business.funcionalidade.dto.IdentificadorDTO;
import br.com.app.smart.business.funcionalidade.dto.MetaDadoDTO;
import br.com.app.smart.business.funcionalidade.dto.PerfilDTO;

public class ProcessoConfiguracaoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FuncionalidadeDTO funcionalidadeDTO;
	private GrupoFuncionalidadeDTO grupoFuncionalidadeDTO;
	private PerfilDTO perfilDTO;
	private MetaDadoDTO metadadoDTO;
	private List<IdentificadorDTO> identificadoresDTO;

	public FuncionalidadeDTO getFuncionalidadeDTO() {
		return funcionalidadeDTO;
	}

	public void setFuncionalidadeDTO(FuncionalidadeDTO funcionalidadeDTO) {
		this.funcionalidadeDTO = funcionalidadeDTO;
	}

	public GrupoFuncionalidadeDTO getGrupoFuncionalidadeDTO() {
		return grupoFuncionalidadeDTO;
	}

	public void setGrupoFuncionalidadeDTO(GrupoFuncionalidadeDTO grupoFuncionalidadeDTO) {
		this.grupoFuncionalidadeDTO = grupoFuncionalidadeDTO;
	}

	public PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	public void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}

	public MetaDadoDTO getMetadadoDTO() {
		return metadadoDTO;
	}

	public void setMetadadoDTO(MetaDadoDTO metadadoDTO) {
		this.metadadoDTO = metadadoDTO;
	}

	public List<IdentificadorDTO> getIdentificadoresDTO() {
		return identificadoresDTO;
	}

	public void setIdentificadoresDTO(List<IdentificadorDTO> identificadoresDTO) {
		this.identificadoresDTO = identificadoresDTO;
	}

}
