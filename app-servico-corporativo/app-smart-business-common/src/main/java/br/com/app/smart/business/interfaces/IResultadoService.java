package br.com.app.smart.business.interfaces;

public interface IResultadoService<D> {

	public D getResposta();

	public Boolean isSucesso();

	public String getMensagem();
}
