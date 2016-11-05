package br.com.projeto.metadado.infra.comum;

public enum FactoryIdentificador {

	NEGOCIAL(PadraoIdentificador.PADRAO_IDENTIFICADOR_NEGOCIAL), 
	BEAN(PadraoIdentificador.PADRAO_IDENTIFICADOR_BEAN);

	FactoryIdentificador(PadraoIdentificador valor) {

		this.identificadorPadrao = valor;

	}

	PadraoIdentificador identificadorPadrao;

	public PadraoIdentificador getIdentificadorPadrao() {
		return identificadorPadrao;
	}



	public static Identificador<?> getInstancia(
			FactoryIdentificador identificador, String valor) {

		switch (identificador) {
		case NEGOCIAL:
			return IdentificadorNegocial.getInstancia(valor);
		case BEAN:
			return IdentificadorBean.getInstancia(valor);
		default:
			break;
		}
		return null;
	}
}
