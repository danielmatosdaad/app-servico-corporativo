package br.com.app.smart.business.conta.dto;

import java.io.Serializable;
import java.util.List;

import br.com.app.smart.business.dto.DTO;
import br.com.app.smart.business.dto.RegistroAuditoriaDTO;

public class ContratoDTO implements DTO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String clausula;

	private List<AssinaturaDTO> assinaturas;

	private RegistroAuditoriaDTO registroAuditoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	public List<AssinaturaDTO> getAssinaturas() {
		return assinaturas;
	}

	public void setAssinaturas(List<AssinaturaDTO> assinaturas) {
		this.assinaturas = assinaturas;
	}

	public String getClausula() {
		return clausula;
	}

	public void setClausula(String clausula) {
		this.clausula = clausula;
	}

	public RegistroAuditoriaDTO getRegistroAuditoria() {
		return registroAuditoria;
	}

	public void setRegistroAuditoria(RegistroAuditoriaDTO registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
	}

}
