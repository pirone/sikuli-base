package br.com.poupex.teste.sikuli;

import java.io.File;
import java.net.URL;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.Relative;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.robot.Key;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

import br.com.poupex.teste.sikuli.exception.ElementoNaoLocalizadoException;

public class Element {
	
	static Mouse mouse = new DesktopMouse();
	static Keyboard keyboard = new DesktopKeyboard();
	static Canvas canvas = new DesktopCanvas();
	
	private ImageTarget imageTarget;
	
	private String name;
	
	private ScreenRegion screenRegion = new DesktopScreenRegion();
	
	public Element(ImageTarget imagem) {
		this.imageTarget = imagem;
		this.name = imagem.toString();
	}

	public Element(URL url) {
		this.imageTarget = new ImageTarget(url);
		this.name = url.getPath();
	}
	
	public Element(File file) {
		this.imageTarget = new ImageTarget(file);
		this.name = file.getName();
	}
	
	public Element(ScreenRegion screenRegion) {
		this.screenRegion = screenRegion;
		this.name = "Sem identificador";
	}
	
	
	public ImageTarget getImageTarget() {
		return imageTarget;
	}
	
	public ScreenRegion getScreenRegion() {
		return screenRegion;
	}

	public void setScreenRegion(ScreenRegion screenRegion) {
		this.screenRegion = screenRegion;
	}

	public Element clica() throws ElementoNaoLocalizadoException {
		try {
			mouse.click(Relative.to(localiza()).center().getScreenLocation());
			return this;
		} catch (NullPointerException e) {
			throw new ElementoNaoLocalizadoException(this.name);
		}	
	}
	
	public Element cliqueDuplo() throws ElementoNaoLocalizadoException {
		try {
			mouse.click(Relative.to(localiza()).center().getScreenLocation());
			mouse.click(Relative.to(localiza()).center().getScreenLocation());
			return this;
		} catch (NullPointerException e) {
			throw new ElementoNaoLocalizadoException(this.name);
		}
	}
	
	public Element digita(String texto) throws ElementoNaoLocalizadoException {
		try {
			mouse.click(Relative.to(localiza()).center().getScreenLocation());
			keyboard.type(Key.HOME);
			keyboard.type(texto);
			return this;
		} catch (NullPointerException e) {
			throw new ElementoNaoLocalizadoException(this.name);
		}
	}
	
	public ScreenRegion localiza() {
		return screenRegion.find(imageTarget);
	}
	
	public Element localiza(Element element) throws ElementoNaoLocalizadoException {
		try {
			return new Element(localiza().find(element.getImageTarget()));
		} catch (NullPointerException e) {
			throw new ElementoNaoLocalizadoException(this.name);
		}
	}
	
	public Boolean localizado() {
		return screenRegion.find(imageTarget) != null && localiza().getScore() > 0.9;
	}
	
	public Element esperarElementoVisivel() {
		EsperaUtil.esperaElementoVisivel(imageTarget);
		return this;
	}
	
	public Element esperarElementoVisivelPor(int segundos) {
		EsperaUtil.esperaElementoVisivel(imageTarget, segundos);
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
