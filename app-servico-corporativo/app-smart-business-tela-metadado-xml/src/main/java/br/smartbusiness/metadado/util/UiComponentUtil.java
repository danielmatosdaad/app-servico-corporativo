package br.smartbusiness.metadado.util;

public class UiComponentUtil {

	public static boolean isVariavelUiComponent(String valor) {
		if (valor == null || valor.trim().length() == 0) {
			return false;
		}
		return (valor.toUpperCase().contains("NEGOCIAL") || valor.toUpperCase().contains("BEAN")
				|| valor.toUpperCase().contains("COMPONENTETELA") ||valor.toUpperCase().contains("VARUI") );
	}

	public static String retirarExpressaoEL(String valor) {

		if (valor == null || valor.trim().length() == 0) {
			return "";
		}

		String semExpresaoEL = valor.replace("#{\"", "");
		semExpresaoEL = semExpresaoEL.replace("#{", "");
		semExpresaoEL = semExpresaoEL.replace("\"}", "");
		semExpresaoEL = semExpresaoEL.replace("}", "");

		return semExpresaoEL;
	}
}
