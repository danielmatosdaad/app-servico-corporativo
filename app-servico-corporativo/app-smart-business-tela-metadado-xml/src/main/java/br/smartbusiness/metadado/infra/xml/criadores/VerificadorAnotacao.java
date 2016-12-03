package br.smartbusiness.metadado.infra.xml.criadores;

import java.lang.annotation.Annotation;

public class VerificadorAnotacao {

	public static boolean validar(Object objeto, Class anotacao) {
		Class<?> classe = objeto.getClass();
		Annotation[] arrayAnotacoes = classe.getDeclaredAnnotations();
		for (Annotation annotation : arrayAnotacoes) {
			if (annotation.annotationType().equals(anotacao)) {
				return true;
			}
		}
		return false;
	}
}
