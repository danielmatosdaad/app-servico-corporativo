package br.com.projeto.metadado.infra.comum;

import java.util.EnumSet;

public enum IdentificadorBotao implements Identificador<IdentificadorBotao> {

	IDBOTAOLOGIN("idBotaoLogin");

	private IdentificadorBotao(String valor) {

		this.id = valor;

	}

	private String id;

	public static IdentificadorBotao getInstancia(String idBotao) {

		for (IdentificadorBotao identificador : EnumSet
				.allOf(IdentificadorBotao.class)) {

			if (identificador.getId().equals(idBotao)) {
				return identificador;
			}
		}
		return null;

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public boolean isValorNegocial() {
		// TODO Auto-generated method stub
		return false;
	}

}
