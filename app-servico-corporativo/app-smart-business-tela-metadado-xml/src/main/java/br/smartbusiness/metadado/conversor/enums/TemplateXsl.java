package br.smartbusiness.metadado.conversor.enums;

public enum TemplateXsl {

	COMPOSITE_METADADO("composite_metadado.xslt"), 
	METADADO_UI("metadado_ui.xslt"), 
	COMPOSITE_ALL_COMPONENTE("composite_all_componente.xslt");

	private TemplateXsl(String valor) {
		this.valor = valor;
	}

	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
