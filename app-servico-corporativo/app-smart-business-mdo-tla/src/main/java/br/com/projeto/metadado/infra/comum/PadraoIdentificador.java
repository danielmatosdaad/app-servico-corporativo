package br.com.projeto.metadado.infra.comum;

public enum PadraoIdentificador {

	PADRAO_IDENTIFICADOR_BEAN("idBean") {
		@Override
		public FactoryIdentificador getFabricaIdentificador() {
			// TODO Auto-generated method stub
			return FactoryIdentificador.BEAN;
		}
	}, 
	PADRAO_IDENTIFICADOR_NEGOCIAL("idNegocial") {
		@Override
		public FactoryIdentificador getFabricaIdentificador() {
			// TODO Auto-generated method stub
			return FactoryIdentificador.NEGOCIAL;
		}
	};

	private PadraoIdentificador(String valor) {

		this.valor = valor;
	}

	String valor;

	public String getValor() {
		return valor;
	}
	
	
	public abstract FactoryIdentificador getFabricaIdentificador();

}
