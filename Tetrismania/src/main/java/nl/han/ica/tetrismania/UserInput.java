package nl.han.ica.tetrismania;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class UserInput extends GameObject {

	private Steen steen;
	private Tetrismania tm;

	public UserInput(Steen s, Tetrismania tetrismania) {
		this.steen = s;
		this.tm = tetrismania;
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
		if(steen.gestopt != true) {
			if (keyCode == 39) { // Pijltjestoets rechts
				steen.naarRechts();
			} else if (keyCode == 37) { // Pijltjestoets links
				steen.naarLinks();
			} else if (keyCode == 32) { // Spatie
				steen.valNaarBodem();
			} else if (keyCode == 40) { // Pijltjestoets beneden
				steen.naarBeneden();
			} else if (keyCode == 65) { // A
				steen.draaiLinksom();
			} else if (keyCode == 68) { // D
				steen.draaiRechtsom();
			} else if (keyCode == 82) { 
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
