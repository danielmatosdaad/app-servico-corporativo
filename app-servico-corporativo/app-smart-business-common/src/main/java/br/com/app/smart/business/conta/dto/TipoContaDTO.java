package br.com.app.smart.business.conta.dto;

public enum TipoContaDTO {

	MASTER(1);

	private Integer value;

	private TipoContaDTO(Integer valor) {

		this.value = valor;
	}

	public Integer getValue() {
		return value;
	}
}
