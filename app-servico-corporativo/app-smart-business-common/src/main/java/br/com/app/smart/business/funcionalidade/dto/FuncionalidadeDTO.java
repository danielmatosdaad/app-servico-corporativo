package br.com.app.smart.business.funcionalidade.dto;

import java.io.Serializable;
import java.util.List;

import br.com.app.smart.business.dto.DTO;

public class FuncionalidadeDTO implements Comparable<FuncionalidadeDTO>, DTO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nomeFuncionalidade;

	private String descricao;

	private PerfilDTO perfil;

	private GrupoFuncionalidadeDTO grupoFuncionalidade;

	public List<MetaDadoDTO> metadados;

	private List<FuncionalidadeDTO> funcionalidadeFilhos;

	private FuncionalidadeDTO funcionalidadePai;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFuncionalidade() {
		return nomeFuncionalidade;
	}

	public void setNomeFuncionalidade(String nomeFuncionalidade) {
		this.nomeFuncionalidade = nomeFuncionalidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public GrupoFuncionalidadeDTO getGrupoFuncionalidade() {
		return grupoFuncionalidade;
	}

	public void setGrupoFuncionalidade(GrupoFuncionalidadeDTO grupoFuncionalidade) {
		this.grupoFuncionalidade = grupoFuncionalidade;
	}

	public List<MetaDadoDTO> getMetadados() {
		return metadados;
	}

	public void setMetadados(List<MetaDadoDTO> metadados) {
		this.metadados = metadados;
	}

	public List<FuncionalidadeDTO> getFuncionalidadeFilhos() {
		return funcionalidadeFilhos;
	}

	public void setFuncionalidadeFilhos(List<FuncionalidadeDTO> funcionalidadeFilhos) {
		this.funcionalidadeFilhos = funcionalidadeFilhos;
	}

	public FuncionalidadeDTO getFuncionalidadePai() {
		return funcionalidadePai;
	}

	public void setFuncionalidadePai(FuncionalidadeDTO funcionalidadePai) {
		this.funcionalidadePai = funcionalidadePai;
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		if (!(obj instanceof FuncionalidadeDTO)) {

			return false;
		}

		FuncionalidadeDTO dto = (FuncionalidadeDTO) obj;

		if (this.id == null) {
			return false;
		}

		if (dto.id != this.id) {

			return false;
		}

		return true;
	}

	public int compareTo(FuncionalidadeDTO o) {

		if (this.id == null || o.id == null) {

			return -1;
		}
		if (o.id == this.id) {
			return 0;
		} else if (o.id > this.id) {
			return 1;
		} else {
			return -1;
		}
	}

}
