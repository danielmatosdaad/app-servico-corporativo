package br.com.projeto.metadado.infra.comum;

import java.util.List;

public class MetadadoUI {

	private StringBufferOutputStream metadado;
	private List<IdentificadorWrapper> identificadoreNegocialMetadados;
	private List<IdentificadorWrapper> identificadoreBeanMetadados;

	public StringBufferOutputStream getMetadado() {
		return metadado;
	}

	public void setMetadado(StringBufferOutputStream metadado) {
		this.metadado = metadado;
	}

	public List<IdentificadorWrapper> getIdentificadoreNegocialMetadados() {
		return identificadoreNegocialMetadados;
	}

	public void setIdentificadoreNegocialMetadados(
			List<IdentificadorWrapper> identificadoreNegocialMetadados) {
		this.identificadoreNegocialMetadados = identificadoreNegocialMetadados;
	}

	public List<IdentificadorWrapper> getIdentificadoreBeanMetadados() {
		return identificadoreBeanMetadados;
	}

	public void setIdentificadoreBeanMetadados(
			List<IdentificadorWrapper> identificadoreBeanMetadados) {
		this.identificadoreBeanMetadados = identificadoreBeanMetadados;
	}

}
