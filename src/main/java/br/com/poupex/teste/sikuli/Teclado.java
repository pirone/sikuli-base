package br.com.poupex.teste.sikuli;

import org.sikuli.api.robot.Key;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.desktop.DesktopKeyboard;

public class Teclado {
	
	private static Keyboard keyboard = new DesktopKeyboard();
	
	public Teclado tab() {
		keyboard.type(Key.TAB);
		return this;
	}
	
	public Teclado digita(String texto) throws InterruptedException {
		EsperaUtil.espere(1);
		keyboard.type(texto);
		return this;
	}
	
	public Teclado pressiona(String tecla) throws InterruptedException {
		EsperaUtil.espere(1);
		keyboard.type(tecla);
		return this;
	}

}
