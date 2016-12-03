package br.com.metadado.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.facelet.bean.ComponenteFacelet;
import br.com.projeto.facelet.bean.Facelet;
import br.com.projeto.facelet.bean.PropriedadeComponenteFacelet;
import br.com.projeto.metadado.bean.Componente;
import br.com.projeto.metadado.bean.Conteudo;
import br.com.projeto.metadado.bean.MetaDado;
import br.com.projeto.metadado.bean.Propriedade;

public class ConversorMetadadoFacelet {

	private static final String NS_PROJETO_COMPONENTES = "http://url.projeto/componentes";

	public static MetaDado converter(Facelet facelet) {

		String nomeMetadado = facelet.getNomeMetadado().replace(".xhtml", "");

		List<Propriedade> propriedades = new ArrayList<Propriedade>();
		for (ComponenteFacelet componenteFacelet : facelet.getConteudo().getComponentes()) {
			for (PropriedadeComponenteFacelet propriedadeComponenteFacelet : componenteFacelet.getPropriedades()) {
				Propriedade prop = new Propriedade();

				if (UiComponentUtil.isVariavelUiComponent(propriedadeComponenteFacelet.getValor())) {

					String id = UiComponentUtil.retirarExpressaoEL(propriedadeComponenteFacelet.getValor());
					prop.setNome(id);
					prop.setValor(id);
					propriedades.add(prop);
				} else {
					prop.setNome(propriedadeComponenteFacelet.getNome());
					prop.setValor(propriedadeComponenteFacelet.getValor());
					propriedades.add(prop);
				}

			}
		}
		Componente componente = new Componente(nomeMetadado, NS_PROJETO_COMPONENTES, propriedades);
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		componentes.add(componente);
		Conteudo conteudo = new Conteudo(componentes);
		conteudo.setNomeConteudo("html");
		MetaDado metadado = new MetaDado(conteudo);
		return metadado;

	}


	public static Facelet converter(MetaDado metadado) {

		return null;
	}
}
