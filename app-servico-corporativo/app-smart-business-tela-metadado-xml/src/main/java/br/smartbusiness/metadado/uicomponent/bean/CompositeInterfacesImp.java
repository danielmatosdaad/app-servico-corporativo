package br.smartbusiness.metadado.uicomponent.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import br.com.app.smart.business.tela.componete.dto.ComponenteDTO;

@Named
public class CompositeInterfacesImp implements ICompositeInterfaces {

	private static final String CC_SHORT_DESCRIPTION = "shortDescription";

	private static final String CC_DISPLAY_NAME = "displayName";

	private static final String CC_NAME = "name";

	private static final String CC_INTERFACE = "cc:interface";

	public String nome;

	public String nomeExibicao;

	public String descricao;
	
	private Map<String, String> atributos = new HashMap<String, String>();
	
	private Componente componente;

	public CompositeInterfacesImp() {

	}

	public CompositeInterfacesImp(Componente componente) {
		super();
		Componente cpn = buscarComponente(componente);
		
		if (cpn != null) {
			this.componente = cpn;
			if (cpn.getPropriedades() != null) {
				for (Propriedade propriedade : cpn.getPropriedades()) {

					this.atributos.put(propriedade.getNome(), propriedade.getValor());
				}
			}

		}

	}

	public CompositeInterfacesImp(List<Componente> componentes) {
		super();
		Componente cpn = buscarComponente(componentes);
		
		if (cpn != null) {
			this.componente = cpn;
			if (cpn.getPropriedades() != null) {
				for (Propriedade propriedade : cpn.getPropriedades()) {

					this.atributos.put(propriedade.getNome(), propriedade.getValor());
				}
			}

		}

	}

	@Override
	public String getNome() {

		if (this.atributos != null) {
			return atributos.get(CC_NAME);
		}
		return null;
	}

	@Override
	public String getNomeExibicao() {
		if (this.atributos != null) {
			return atributos.get(CC_DISPLAY_NAME);
		}
		return null;
	}

	@Override
	public String getDescricao() {
		if (this.atributos != null) {
			return atributos.get(CC_SHORT_DESCRIPTION);
		}
		return null;
	}

	@Override
	public Map<String, String> getAtributos() {
		return this.atributos;
	}

	public static Componente buscarComponente(Componente componente) {

		if (componente == null) {

			return null;
		}

		if (componente.getNomeComponente().trim().equals(CC_INTERFACE)) {

			return componente;
		}

		return buscarComponente(componente.getComponentes());

	}

	public static Componente buscarComponente(List<Componente> componetensParam) {

		if (componetensParam == null) {

			return null;
		}

		for (Componente componente : componetensParam) {

			if (componente.getNomeComponente().trim().equals(CC_INTERFACE)) {

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

	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	public void setAtributos(Map<String, String> atributos) {
		this.atributos = atributos;
	}

}
