package br.smartbusiness.metadado.infra.comum;

public enum PadraoIdentificador {

	PADRAO_IDENTIFICADOR_BEAN("id-bean"), PADRAO_IDENTIFICADOR_NEGOCIAL("id-negocial");

	private PadraoIdentificador(String valor) {

		this.valor = valor;
	}

	String valor;

	public String getValor() {
		return valor;
	}

}
