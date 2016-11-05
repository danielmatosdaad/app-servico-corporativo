package br.com.projeto.metadado.infra.comum;

import java.util.EnumSet;
import java.util.List;

public enum IdentificadorNegocial implements
		Identificador<IdentificadorNegocial> {


	IDLABELUSUARIO("idLabelUsuario"),
	IDLABELSENHA("idLabelSenha"),
	IDLOGIN("idLogin"),
	IDSENHA("idSenha"),
	IDLABELCODIGOBARRAS("idLabelCodigoBarras"),
	IDCODIGOBARRASCAMPO1("idCodigoBarrasCampo1"),
	IDCODIGOBARRASCAMPO2("idCodigoBarrasCampo2"),
	IDCODIGOBARRASCAMPO3("idCodigoBarrasCampo3"),
	IDCODIGOBARRASCAMPO4("idCodigoBarrasCampo4"),
	IDCODIGOBARRASCAMPOCOMPLEOTO("idCodigoBarrasCompleto"),
	IDLABELCODIGOBARRASCONFIRMACAO("idLabelCodigoBarrasConfirmacao"),
	PARAMETRO_OCULTO("idParametroOculto");

	private String id;

	private IdentificadorNegocial(String valor) {

		this.id = valor;
	}

	@Override
	public String getId() {
		return id;
	}

	public static IdentificadorNegocial getInstancia(String valor) {

		for (IdentificadorNegocial identificador : EnumSet
				.allOf(IdentificadorNegocial.class)) {
			if (identificador.getId().equals(valor))
				return identificador;
		}
		return null;
	}

	public boolean comparar(String valor) {

		return this.id.equals(valor);
	}
	
	@Override
	public boolean isValorNegocial() {
		// TODO Auto-generated method stub
		if(!this.id.contains("idLabel")){
			
			return true;
		}
		return false;
	}

}
