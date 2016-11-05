package br.com.app.smart.business.exception;

public class NegocioException extends TransacaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegocioException() {
		// TODO Auto-generated constructor stub
	}

	public NegocioException(Exception e) {
		super(e);
	}

	public NegocioException(String descricao, Exception e) {
		super(descricao, e);
	}

	public NegocioException(int codioErro, String descricao) {
		super(codioErro, descricao);
	}

}
