package br.com.app.smart.business.parametro.dto;

import java.util.EnumSet;
import java.util.Set;

public enum TipoParametroDTO {

	CARACTER(1, "Texto"), NUMERAL(2, "Numerico"), FLUTUANTE(3, "Decimal"), DATA(4, "Data"), DATAHORA(5,
			"Data e Hora"), INDEFINIDO(-1, "Indefinido");

	private int value;
	private String texto;

	private TipoParametroDTO(int valor, String texto) {

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

	public static TipoParametroDTO get(int value) {

		Set<TipoParametroDTO> tipos = EnumSet.allOf(TipoParametroDTO.class);
		for (TipoParametroDTO tipoParametroDTO : tipos) {
			if (tipoParametroDTO.value == value) {
				return tipoParametroDTO;
			}
		}
		return INDEFINIDO;
	}
	
	

}