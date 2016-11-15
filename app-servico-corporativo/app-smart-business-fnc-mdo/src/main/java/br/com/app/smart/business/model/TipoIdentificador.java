package br.com.app.smart.business.model;

import java.util.EnumSet;
import java.util.Set;

public enum TipoIdentificador {

	NEGOCIAL(1, "Negocial"), BEAN(2, "Bean"), COMPONENTE_TELA(3, "ComponenteTela"), INDEFINIDO(-1, "Indefinido");

	private int value;
	private String texto;

	private TipoIdentificador(int valor, String texto) {

		this.value = valor;
		this.texto = texto;

	}

	public int getValue() {

		return value;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static TipoIdentificador get(int value) {

		Set<TipoIdentificador> tipos = EnumSet.allOf(TipoIdentificador.class);
		for (TipoIdentificador tipoParametroDTO : tipos) {
			if (tipoParametroDTO.value == value) {
				return tipoParametroDTO;
			}
		}
		return INDEFINIDO;
	}

}
