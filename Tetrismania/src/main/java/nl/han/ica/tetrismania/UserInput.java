package nl.han.ica.tetrismania;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class UserInput extends GameObject {

	private Steen steen;
	private Tetrismania tm;

	public UserInput(Steen s, Tetrismania tm) {
		this.steen = s;
		this.tm = tm;
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(PGraphics g) {

	}

	public void updateSteen(Steen steen) {
		this.steen = steen;
	}

	public void keyPressed(int keyCode, char key) {
//		System.out.println(keyCode);
		if(steen.gestopt != true) {
			if (keyCode == 39) { // +
				steen.naarRechts();
			} else if (keyCode == 37) {
				steen.naarLinks();
			} else if (keyCode == 32) {
				steen.valNaarBodem();
			} else if (keyCode == 40) {
				steen.naarBeneden();
			} else if (keyCode == 65) {
				steen.draaiLinksom();
			} else if (keyCode == 68) {
				steen.draaiRechtsom();
			} else if (keyCode == 82) { // r
				tm.maakNieuweSteen();
			}	
		}
		
	}

	/**
	 * This event is fired when the GameEngine received a key release.
	 * 
	 * @param keyCode
	 * @param key
	 */
	public void keyReleased(int keyCode, char key) {
	}

}
