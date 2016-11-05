package br.com.app.smart.business.funcionalidade.dto;

import java.io.Serializable;
import java.util.List;

import br.com.app.smart.business.dto.DTO;

public class GrupoFuncionalidadeDTO implements Comparable<GrupoFuncionalidadeDTO>, DTO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nomeGrupoFuncionalidade;

	private String descricao;

	private List<FuncionalidadeDTO> funcionalidades;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeGrupoFuncionalidade() {
		return nomeGrupoFuncionalidade;
	}

	public void setNomeGrupoFuncionalidade(String nomeGrupoFuncionalidade) {
		this.nomeGrupoFuncionalidade = nomeGrupoFuncionalidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<FuncionalidadeDTO> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<FuncionalidadeDTO> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GrupoFuncionalidadeDTO)) {

			return false;
		}

		GrupoFuncionalidadeDTO dto = (GrupoFuncionalidadeDTO) obj;

		if (this.id == null) {
			return false;
		}

		if (dto.id != this.id) {

			return false;
		}

		return true;
	}

	public int compareTo(GrupoFuncionalidadeDTO o) {

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
