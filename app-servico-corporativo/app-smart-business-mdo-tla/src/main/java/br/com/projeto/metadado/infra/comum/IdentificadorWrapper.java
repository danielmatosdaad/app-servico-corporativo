package br.com.projeto.metadado.infra.comum;

public class IdentificadorWrapper<T extends Identificador> {

	private T wrapper;

	public IdentificadorWrapper(T identificador) {

		this.wrapper = identificador;

	}

	public T getWrapper() {
		return wrapper;
	}

	public void setWrapper(T wrapper) {
		this.wrapper = wrapper;
	}

}
