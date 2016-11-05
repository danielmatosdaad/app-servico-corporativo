package br.com.projeto.metadado.infra.comum;

import java.util.EnumSet;

public enum IdentificadorBean implements Identificador<IdentificadorBean> {

	MENU_PRINCIPAL_BEAN("idMenuPrincipal"), 
	PAINEL_CONFIRMACAO_PAGAMENTO_BEAN("idPainelConfirmacaoPagamentoTitulo"), 
	PAINEL_COMPROVANTE_PAGAMENTO_BEAN("idPainelComprovantePagamentoTitulo"),  
	TABELA_CONFIRMACAO("idTabelaConfirmacao");

	IdentificadorBean(String id) {
		this.id = id;
	}

	private String id;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public boolean isValorNegocial() {
		// TODO Auto-generated method stub
		return false;
	}

	public static IdentificadorBean getInstancia(String valor) {

		for (IdentificadorBean identificador : EnumSet
				.allOf(IdentificadorBean.class)) {

			if (identificador.getId().equals(valor)) {

				return identificador;
			}
		}
		return null;
	}

}
