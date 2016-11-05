package br.com.projeto.metadado.bean;

import java.util.ArrayList;
import java.util.List;

public class MetadadoMock {

	
	public static MetaDado criarMetadadoLogin() {

		
		List<Propriedade> propriedadesEntradaDados = new ArrayList<Propriedade>();
		List<Propriedade> propriedadesBotao = new ArrayList<Propriedade>();
		List<Componente> componentes = new ArrayList<Componente>();
		Propriedade e1 = new Propriedade("idNegocialLabel", "idLabelUsuario");
		Propriedade e2 = new Propriedade("valorLabel", "Nome Usuario");
		Propriedade e3 = new Propriedade("visivel", "true");
		Propriedade e4 = new Propriedade("idNegocialTexto", "idLogin");
		Propriedade e5 = new Propriedade("valorText", "#{componenteMB.parametros['idLogin']}");

		propriedadesEntradaDados.add(e1);
		propriedadesEntradaDados.add(e2);
		propriedadesEntradaDados.add(e3);
		propriedadesEntradaDados.add(e4);
		propriedadesEntradaDados.add(e5);
		
		
		Componente entrada = new Componente("entradadados",
				"http://url.projeto/componentes", propriedadesEntradaDados);
		
		
		List<Propriedade> propriedadesEntradaDadosSenha = new ArrayList<Propriedade>();
		Propriedade e6 = new Propriedade("idNegocialLabel", "idLabelSenha");
		Propriedade e7 = new Propriedade("valorLabel", "Senha");
		Propriedade e8 = new Propriedade("visivel", "true");
		Propriedade e9 = new Propriedade("idNegocialTexto", "idSenha");
		Propriedade e10 = new Propriedade("valorText", "#{componenteMB.parametros['idSenha']}");

		propriedadesEntradaDadosSenha.add(e6);
		propriedadesEntradaDadosSenha.add(e7);
		propriedadesEntradaDadosSenha.add(e8);
		propriedadesEntradaDadosSenha.add(e9);
		propriedadesEntradaDadosSenha.add(e10);
		
		Componente entradaSenha = new Componente("entradadados",
				"http://url.projeto/componentes", propriedadesEntradaDadosSenha);
		
		
		Propriedade b1 = new Propriedade("idBotao", "idBotaoLogin");
		Propriedade b2 = new Propriedade("acaoRequisicao", "LOGIN");
		Propriedade b3 = new Propriedade("acaoFluxo", "PROXIMO");
		Propriedade b4 = new Propriedade("numeroTela", "1");
		Propriedade b5 = new Propriedade("numeroFuncionalidade", "1");
		Propriedade b6 = new Propriedade("nomeBotao", "Entrar");
		propriedadesBotao.add(b1);
		propriedadesBotao.add(b2);
		propriedadesBotao.add(b3);
		propriedadesBotao.add(b4);
		propriedadesBotao.add(b5);
		propriedadesBotao.add(b6);
		Componente botao = new Componente("botao",
				"http://url.projeto/componentes", propriedadesBotao);

		componentes.add(entrada);
		componentes.add(entradaSenha);
		componentes.add(botao);

		Conteudo conteudo = new Conteudo(componentes);
		conteudo.setNomeConteudo("html");
		MetaDado metadado = new MetaDado(conteudo);

		return metadado;

	}

public static MetaDado criarMetadadoTelaPrincipal() {

	
	List<Propriedade> propriedadeMenu = new ArrayList<Propriedade>();
	List<Componente> componentes = new ArrayList<Componente>();
	Propriedade p = new Propriedade("idBeanMenuPrincipal", "idMenuPrincipal");
	Propriedade p2 = new Propriedade("idBeanObjetoMenuPrincipal", "#{componenteMB.bean['idMenuPrincipal']}");
	propriedadeMenu.add(p);
	propriedadeMenu.add(p2);
	
	Componente menu = new Componente("menu",
			"http://url.projeto/componentes", propriedadeMenu);

	componentes.add(menu);

	Conteudo conteudo = new Conteudo(componentes);
	conteudo.setNomeConteudo("html");
	MetaDado metadado = new MetaDado(conteudo);

	return metadado;

}

public static MetaDado criarMetadadoTelaIncialPagamentoTitulo() {

	
	List<Propriedade> propriedadesEntradaDados = new ArrayList<Propriedade>();

	List<Componente> componentes = new ArrayList<Componente>();
	Propriedade e1 = new Propriedade("idNegocialLabel", "idLabelCodigoBarras");
	Propriedade e2 = new Propriedade("valorLabel", "Codigo Barras Titulo");
	
	Propriedade e3 = new Propriedade("idNegocialCDBA", "idCodigoBarrasCampo1");
	Propriedade e4 = new Propriedade("valorCodigoBarrasA", "#{componenteMB.parametros['idCodigoBarrasCampo1']}");
	
	Propriedade e5 = new Propriedade("idNegocialCDBB", "idCodigoBarrasCampo2");
	Propriedade e6 = new Propriedade("valorCodigoBarrasB", "#{componenteMB.parametros['idCodigoBarrasCampo2']}");
	
	Propriedade e7 = new Propriedade("idNegocialCDBC", "idCodigoBarrasCampo3");
	Propriedade e8 = new Propriedade("valorCodigoBarrasC", "#{componenteMB.parametros['idCodigoBarrasCampo3']}");

	Propriedade e9 = new Propriedade("idNegocialCDBD", "idCodigoBarrasCampo4");
	Propriedade e10 = new Propriedade("valorCodigoBarrasD", "#{componenteMB.parametros['idCodigoBarrasCampo4']}");
	
	
	
	propriedadesEntradaDados.add(e1);
	propriedadesEntradaDados.add(e2);
	propriedadesEntradaDados.add(e3);
	propriedadesEntradaDados.add(e4);
	propriedadesEntradaDados.add(e5);
	propriedadesEntradaDados.add(e6);
	propriedadesEntradaDados.add(e7);
	propriedadesEntradaDados.add(e8);
	propriedadesEntradaDados.add(e9);
	propriedadesEntradaDados.add(e10);
	
	
	Componente entrada = new Componente("codigoBarras",
			"http://url.projeto/componentes", propriedadesEntradaDados);
	
	List<Propriedade> propriedadesBotao = new ArrayList<Propriedade>();
	Propriedade b1 = new Propriedade("idBotao", "idBotaoPagamentoTitulo");
	Propriedade b2 = new Propriedade("acaoRequisicao", "PAGAMENTO_TITULO");
	Propriedade b3 = new Propriedade("acaoFluxo", "PROXIMO");
	Propriedade b4 = new Propriedade("numeroTela", "2");
	Propriedade b5 = new Propriedade("numeroFuncionalidade", "3");
	Propriedade b6 = new Propriedade("nomeBotao", "Pagar");
	
	propriedadesBotao.add(b1);
	propriedadesBotao.add(b2);
	propriedadesBotao.add(b3);
	propriedadesBotao.add(b4);
	propriedadesBotao.add(b5);
	propriedadesBotao.add(b6);
	
	Componente botao = new Componente("botao",
			"http://url.projeto/componentes", propriedadesBotao);
	
	componentes.add(entrada);
	componentes.add(botao);


	Conteudo conteudo = new Conteudo(componentes);
	conteudo.setNomeConteudo("html");
	MetaDado metadado = new MetaDado(conteudo);

	return metadado;

}

public static MetaDado criarMetadadoTelaConfirmacaoPagamentoTitulo() {

	//raiz componente
	List<Componente> componentes = new ArrayList<Componente>();
	
	//propriedades titulo
	List<Propriedade> propriedadetitulo = new ArrayList<Propriedade>();
	Propriedade e1 = new Propriedade("idNegocialLabel", "idLabelCodigoBarrasConfirmacao");
	Propriedade e2 = new Propriedade("valorLabel", "Confirmacao Pagamento Titulo");
	
	propriedadetitulo.add(e1);
	propriedadetitulo.add(e2);
	
	//propriedade painel
	List<Propriedade> propriedadePainel = new ArrayList<Propriedade>();
	
	Propriedade e3 = new Propriedade("idBeanPainel", "idPainelConfirmacaoPagamentoTitulo");
	Propriedade e4 = new Propriedade("idBeanObjetoPainelLabelDuplo", "#{componenteMB.bean['idPainelConfirmacaoPagamentoTitulo']}");
	
	propriedadePainel.add(e3);
	propriedadePainel.add(e4);
	
	Componente painelConfirmacao = new Componente("painelLabelDuplo",
			"http://url.projeto/componentes", propriedadePainel);
	
	Componente titulo = new Componente("titulo",
			"http://url.projeto/componentes", propriedadetitulo);
	
	List<Propriedade> propriedadesBotao = new ArrayList<Propriedade>();
	Propriedade b1 = new Propriedade("idBotao", "idBotaoConfirmacaoPagamentoTitulo");
	Propriedade b2 = new Propriedade("acaoRequisicao", "PAGAMENTO_TITULO");
	Propriedade b3 = new Propriedade("acaoFluxo", "PROXIMO");
	Propriedade b4 = new Propriedade("numeroTela", "3");
	Propriedade b5 = new Propriedade("numeroFuncionalidade", "3");
	Propriedade b6 = new Propriedade("nomeBotao", "Confirmar");
	
	propriedadesBotao.add(b1);
	propriedadesBotao.add(b2);
	propriedadesBotao.add(b3);
	propriedadesBotao.add(b4);
	propriedadesBotao.add(b5);
	propriedadesBotao.add(b6);
	
	Componente botaoConfirmar = new Componente("botao",
			"http://url.projeto/componentes", propriedadesBotao);
	
	List<Propriedade> propriedadesBotaoCancelar = new ArrayList<Propriedade>();
	Propriedade c1 = new Propriedade("idBotao", "idBotaoCancelarPagamentoTitulo");
	Propriedade c2 = new Propriedade("acaoRequisicao", "PAGAMENTO_TITULO");
	Propriedade c3 = new Propriedade("acaoFluxo", "ANTERIOR");
	Propriedade c4 = new Propriedade("numeroTela", "1");
	Propriedade c5 = new Propriedade("numeroFuncionalidade", "3");
	Propriedade c6 = new Propriedade("nomeBotao", "Cancelar");
	
	propriedadesBotaoCancelar.add(c1);
	propriedadesBotaoCancelar.add(c2);
	propriedadesBotaoCancelar.add(c3);
	propriedadesBotaoCancelar.add(c4);
	propriedadesBotaoCancelar.add(c5);
	propriedadesBotaoCancelar.add(c6);
	
	Componente botaoCancelar = new Componente("botao",
			"http://url.projeto/componentes", propriedadesBotaoCancelar);
	
	componentes.add(titulo);
	componentes.add(painelConfirmacao);
	componentes.add(botaoCancelar);
	componentes.add(botaoConfirmar);


	Conteudo conteudo = new Conteudo(componentes);
	conteudo.setNomeConteudo("html");
	MetaDado metadado = new MetaDado(conteudo);

	return metadado;

}

public static MetaDado criarMetadadoTelaComprovantePagamentoTitulo() {
	//raiz componente
		List<Componente> componentes = new ArrayList<Componente>();
		
		//propriedades titulo
		List<Propriedade> propriedadetitulo = new ArrayList<Propriedade>();
		Propriedade e1 = new Propriedade("idNegocialLabel", "idLabelCodigoBarrasComprovante");
		Propriedade e2 = new Propriedade("valorLabel", "Comprovante Pagamento Titulo");
		
		propriedadetitulo.add(e1);
		propriedadetitulo.add(e2);
		
		//propriedade painel
		List<Propriedade> propriedadePainel = new ArrayList<Propriedade>();
		
		Propriedade e3 = new Propriedade("idBeanPainel", "idPainelComprovantePagamentoTitulo");
		Propriedade e4 = new Propriedade("idBeanObjetoPainelLabelDuplo", "#{componenteMB.bean['idPainelComprovantePagamentoTitulo']}");
		
		propriedadePainel.add(e3);
		propriedadePainel.add(e4);
		
		Componente painelConfirmacao = new Componente("painelLabelDuplo",
				"http://url.projeto/componentes", propriedadePainel);
		
		Componente titulo = new Componente("titulo",
				"http://url.projeto/componentes", propriedadetitulo);
		
		List<Propriedade> propriedadesBotao = new ArrayList<Propriedade>();
		Propriedade b1 = new Propriedade("idBotao", "idBotaoConfirmacaoPagamentoTitulo");
		Propriedade b2 = new Propriedade("acaoRequisicao", "PAGAMENTO_TITULO");
		Propriedade b3 = new Propriedade("acaoFluxo", "PROXIMO");
		Propriedade b4 = new Propriedade("numeroTela", "3");
		Propriedade b5 = new Propriedade("numeroFuncionalidade", "3");
		Propriedade b6 = new Propriedade("nomeBotao", "Imprimir");
		
		propriedadesBotao.add(b1);
		propriedadesBotao.add(b2);
		propriedadesBotao.add(b3);
		propriedadesBotao.add(b4);
		propriedadesBotao.add(b5);
		propriedadesBotao.add(b6);
		
		Componente botaoConfirmar = new Componente("botao",
				"http://url.projeto/componentes", propriedadesBotao);
		
		List<Propriedade> propriedadesBotaoCancelar = new ArrayList<Propriedade>();
		Propriedade c1 = new Propriedade("idBotao", "idBotaoCancelarPagamentoTitulo");
		Propriedade c2 = new Propriedade("acaoRequisicao", "PAGAMENTO_TITULO");
		Propriedade c3 = new Propriedade("acaoFluxo", "ANTERIOR");
		Propriedade c4 = new Propriedade("numeroTela", "1");
		Propriedade c5 = new Propriedade("numeroFuncionalidade", "3");
		Propriedade c6 = new Propriedade("nomeBotao", "Fazer Outro Pagamento");
		
		propriedadesBotaoCancelar.add(c1);
		propriedadesBotaoCancelar.add(c2);
		propriedadesBotaoCancelar.add(c3);
		propriedadesBotaoCancelar.add(c4);
		propriedadesBotaoCancelar.add(c5);
		propriedadesBotaoCancelar.add(c6);
		
		Componente botaoCancelar = new Componente("botao",
				"http://url.projeto/componentes", propriedadesBotaoCancelar);
		
		componentes.add(titulo);
		componentes.add(painelConfirmacao);
		componentes.add(botaoCancelar);
		componentes.add(botaoConfirmar);


		Conteudo conteudo = new Conteudo(componentes);
		conteudo.setNomeConteudo("html");
		MetaDado metadado = new MetaDado(conteudo);

		return metadado;
	
}
}
