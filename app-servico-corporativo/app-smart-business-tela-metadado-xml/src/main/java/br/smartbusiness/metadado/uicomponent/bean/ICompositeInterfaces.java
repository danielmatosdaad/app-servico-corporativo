package br.smartbusiness.metadado.uicomponent.bean;

import java.util.Map;

public interface ICompositeInterfaces {

	public String getNome();

	public String getNomeExibicao();

	public String getDescricao();
	
	public Map<String, String> getAtributos();
	
	public Componente getComponente();
	
}
