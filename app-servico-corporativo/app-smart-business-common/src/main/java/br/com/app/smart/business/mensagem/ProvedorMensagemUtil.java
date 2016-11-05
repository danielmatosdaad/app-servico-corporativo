package br.com.app.smart.business.mensagem;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class ProvedorMensagemUtil {

	private static ResourceBundle mensagensSistema = ResourceBundle.getBundle("mensagens");

	/**
	 * Obtem uma mensagem a partir de uma chave definida no arquivo
	 * mensagens.properties
	 * 
	 * @param chave
	 * @return mensagem
	 */
	public static String obtemMensagem(String chave) {
		if (mensagensSistema.containsKey(chave)) {
			return mensagensSistema.getString(chave);
		}

		return null;
	}

	public static String obtemMensagem(Integer codigoErro) {

		return null;
	}

	/**
	 * Obtem uma mensagem a partir de uma chave definida e formata a mensagem,
	 * inserindo os parâmetros definidos na mensagem.
	 * 
	 * @param chave
	 * @param parametros
	 * @return mensagem formatada com os parâmetros.
	 */
	public static String obtemMensagem(String chave, Object... parametros) {
		if (mensagensSistema.containsKey(chave)) {
			String mensagem = mensagensSistema.getString(chave);
			return MessageFormat.format(mensagem, parametros);
		}

		return null;
	}
}
