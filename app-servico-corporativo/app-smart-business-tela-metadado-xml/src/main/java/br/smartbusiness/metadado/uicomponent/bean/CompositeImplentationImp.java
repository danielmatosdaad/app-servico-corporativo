package br.smartbusiness.metadado.uicomponent.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompositeImplentationImp implements ICompositeImplentation {

	private static final String CC_IMPLEMETATION = "cc:implementation";

	private Componente componente = null;

	private Map<String, String> atributos = new HashMap<String, String>();

	public CompositeImplentationImp() {
	}

	public CompositeImplentationImp(Componente componente) {
		super();
		Componente cnp = buscarComponente(componente);
		if (cnp != null) {

			this.componente = cnp;
			configuraPropriedades(cnp);

		}

	}

	private void configuraPropriedades(Componente cnp) {
		if (cnp.getPropriedades() != null) {
			for (Propriedade propriedade : cnp.getPropriedades()) {

				this.atributos.put(propriedade.getNome(), propriedade.getValor());
			}
		}
	}

	public CompositeImplentationImp(List<Componente> componentes) {
		super();
		Componente componente = buscarComponente(componentes);
		if (componente != null) {
			this.componente = componente;
		}
		configuraPropriedades(componente);
	}

	public static Componente buscarComponente(Componente componente) {

		if (componente == null) {

			return null;
		}

		if (componente.getNomeComponente().trim().equals(CC_IMPLEMETATION)) {

			return componente;
		}

		return buscarComponente(componente.getComponentes());

	}

	public static Componente buscarComponente(List<Componente> componetensParam) {

		if (componetensParam == null) {

			return null;
		}

		for (Componente componente : componetensParam) {

			if (componente.getNomeComponente().trim().equals(CC_IMPLEMETATION)) {

				return componente;
			}

			if (componente.getComponentes() != null && !componente.getComponentes().isEmpty()) {

				Componente subComponente = buscarComponente(componente.getComponentes());
				if (subComponente != null) {

					return subComponente;
				}

			}
		}

		return null;

	}

	@Override
	public Componente getComponente() {
		return this.componente;
	}

	public Map<String, String> getAtributos() {
		return atributos;
	}

	public void setAtributos(Map<String, String> atributos) {
		this.atributos = atributos;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

}
