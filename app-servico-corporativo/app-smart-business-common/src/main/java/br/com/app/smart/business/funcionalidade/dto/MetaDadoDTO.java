package br.com.app.smart.business.funcionalidade.dto;

import java.io.Serializable;
import java.util.List;

import br.com.app.smart.business.dto.DTO;
import br.com.app.smart.business.dto.RegistroAuditoriaDTO;

public class MetaDadoDTO implements Comparable<MetaDadoDTO>, DTO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nomeTela;

	private String tituloTela;

	private String descricaoTela;

	private int numeroTela;

	private String urlTela;

	private Long versao;

	private String xml;

	private String xhtml;

	private FuncionalidadeDTO funcionalidade;

	private List<IdentificadorDTO> identificadores;

	private RegistroAuditoriaDTO registroAuditoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getXhtml() {
		return xhtml;
	}

	public void setXhtml(String xhtml) {
		this.xhtml = xhtml;
	}

	public RegistroAuditoriaDTO getRegistroAuditoria() {
		return registroAuditoria;
	}

	public void setRegistroAuditoria(RegistroAuditoriaDTO registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
	}

	public int getNumeroTela() {
		return numeroTela;
	}

	public void setNumeroTela(int numeroTela) {
		this.numeroTela = numeroTela;
	}

	public String getNomeTela() {
		return nomeTela;
	}

	public void setNomeTela(String nomeTela) {
		this.nomeTela = nomeTela;
	}

	public String getTituloTela() {
		return tituloTela;
	}

	public void setTituloTela(String tituloTela) {
		this.tituloTela = tituloTela;
	}

	public String getDescricaoTela() {
		return descricaoTela;
	}

	public void setDescricaoTela(String descricaoTela) {
		this.descricaoTela = descricaoTela;
	}

	public String getUrlTela() {
		return urlTela;
	}

	public void setUrlTela(String urlTela) {
		this.urlTela = urlTela;
	}

	public List<IdentificadorDTO> getIdentificadores() {
		return identificadores;
	}

	public void setIdentificadores(List<IdentificadorDTO> identificadores) {
		this.identificadores = identificadores;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		if (!(obj instanceof MetaDadoDTO)) {

			return false;
		}

		MetaDadoDTO dto = (MetaDadoDTO) obj;

		if (this.id == null) {
			return false;
		}

		if (dto.id != this.id) {

			return false;
		}

		return true;
	}

	public int compareTo(MetaDadoDTO o) {

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

	public FuncionalidadeDTO getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(FuncionalidadeDTO funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

}
