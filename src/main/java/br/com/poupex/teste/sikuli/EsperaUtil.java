package br.com.poupex.teste.sikuli;

import org.sikuli.api.ImageTarget;

public class EsperaUtil {
	
	private static final int TIME_OUT = 20000;

	public static void espere(int segundos) throws InterruptedException {
		Thread.sleep(segundos * 1000);
	}
	
	/**
	 * Espera um elemento ficar vísivel com timeout definido nesta classe(padrão 20 segundos)
	 * @param elemento
	 */
	public static void esperaElementoVisivel(Element elemento) {
		elemento.getScreenRegion().wait(elemento.getImageTarget(), TIME_OUT);
	}
	
	/**
	 * Espera um elemento ficar vísivel com timeout definido nesta classe(padrão 20 segundos)
	 * @param elemento
	 */
	public static void esperaElementoVisivel(ImageTarget target) {
		new Element(target).getScreenRegion().wait(target, TIME_OUT);
	}
	

	/**
	 * Espera elemento visível até determinado limite de tempo informado
	 * @param elemento
	 * @param segundos
	 */
	public static void esperaElementoVisivel(Element elemento, int segundos) {
		elemento.getScreenRegion().wait(elemento.getImageTarget(), segundos * 1000);
	}
	

	/**
	 * Espera elemento visível até determinado limite de tempo informado
	 * @param target
	 * @param segundos
	 */
	public static void esperaElementoVisivel(ImageTarget target, int segundos) {
		new Element(target).getScreenRegion().wait(target, segundos * 1000);
	}

}
