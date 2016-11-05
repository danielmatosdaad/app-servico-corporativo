package br.com.app.smart.business.conta.dto;

import java.io.Serializable;
import java.util.List;

import br.com.app.smart.business.dto.DTO;
import br.com.app.smart.business.dto.RegistroAuditoriaDTO;

public class AssinaturaDTO implements DTO, Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	
	private List<ContratoDTO> contratos;

	private List<ContaDTO> contas;
	
	
	private RegistroAuditoriaDTO registroAuditoria;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	public List<ContratoDTO> getContratos() {
		return contratos;
	}

	public void setContratos(List<ContratoDTO> contratos) {
		this.contratos = contratos;
	}

	public List<ContaDTO> getContas() {
		return contas;
	}

	public void setContas(List<ContaDTO> contas) {
		this.contas = contas;
	}

	public RegistroAuditoriaDTO getRegistroAuditoria() {
		return registroAuditoria;
	}

	public void setRegistroAuditoria(RegistroAuditoriaDTO registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
	}
	
	

}
