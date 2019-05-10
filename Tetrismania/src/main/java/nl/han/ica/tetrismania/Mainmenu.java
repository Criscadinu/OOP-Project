package nl.han.ica.tetrismania;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class Mainmenu extends GameObject {
	private Tetrismania tm;

	public Mainmenu(Tetrismania tm) {
		this.tm = tm;
	}

	@Override
	public void draw(PGraphics g) {
		g.fill(0);
		g.rect(800, 600, 800, 600);

	}

	public void mousePressed(int x, int y, int button) {
		tm.startSpel();
		tm.verbergMenu();

	}

	@Override
	public void update() {

	}

}
