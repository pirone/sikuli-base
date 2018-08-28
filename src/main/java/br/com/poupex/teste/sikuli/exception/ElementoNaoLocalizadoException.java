package br.com.poupex.teste.sikuli.exception;

public class ElementoNaoLocalizadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ElementoNaoLocalizadoException() {
		super("Nao foi possivel localizar o elemento");
	}
	
	public ElementoNaoLocalizadoException(String elemento) {
		super("Nao foi possivel localizar o elemento: "+elemento );
	}

}
